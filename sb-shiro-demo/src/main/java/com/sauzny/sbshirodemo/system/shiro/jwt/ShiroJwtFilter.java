package com.sauzny.sbshirodemo.system.shiro.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.sauzny.sbshirodemo.SbwConstant;
import com.sauzny.sbshirodemo.controller.vo.RestFulResult;
import com.sauzny.sbshirodemo.utils.ControllerUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/***************************************************************************
 *
 * @时间: 2019/1/25 - 15:28
 *
 * @描述: TODO
 *
 ***************************************************************************/
@Slf4j
public class ShiroJwtFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 校验token合法性
        DecodedJWT jwt  = ShiroJwtUtils.decodeJwt(request);
        boolean isCorrect = ShiroJwtUtils.verify(jwt);

        Subject subject = getSubject(request, response);

        if(isCorrect){

            // 向 request中设置相关 attribute
            ShiroJwtUtils.setAttribute(request, jwt);

            // 如果 subject 中的 principa 为空，需要 执行一次login
            if(subject.getPrincipal() == null){
                ShiroJwtToken token = ShiroJwtUtils.getInstance(request);
                subject.login(token);
                log.debug("login token {}", token);
            }
        }else{
            ShiroJwtUtils.tokenIllegal(response);
        }

        return isCorrect;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        return false;
    }
}
