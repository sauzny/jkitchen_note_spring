package com.sauzny.springbootweb.system.jwt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sauzny.springbootweb.SpringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.sauzny.springbootweb.SbwConstant;
import com.sauzny.springbootweb.controller.vo.RestFulResult;
import com.sauzny.springbootweb.utils.JwtUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order(2)
@WebFilter(
        filterName = "JwtFilter",
        //添加需要拦截的url
        urlPatterns={
                SbwConstant.Controller.PASSPORT_CONTROLLER_MAPPING+"/isLogin",
                SbwConstant.Controller.PASSPORT_CONTROLLER_MAPPING+"/logout",
                SbwConstant.Controller.USER_CONTROLLER_MAPPING+"/*"
        },

        //排除这个路径api/demand/gettypelist
        initParams = @WebInitParam(
                name = "exclusions",
                value = "api/demand/gettypelist")
)
public class JwtFilter extends GenericFilterBean {

    @Autowired
    private Audience audience;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * @param req
     * @param res
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
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
                if(stringRedisTemplate == null){
                    BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
                    stringRedisTemplate = (StringRedisTemplate) factory.getBean("stringRedisTemplate");
                }
                final DecodedJWT jwt = JwtUtils.verify(token,audience.getBase64Secret());
                if(jwt == null){
                    // 验证不通过
                    this.tokenIllegal(response, "jwt is null");
                    return;
                }
                if(!stringRedisTemplate.hasKey(jwt.getId())){
                    // 验证不通过
                    this.tokenIllegal(response, "redis not has jit");
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
