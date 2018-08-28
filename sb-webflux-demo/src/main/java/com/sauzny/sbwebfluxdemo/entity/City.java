package com.sauzny.sbwebfluxdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class City {

	public City() {}
	
	private long id;
	
	private String name;
}