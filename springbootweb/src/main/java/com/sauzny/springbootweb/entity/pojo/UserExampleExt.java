package com.sauzny.springbootweb.entity.pojo;

public final class UserExampleExt {

    private UserExampleExt(){}
    
    public static UserExample.Criterion andMutilStatusExist(int value){
        return new UserExample.Criterion("mutilstatus&"+value+" > 0");
    }
}
