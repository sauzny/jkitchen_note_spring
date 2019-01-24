package com.sauzny.sbshirodemo.system.shiro;

import com.sauzny.sbshirodemo.utils.ControllerUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/***************************************************************************
 *
 * @时间: 2019/1/24 - 11:22
 *
 * @描述: TODO
 *
 ***************************************************************************/

@Slf4j
public class MyShiroFilter extends BasicHttpAuthenticationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {

        log.debug("MyShiroFilter isAccessAllowed");

        String userName = ControllerUtils.getUserName((HttpServletRequest) request);
        Integer userId = ControllerUtils.getLoginUserId((HttpServletRequest) request);

        if(StringUtils.isBlank(userName)){
            return false;
        }

        getSubject(request, response).login(new UsernamePasswordToken(userName, userId.toString()));

        return true;
    }
}
