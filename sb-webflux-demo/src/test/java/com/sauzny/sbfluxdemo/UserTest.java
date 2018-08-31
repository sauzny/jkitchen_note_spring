package com.sauzny.sbfluxdemo;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.github.javafaker.Faker;
import com.sauzny.sbwebfluxdemo.entity.User;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class UserTest {

	private static final WebClient client = WebClient.create("http://127.0.0.1:8080");
	
	public static Faker faker = new Faker(new Locale("zh","CN"));
	
	@Test
	public void save() throws InterruptedException {
		User data = new User(
				faker.idNumber().invalid(),
				faker.name().name(),
				faker.name().fullName(),
				faker.phoneNumber().phoneNumber(),
				faker.date().birthday()
				);
		
		log.info("{}", data);
		
		Mono<User> userMono = Mono.just(data);
		
		Mono<User> result = client.post()
				.uri("/user")
				.accept(MediaType.APPLICATION_JSON)
				.body(userMono, User.class)
				.retrieve()
				.bodyToMono(User.class);
		
		result.subscribe(user -> {
			log.info("save result = {}", user);
		});
		
		// 犹豫是异步的获取数据，这里sleep1秒，保证在Console中能看见打印
		TimeUnit.SECONDS.sleep(1);
	}
}
