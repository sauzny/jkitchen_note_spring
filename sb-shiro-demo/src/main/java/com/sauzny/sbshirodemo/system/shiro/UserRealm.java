package com.sauzny.sbshirodemo.system.shiro;

import com.sauzny.sbshirodemo.entity.pojo.User;
import com.sauzny.sbshirodemo.service.PermissionService;
import com.sauzny.sbshirodemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/***************************************************************************
 *
 * @时间: 2018/12/28 - 9:48
 *
 * @描述: TODO
 *
 ***************************************************************************/
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("doGetAuthorizationInfo");
        User user = (User) principalCollection.getPrimaryPrincipal();
        List<String> sysPermissions = permissionService.selectPermissionByUserId(user.getUserId());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(sysPermissions);
        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.findByUserName(token.getUsername());
        if (user == null) {
            return null;
        }
        log.info("doGetAuthenticationInfo");
        return new SimpleAuthenticationInfo(user, user.getPassword().toCharArray(), ByteSource.Util.bytes(user.getSalt()), getName());
    }
}
