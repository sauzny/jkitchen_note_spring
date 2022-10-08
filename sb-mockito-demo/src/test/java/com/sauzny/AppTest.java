package com.sauzny;

import com.sauzny.b1.B1Service;
import com.sauzny.b2.B2Service;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * Unit test for simple App.
 */
@Slf4j
@SpringBootTest
public class AppTest {

    @Autowired
    private B2Service b2Service;

    @MockBean
    private B1Service b1Service;

    @Test
    public void shouldAnswerWithTrue() {
        String abc = "王老五";

        BDDMockito.given(b1Service.deal1()).willReturn("deal123");

        Assertions.assertEquals("deal123", b2Service.deal2());
        log.info("hello world {} {}", abc, b2Service.deal2());
    }
}
