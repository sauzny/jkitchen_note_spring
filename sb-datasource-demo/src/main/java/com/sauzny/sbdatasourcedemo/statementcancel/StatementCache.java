package com.sauzny.sbdatasourcedemo.statementcancel;

import java.sql.PreparedStatement;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;

@Component
public class StatementCache{
	
	private Map<String, PreparedStatement> cache = Maps.newConcurrentMap();
	
	public PreparedStatement put(String key, PreparedStatement value) {
		return cache.put(key, value);
	}
	
	public PreparedStatement get(String key) {
		return cache.get(key);
	}
	
	public PreparedStatement remove(String key) {
		return cache.remove(key);
	}
}
