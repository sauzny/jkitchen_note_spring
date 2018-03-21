package com.sauzny.springbootweb.utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtils {

    /**
     * 解析jwt
     */
    public static DecodedJWT verify(String token, String base64Security) {
        DecodedJWT jwt = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(base64Security);
            JWTVerifier verifier = JWT.require(algorithm).build(); //Reusable verifier instance
            jwt = verifier.verify(token);
        } catch (UnsupportedEncodingException exception){
            //UTF-8 encoding not supported
        } catch (JWTVerificationException exception){
            //Invalid signature/claims
        }
        return jwt;
    }

    /**
     * 构建jwt
     */
    public static String create(String jwtId, Date expiresAt, Map<String, String> payloadClaims, String base64Security) {

        String token = "";

        // head
        Map<String, Object> headerClaims = new HashMap<String, Object>();
        headerClaims.put("alg", "HS256");
        headerClaims.put("typ", "JWT");

        // 创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
        /*
        Map<String, Object> payloadClaims = new HashMap<String, Object>();
        payloadClaims.put("userId", userId);
        payloadClaims.put("userName", userName);
        payloadClaims.put("roleId", roleId);
        */
        
        try {
            Builder builder = JWT.create()
                    .withHeader(headerClaims)
                    .withJWTId(jwtId)
                    .withExpiresAt(expiresAt);
            
            payloadClaims.forEach((k,v) -> builder.withClaim(k, v));
            
            token = builder.sign(Algorithm.HMAC256(base64Security));       
                    
        } catch (UnsupportedEncodingException exception) {
            // UTF-8 encoding not supported
        } catch (JWTCreationException exception) {
            // Invalid Signing configuration / Couldn't convert Claims.
        }
        return token;
    }
}

