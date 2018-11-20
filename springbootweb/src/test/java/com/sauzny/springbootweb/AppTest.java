package com.sauzny.springbootweb;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class AppTest {

    @Test
    public void test001(){
        log.info("int的最大值是：{}", Integer.MAX_VALUE);
    }
}
