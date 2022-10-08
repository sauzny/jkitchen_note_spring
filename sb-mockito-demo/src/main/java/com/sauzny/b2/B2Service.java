package com.sauzny.b2;

import com.sauzny.b1.B1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: liujinxin
 * @time: 2021/11/5 13:53
 */
@Service
public class B2Service {

    @Autowired
    private B1Service b1Service;

    public String deal2(){
        return b1Service.deal1();
    }
}
