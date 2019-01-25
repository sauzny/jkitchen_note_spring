package com.sauzny.sbshirodemo.system.jwt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.Lists;
import com.sauzny.sbshirodemo.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.sauzny.sbshirodemo.SbwConstant;
import com.sauzny.sbshirodemo.controller.vo.RestFulResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order(SbwConstant.FilterOrder.JWTFILTER)
@WebFilter(
        filterName = "JwtFilter",
        //排除路径
        initParams = @WebInitParam(
                name = "exclusions",
                value = SbwConstant.Controller.USER_CONTROLLER_MAPPING+"/help"+",/favicon.ico"),

        //添加需要拦截的url
        urlPatterns={
                SbwConstant.Controller.PASSPORT_CONTROLLER_MAPPING+"/logout",
                SbwConstant.Controller.USER_CONTROLLER_MAPPING+"/*"
        }

)
public class JwtFilter implements Filter {

    @Autowired
    private Audience audience;

    private List<String> exclusionList;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String exclusions = filterConfig.getInitParameter("exclusions");
        exclusionList = Lists.newArrayList(exclusions.split(","));
    }

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
            throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;

        log.debug("排除路径 - {}", exclusionList);
        log.debug("当前路径 - {}", request.getRequestURI().replaceAll(request.getContextPath(), ""));

        if(exclusionList.contains(request.getRequestURI().replaceAll(request.getContextPath(), ""))){
            chain.doFilter(request, response);
        } else if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(req, res);
        } else {

            // 得到请求头信息token信息
            final String token = request.getHeader(SbwConstant.Jwt.TOKEN);
            log.debug("token is {}", token);

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
                request.setAttribute(SbwConstant.Jwt.USER_NAME, jwt.getClaim(SbwConstant.Jwt.USER_NAME).asString());

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

        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        String json = RestFulResult.failure(SbwConstant.FailureEnum.TOKEN_ILLEGAL).toJson();
        PrintWriter out = response.getWriter();
        out.write(json);
        out.close();
    }
}
