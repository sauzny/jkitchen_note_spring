package com.sauzny.springbootweb.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.sauzny.springbootweb.SbwConstant;
import com.sauzny.springbootweb.controller.vo.RestFulResult;
import com.sauzny.springbootweb.utils.JwtUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
        final HttpServletResponse response = (HttpServletResponse) res;
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        //等到请求头信息token信息
        final String token = request.getHeader(SbwConstant.Jwt.TOKEN);
        log.info("jwt filter, token {}", token);
        
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
                request.setAttribute(SbwConstant.Jwt.ROLE_ID, jwt.getClaim(SbwConstant.Jwt.ROLE_ID).asString());
                
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
        log.info("jwt验证不通过,{}",message);
        
        String json = RestFulResult.failure(SbwConstant.FailureEnum.TOKEN_ILLEGAL).toJson();
        PrintWriter out = response.getWriter();
        out.write(json);
        out.close();
    }
}
