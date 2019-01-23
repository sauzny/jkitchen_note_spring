package com.sauzny.sbshirodemo.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class CodecUtils {

    public static String uuid(){
        return UUID.randomUUID().toString();
    }
    
    public static String createSalt(){

    	// 这是一种比较好的生成盐值的方法，但是linux下有效率的问题，当然可以解决的
    	/*
        String result = "";
        try {
            Random random = SecureRandom.getInstanceStrong();
            byte[] salt = new byte[6];
            random.nextBytes(salt);    
            result = Base64.encodeBase64URLSafeString(salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        */
    	

        // 我就直接换用一种简单的随机字符串
    	String result = RandomStringUtils.randomAlphabetic(8);
    	
        return result;
    }
    
    public static String sha512(String text){
        return DigestUtils.sha512Hex(text);
    }

    public static void main(String[] args) {
    	for(int i=0; i<30; i++) {
    		long a = System.currentTimeMillis();
        	String s = CodecUtils.createSalt();	
    		long b = System.currentTimeMillis();
    		System.out.println( (b-a) + " - " + s);
    	}
	}
}
