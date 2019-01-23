package com.sauzny.sbshirodemo.system.jwt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sauzny.sbshirodemo.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.sauzny.sbshirodemo.SbwConstant;
import com.sauzny.sbshirodemo.controller.vo.RestFulResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order(SbwConstant.FilterOrder.JWTFILTER)
@WebFilter(
        filterName = "JwtFilter",
        //添加需要拦截的url
        urlPatterns={
                SbwConstant.Controller.PASSPORT_CONTROLLER_MAPPING+"/logout",
                SbwConstant.Controller.USER_CONTROLLER_MAPPING+"/*"
        },

        //排除路径
        initParams = @WebInitParam(
                name = "exclusions",
                value = SbwConstant.Controller.USER_CONTROLLER_MAPPING+"/help")
)
public class JwtFilter extends GenericFilterBean {

    @Autowired
    private Audience audience;

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
            throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) req;

        // 得到请求头信息token信息
        final String token = request.getHeader(SbwConstant.Jwt.TOKEN);
        log.debug("token is {}", token);

        // 跳过jwt验证
        if(token == null && audience.getNeedjump()){
            log.debug("jump jwt");
            if(audience.getJumppassword().equals(request.getHeader(SbwConstant.Jwt.JUMP_TOKEN))){
                request.setAttribute(SbwConstant.Jwt.USER_ID, request.getHeader(SbwConstant.Jwt.USER_ID));
                chain.doFilter(req, res);
                return;
            }
        }

        final HttpServletResponse response = (HttpServletResponse) res;
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(req, res);
        } else {

            if (StringUtils.isBlank(token)) {
                // 验证不通过
                this.tokenIllegal(response, "token is blank");
                return;
            }

            try {
                if(audience == null){
                    BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
                    audience = (Audience) factory.getBean("audience");
                }
                final DecodedJWT jwt = JwtUtils.verify(token,audience.getBase64Secret());
                if(jwt == null){
                    // 验证不通过
                    this.tokenIllegal(response, "jwt is null");
                    return;
                }

                request.setAttribute(SbwConstant.Jwt.TOKEN, jwt);
                request.setAttribute(SbwConstant.Jwt.JTI, jwt.getId());
                request.setAttribute(SbwConstant.Jwt.USER_ID, jwt.getClaim(SbwConstant.Jwt.USER_ID).asString());

            } catch (final Exception e) {
                // 验证不通过
                this.tokenIllegal(response, "jwt解析异常");
                log.debug(e.getMessage());
                return;
            }

            chain.doFilter(req, res);
        }
    }
    
    private void tokenIllegal(final HttpServletResponse response, String message) throws IOException {
        log.debug("jwt验证不通过,{}",message);
        
        String json = RestFulResult.failure(SbwConstant.FailureEnum.TOKEN_ILLEGAL).toJson();
        PrintWriter out = response.getWriter();
        out.write(json);
        out.close();
    }
}
