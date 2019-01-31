package com.sauzny.sbvalidationdemo.test;

import com.sauzny.sbvalidationdemo.ValidatorUtil;
import com.sauzny.sbvalidationdemo.entity.ParentInfo;
import com.sauzny.sbvalidationdemo.entity.StudentInfo;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/***************************************************************************
 *
 * @时间: 2019/1/31 - 13:35
 *
 * @描述: TODO
 *
 ***************************************************************************/
@Component
public class ValidatorTest {
    @PostConstruct
    public void init() {
        StudentInfo s = new StudentInfo();
        long startTime = System.currentTimeMillis();
        ValidatorUtil.print(ValidatorUtil.validate(s));
        System.out.println("===============耗时(毫秒)=" + (System.currentTimeMillis() - startTime));

        s.setUserName("小明");
        s.setAge("a10");
        s.setBirthday("2016-9-1");
        s.setMoney(100.00001);
        s.setParentInfo(new ParentInfo());
        startTime = System.currentTimeMillis();
        ValidatorUtil.print(ValidatorUtil.validate(s));
        System.out.println("===============耗时(毫秒)=" + (System.currentTimeMillis() - startTime));
    }
}
