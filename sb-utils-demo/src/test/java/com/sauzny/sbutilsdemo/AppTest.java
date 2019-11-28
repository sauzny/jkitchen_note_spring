package com.sauzny.sbutilsdemo;

import com.sauzny.sbutilsdemo.annotation.AnnotationService;
import com.sauzny.sbutilsdemo.other.SpringPropertyPlaceholderHelper;
import com.sauzny.sbutilsdemo.other.SpringSystemProperty;
import com.sauzny.sbutilsdemo.resouce.SpringAnnotation1;
import com.sauzny.sbutilsdemo.resouce.SpringAnnotation2;
import com.sauzny.sbutilsdemo.web.SpringHtml;
import com.sauzny.sbutilsdemo.web.SpringJavaScript;
import com.sauzny.sbutilsdemo.web.SpringWeb;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class AppTest {

    @Autowired
    private SpringAnnotation1 springAnnotation1;

    @Autowired
    private SpringAnnotation2 springAnnotation2;

    @Autowired
    private SpringSystemProperty springSystemProperty;

    @Autowired
    private SpringPropertyPlaceholderHelper springPropertyPlaceholderHelper;

    @Autowired
    private SpringHtml springHtml;

    @Autowired
    private SpringJavaScript springJavaScript;

    @Autowired
    private SpringWeb springWeb;

    @Autowired
    private AnnotationService annotationService;

    @Test
    public void test001() throws InterruptedException {

        log.info("hello, {}", "测试类");

        // 不结束进程
        Thread.currentThread().join();
    }

    @Test
    public void resource() {
        springAnnotation1.demo();
        springAnnotation2.demo();
    }

    @Test
    public void other() {
        springSystemProperty.demo();
        springPropertyPlaceholderHelper.demo();
    }

    @Test
    public void web() {
        springHtml.demo();
        springJavaScript.demo();
        springWeb.demo();
    }

    @Test
    public void annotation() {
		annotationService.test();
    }
}
