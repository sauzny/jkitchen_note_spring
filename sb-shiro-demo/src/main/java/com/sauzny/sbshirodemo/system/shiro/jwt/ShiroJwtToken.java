package com.sauzny.sbshirodemo.system.shiro.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/***************************************************************************
 *
 * @时间: 2019/1/28 - 10:15
 *
 * @描述: TODO
 *
 ***************************************************************************/
public class ShiroJwtToken implements AuthenticationToken {

    private Long userId;

    private String token;

    public ShiroJwtToken(Long userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return userId;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public String toString() {
        return "ShiroJwtToken{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                '}';
    }
}
