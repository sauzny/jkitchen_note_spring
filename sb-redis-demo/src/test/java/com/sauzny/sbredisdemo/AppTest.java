package com.sauzny.sbredisdemo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.stream.*;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.stream.StreamMessageListenerContainer;
import org.springframework.data.redis.stream.Subscription;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StopWatch;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
@Slf4j
public class AppTest {

    //@Autowired
    //private ReactiveRedisTemplate template;

    @Autowired
    private RedisTemplate<String, String> template;

    //@Autowired
    //private StreamMessageListenerContainer<String, MapRecord<String, String, String>> messageListenerContainer;

    @Before
    public void init(){

        LettuceConnectionFactory lettuceConnectionFactory = (LettuceConnectionFactory) template.getConnectionFactory();

        // 开启连接池
        lettuceConnectionFactory.setShareNativeConnection(false);

        /*
        template.getClientList().forEach(client -> {
            log.info("{}", client);
        });
        */
        log.info("RedisTemplate是否开启连接池 {}", !lettuceConnectionFactory.getShareNativeConnection());
    }

    //@After
    public void join(){
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void singleSlotOperation() {

        for(int i=0; i<10000; i++){
            template.opsForValue().set("n"+i, "rand al'thor"+i);
        }
        List<Integer> list = Lists.newArrayList();

        for(int i=0; i<10000; i++){
            list.add(i);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(16);

        log.info("预热结束，开始插入数据");


        StopWatch sw = new StopWatch();
        sw.start();
        /*
        List<Integer> result = list.parallelStream().map(i -> {
            template.opsForValue().set("name"+i, "rand al'thor"+i);
            return 1;
        }).collect(Collectors.toList());
        */

        List<CompletableFuture<Integer>> result1 = list.parallelStream().map(i -> CompletableFuture.supplyAsync(() -> {
            template.opsForValue().set("name" + i, "rand al'thor" + i);
            return 1;
        }, executorService)).collect(Collectors.toList());

        List<Integer> result = result1.parallelStream().map(CompletableFuture::join).collect(Collectors.toList());

        log.info("result = {}", result);
        log.info("result.size() = {}", result.size());
        sw.stop();
        log.info("TotalTimeMillis = {}", sw.getTotalTimeMillis());
        //assertThat(template.opsForValue().get("name"), is("rand al'thor"));
    }

    @Test
    public void streamFoo01(){

        StreamMessageListenerContainer<String, MapRecord<String, String, String>> messageListenerContainer = StreamMessageListenerContainer.create(template.getConnectionFactory());


        // container autostart is disabled by default
        /*
        if (!messageListenerContainer.isRunning()) {
            messageListenerContainer.start();
        }
        */
        // XREAD BLOCK
        /*
        messageListenerContainer.receive(
                Consumer.from("my-group-1", "consumer-1"),
                StreamOffset.fromStart("my-stream"),
                entries -> log.info("{}", entries)
        );
        */
        IntStream.range(1, 10).forEach(i -> {
            Map<String, String> raw = Maps.newHashMap();
            raw.put(i+"foo1", i+"bar1");
            raw.put(i+"foo2", i+"bar2");
            StringRecord record1 = StreamRecords.string(raw).withStreamKey("stream1");
            StringRecord record2 = StreamRecords.string(raw).withStreamKey("stream2");

            template.opsForStream().add(record1);
            template.opsForStream().add(record2);
        });

        log.info("插入数据完毕");

        //template.opsForStream().add(record).as
/*

        template.opsForStream().read(
                Consumer.from("my-group", "my-consumer"),
                StreamReadOptions.empty().count(2),
                StreamOffset.create("my-stream", ReadOffset.lastConsumed())
        );
*/

    }
}
