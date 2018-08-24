package com.sauzny.sbfluxdemo;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.sauzny.sbwebfluxdemo.entity.City;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class CityTest {

	private static final WebClient client = WebClient.create("http://127.0.0.1:8080");
	
	@Test
	public void findOneCity() {
		
		Mono<City> result = client.get()
				.uri("/city/{id}", 1L)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(City.class);
		
		City city = result.block();
		
		log.info("findOneCity result = {}", city);
	}
	
	@Test
	public void saveCity() {
		
		City city = new City();
		city.setId(1);
		city.setName("加利福尼亚");
		
		Mono<City> cityMono = Mono.just(city);
		
		Mono<Long> id = client.post()
				.uri("/city")
				.accept(MediaType.APPLICATION_JSON)
				.body(cityMono, City.class)
				.retrieve()
				.bodyToMono(Long.class);
		
		log.info("saveCity result = {}", id.block());
	}
}
