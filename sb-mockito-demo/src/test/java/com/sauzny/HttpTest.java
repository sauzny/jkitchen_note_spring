package com.sauzny;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: liujinxin
 * @time: 2021/11/5 14:02
 */
@Slf4j
@SpringBootTest
public class HttpTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void baidu(){
        restTemplate.getForObject("{{api}}{{v1-zx}}{{admin-service}}/feedback/app/mtList", String.class);
    }
}
