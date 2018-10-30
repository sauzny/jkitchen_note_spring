package com.sauzny.sbutilsdemo.utils;

import java.util.Locale;

import com.github.javafaker.Faker;

public final class MyUtils {

	public static Faker faker = new Faker(new Locale("zh","CN")) ;
	
	public static void sleep(Long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
