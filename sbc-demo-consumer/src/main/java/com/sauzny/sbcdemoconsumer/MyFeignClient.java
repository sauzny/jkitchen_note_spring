package com.sauzny.sbcdemoconsumer;

import org.joda.time.LocalDateTime;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import feign.hystrix.FallbackFactory;

@FeignClient(name = "sbc-demo-provider", fallbackFactory=MyHystrixFallbackFactory.class)
public interface MyFeignClient {

    @GetMapping(value = "/ling")
    String ling();
    
    @GetMapping(value = "/yi")
    String yi();
    
    @GetMapping(value = "/er")
    String er();
    
    @GetMapping(value = "/san")
    String san();
    
    @GetMapping(value = "/ba")
    String ba();
}


@Component
class MyHystrixFallbackFactory implements FallbackFactory<MyFeignClient> {
    @Override
    public MyFeignClient create(Throwable cause) {
        return new MyFeignClient() {
            @Override
            public String ling() {
                return "hystrix test ling" + LocalDateTime.now();
            }

            @Override
            public String yi() {
                return "hystrix test yi" + LocalDateTime.now();
            }

            @Override
            public String er() {
                return "hystrix test er" + LocalDateTime.now();
            }

            @Override
            public String san() {
                return "hystrix test san" + LocalDateTime.now();
            }

            @Override
            public String ba() {
                return "hystrix test ba" + LocalDateTime.now();
            }
        };
    }
}