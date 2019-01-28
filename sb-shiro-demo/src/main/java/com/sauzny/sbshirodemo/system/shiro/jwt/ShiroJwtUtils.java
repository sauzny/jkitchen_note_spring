package com.sauzny.sbshirodemo.system.shiro.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.sauzny.sbshirodemo.SbwConstant;
import com.sauzny.sbshirodemo.controller.vo.RestFulResult;
import com.sauzny.sbshirodemo.utils.ControllerUtils;
import com.sauzny.sbshirodemo.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.MediaType;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/***************************************************************************
 *
 * @时间: 2019/1/28 - 10:35
 *
 * @描述: TODO
 *
 ***************************************************************************/
public final class ShiroJwtUtils {

    public static ShiroJwtToken getInstance(HttpServletRequest request){
        return new ShiroJwtToken(
                ControllerUtils.getLoginUserId(request),
                ControllerUtils.getToken(request)
        );
    }

    public static ShiroJwtToken getInstance(AuthenticationToken authenticationToken){
        return (ShiroJwtToken) authenticationToken;
    }

    public static Long getUserId(Object PrimaryPrincipal) {
        return (Long) PrimaryPrincipal;
    }

    public static DecodedJWT decodeJwt(HttpServletRequest request){

        DecodedJWT jwt = null;

        final String token = request.getHeader(SbwConstant.Jwt.TOKEN);

        if (StringUtils.isNotBlank(token)) {
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            Audience audience = (Audience) factory.getBean("audience");
            jwt = JwtUtils.verify(token, audience.getBase64Secret());
        }

        return jwt;
    }

    public static boolean verify(DecodedJWT jwt){
        return jwt != null;
    }

    public static void setAttribute(HttpServletRequest request, DecodedJWT jwt){

        request.setAttribute(SbwConstant.Jwt.TOKEN, jwt);
        request.setAttribute(SbwConstant.Jwt.JTI, jwt.getId());
        request.setAttribute(SbwConstant.Jwt.USER_ID, jwt.getClaim(SbwConstant.Jwt.USER_ID).asString());
        request.setAttribute(SbwConstant.Jwt.USER_NAME, jwt.getClaim(SbwConstant.Jwt.USER_NAME).asString());
    }

    public static void tokenIllegal(HttpServletResponse response) throws IOException {

        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        String json = RestFulResult.failure(SbwConstant.FailureEnum.TOKEN_ILLEGAL).toJson();
        PrintWriter out = response.getWriter();
        out.write(json);
        out.close();
    }
}
