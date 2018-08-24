package com.sauzny.sbfluxdemo;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;

public class WebSocketTest {

	private static WebSocketClient client = new ReactorNettyWebSocketClient();

	
	public static URI url(String path) {
		URI url = null;
		try {
			url = new URI("ws://localhost:8080"+path);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	@Test
	public void foo01() {
		client.execute(url("/path1"), session ->
		
        session.receive()
                .doOnNext(System.out::println)
                .then());
	}
	
	@Test
	public void foo02() {
		client.execute(url("/path2"), session ->
        session.receive()
                .doOnNext(System.out::println)
                .then());
	}
	
	@Test
	public void foo03() {
		client.execute(url("/path2"), session ->
        session.receive()
                .doOnNext(System.out::println)
                .then());
	}
	
}
