package com.sauzny.sbshirodemo.system.shiro;

import com.sauzny.sbshirodemo.SbwConstant;
import com.sauzny.sbshirodemo.utils.ControllerUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/***************************************************************************
 *
 * @时间: 2019/1/25 - 15:28
 *
 * @描述: TODO
 *
 ***************************************************************************/
@Slf4j
public class StatelessShiroFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Subject subject = getSubject(servletRequest, servletResponse);
        if(subject.getPrincipal() == null){
            UsernamePasswordToken token = new UsernamePasswordToken(
                    ControllerUtils.getUserName((HttpServletRequest) servletRequest),
                    SbwConstant.Shiro.TOKEN_DEFAULT_PASSWORD
            );
            log.debug("subject.getPrincipal() = null -> login");
            subject.login(token);
        }
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        return false;
    }
}
