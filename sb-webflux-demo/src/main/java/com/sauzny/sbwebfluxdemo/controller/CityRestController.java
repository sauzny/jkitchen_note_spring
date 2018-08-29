package com.sauzny.sbwebfluxdemo.controller;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sauzny.sbwebfluxdemo.entity.City;
import com.sauzny.sbwebfluxdemo.service.CityService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/city")
@Slf4j
public class CityRestController {
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
        binder.registerCustomEditor(LocalDateTime.class, new CustomDateEditor(dateFormat, false));
    }
	
	@Autowired
    private CityService cityService;
	
	@GetMapping("/{id}")
    public Mono<City> findOneCity(@PathVariable("id") Long id) {
    	
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityService.findCityById(id)));
    }
/*
    @GetMapping
    public Flux<City> findAllCity() {
        return Flux.create(cityFluxSink -> {
            cityService.findAllCity().forEach(city -> {
                cityFluxSink.next(city);
            });
            cityFluxSink.complete();
        });
    }
*/
	// 使用浏览器访问此接口，可以看见每个元素间隔1秒的时间输出
	// 测试用例也能查看出效果CityTest findAll1()
    @GetMapping(value = "", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<City> findAll() {
        //return this.userService.findAll().delayElements(Duration.ofSeconds(2));

        Flux<City> result = Flux.create(cityFluxSink -> {
            cityService.findAllCity().forEach(city -> {
                cityFluxSink.next(city);
            });
            cityFluxSink.complete();
        });
        
        return result.delayElements(Duration.ofSeconds(1));
    }
    
    @PostMapping
    public Mono<City> createCity(@RequestBody City city, ServerHttpRequest request) {
    	log.info("在注解方式下获取request，getMethodValue = {}", request.getMethodValue());
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityService.saveCity(city)));
    }

    @PutMapping
    public Mono<City> modifyCity(@RequestBody City city) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityService.updateCity(city)));
    }

    @DeleteMapping("/{id}")
    public Mono<City> modifyCity(@PathVariable("id") Long id) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityService.deleteCity(id)));
    }

    // 单向无限流
    // 1.MediaType.TEXT_EVENT_STREAM表示Content-Type为text/event-stream，即SSE；
    // 2.利用interval生成每秒一个数据的流。
    @GetMapping(value = "/times", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> sendTimePerSec(ServerHttpRequest request) {
        return Flux.interval(Duration.ofSeconds(1)).   // 2
                map(l -> new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }

}

