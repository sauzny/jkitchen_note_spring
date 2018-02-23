package com.sauzny.springmvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;  

@RunWith(SpringJUnit4ClassRunner.class)  
@WebAppConfiguration  
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/spring-mvc.xml"})  
// do rollback  
@Rollback(value=true)
@Transactional
public class AppTesting {
    
    @Autowired  
    private WebApplicationContext wac;  
      
    private MockMvc mockMvc;
    private MockHttpSession session;  

    @Before  
    public void setup() {  
        // init applicationContext  
        this.mockMvc = webAppContextSetup(wac).build();
        this.session = new MockHttpSession();  
    }  
    

    @Test
    public void demo() throws Exception {

        this.mockMvc.perform(
                        (get("/test01"))
                            .accept(MediaType.parseMediaType("application/json;charset=UTF-8"))
                    )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andDo(print());
        
        /*
        this.mockMvc  
                .perform((post("/user/userMsg"))  
                        .param("userName", "最新的用户")  
                        .accept(MediaType.parseMediaType("application/json;charset=UTF-8"))  
                        )  
                .andExpect(status().isOk())  
                .andExpect(content().contentType("application/json;charset=UTF-8"))  
                .andDo(print());
        */
        
        /*
        this.mockMvc  
        .perform((delete("/user/userMsg/004"))  
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8"))  
                )  
        .andExpect(status().isOk())  
        .andExpect(content().contentType("application/json;charset=UTF-8"))  
        .andDo(print()); 
        */
    }
}
