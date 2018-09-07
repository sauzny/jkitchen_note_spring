package com.sauzny.sbfluxdemo;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import com.github.javafaker.Faker;
import com.sauzny.sbwebfluxdemo.controller.vo.WebFluxResult;
import com.sauzny.sbwebfluxdemo.entity.City;
import com.sauzny.sbwebfluxdemo.entity.User;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class CityTest {

	private static final WebClient client = WebClient.create("http://127.0.0.1:8080");
	public static Faker faker = new Faker(new Locale("zh","CN"));
	
	@Test
    public void findAll() throws InterruptedException {
		client.get().uri("/city")
	        .accept(MediaType.APPLICATION_STREAM_JSON) // 2
	        .exchange() // 3
	        .flatMapMany(response -> response.bodyToFlux(City.class))   // 4
	        .doOnNext(System.out::println)  // 5
	        .blockLast();   // 6
    }
	
	@Test
	public void findOneCity() throws InterruptedException {
		
		Mono<City> result = client.get()
				.uri("/city/{id}", 1536142001943L)
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
		
		City data = new City();
		data.setId(System.currentTimeMillis());
		data.setName("加利福尼亚");
		
		Mono<City> cityMono = Mono.just(data);
		
		Mono<WebFluxResult> webFluxResult = client.post()
				.uri("/city")
				.accept(MediaType.APPLICATION_JSON)
				.body(cityMono, City.class)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError, clientResponse -> {
					log.info("saveCity is4xxClientError result = {}", clientResponse.statusCode());
					
					//return clientResponse.bodyToMono(WebFluxResult.class);
					
					return Mono.empty();
				})
				.onStatus(HttpStatus::is2xxSuccessful, clientResponse -> {
					log.info("saveCity is2xxSuccessful result = {}", clientResponse.statusCode());
					
					//return clientResponse.bodyToMono(WebFluxResult.class);
					return Mono.empty();
				})
				.bodyToMono(WebFluxResult.class);

		webFluxResult.subscribe(result -> {
			log.info("saveCity result = {}", result);
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
	
    @Test
    public void times() throws InterruptedException {
		client.get().uri("/city/times")
	        .accept(MediaType.TEXT_EVENT_STREAM)    // 1
	        .retrieve()
	        .bodyToFlux(String.class)
	        .log()  // 2
	        .take(10)   // 3
	        .blockLast();
    }
	
}
