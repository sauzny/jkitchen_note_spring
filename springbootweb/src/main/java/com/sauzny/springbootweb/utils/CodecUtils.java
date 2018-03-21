package com.sauzny.springbootweb.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class CodecUtils {

    public static String uuid(){
        return UUID.randomUUID().toString();
    }
    
    public static String createSalt(){
        String result = "";
        try {
            Random random = SecureRandom.getInstanceStrong();
            byte[] salt = new byte[6];
            random.nextBytes(salt);    
            result = Base64.encodeBase64URLSafeString(salt);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
    
    public static String sha512(String text){
        return DigestUtils.sha512Hex(text);
    }

}
