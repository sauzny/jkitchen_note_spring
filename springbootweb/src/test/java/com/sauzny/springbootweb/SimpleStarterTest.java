package com.sauzny.springbootweb;

import com.sauzny.starter.service.ExampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/***************************************************************************
 *
 * @时间: 2019/3/7 - 14:53
 *
 * @描述: TODO
 *
 ***************************************************************************/

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleStarterTest {

    @Autowired
    private ExampleService exampleService;

    @Test
    public void testStarter() {
        System.out.println(exampleService.wrap("hello"));
    }
}
