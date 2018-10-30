package com.sauzny.sbutilsdemo.entity;

import java.util.Date;

import com.sauzny.sbutilsdemo.utils.JacksonUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	
	private Long id;
	
	private Long number;
	
	private String address;
	
	private String name;
	
	private Integer age;
	
	private Date birthday;
	
	public String toString() {
		return JacksonUtils.nonNull().toJson(this);
	}
}
