package com.sauzny.sbshirodemo.system.shiro;

import com.sauzny.sbshirodemo.entity.pojo.User;
import com.sauzny.sbshirodemo.service.PermissionService;
import com.sauzny.sbshirodemo.service.UserService;
import com.sauzny.sbshirodemo.system.shiro.jwt.ShiroJwtToken;
import com.sauzny.sbshirodemo.system.shiro.jwt.ShiroJwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
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

    public UserRealm(){
        // 设置 token 为自定的 ShiroJwtToken
        this.setAuthenticationTokenClass(ShiroJwtToken.class);
    }

    /**
     * 获取授权信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.debug("doGetAuthorizationInfo");
        Long userId = ShiroJwtUtils.getUserId(principalCollection.getPrimaryPrincipal());
        List<String> sysPermissions = permissionService.selectPermissionByUserId(userId);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(sysPermissions);
        log.debug("{} {}", userId, sysPermissions);
        return info;
    }

    /**
     * 获取身份验证信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.debug("doGetAuthenticationInfo");
        ShiroJwtToken token = ShiroJwtUtils.getInstance(authenticationToken);
        User user = userService.findOne(token.getUserId());
        if (user == null) {
            throw new AuthenticationException("无法获取身份信息");
        }
        return new SimpleAuthenticationInfo(token.getPrincipal(), token.getCredentials(), getName());
    }
}
