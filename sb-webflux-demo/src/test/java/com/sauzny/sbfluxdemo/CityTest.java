package com.sauzny.sbfluxdemo;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import com.sauzny.sbwebfluxdemo.entity.City;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class CityTest {

	private static final WebClient client = WebClient.create("http://127.0.0.1:8080");
	
	@Test
	public void findOneCity() throws InterruptedException {
		
		Mono<City> result = client.get()
				.uri("/city/{id}", 1003L)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(City.class);
		
		//City city = result.block();
		
		result.subscribe(city -> {
			log.info("findOneCity result = {}", city);
		});
		
		// 犹豫是异步的获取数据，这里sleep1秒，保证在Console中能看见打印
		TimeUnit.SECONDS.sleep(1);
	}
	
	@Test
	public void saveCity() throws InterruptedException {
		
		City city = new City();
		city.setId(1);
		city.setName("加利福尼亚");
		
		Mono<City> cityMono = Mono.just(city);
		
		Mono<Long> result = client.post()
				.uri("/city")
				.accept(MediaType.APPLICATION_JSON)
				.body(cityMono, City.class)
				.retrieve()
				.bodyToMono(Long.class);
		
		result.subscribe(id -> {
			log.info("saveCity result = {}", id);
		});
		
		// 犹豫是异步的获取数据，这里sleep1秒，保证在Console中能看见打印
		TimeUnit.SECONDS.sleep(1);
	}
	
	@Test
	public void form() throws InterruptedException {
		
	    MultipartBodyBuilder builder = new MultipartBodyBuilder();
	    builder.part("name", "aihcbiashciou");
	    builder.part("city", new City(9999L, "README.adoc"));
	    builder.part("filePart", new FileSystemResource("README.adoc"));
	    MultiValueMap<String, HttpEntity<?>> parts = builder.build();
	    
	    Mono<String> result = client.post()
	            .uri("/form")
	            .syncBody(parts)
	            .retrieve()
	            .bodyToMono(String.class);
	    

		result.subscribe(name -> {
			log.info("form result = {}", name);
		});
		
		// 犹豫是异步的获取数据，这里sleep1秒，保证在Console中能看见打印
		TimeUnit.SECONDS.sleep(1);
	}
}
