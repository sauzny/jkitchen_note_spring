package com.sauzny.springbootweb.entity.pojo;

public final class UserExt {

    private UserExt(){}
    
    public static UserExample.Criterion andMutilStatusExist(int value){
        return new UserExample.Criterion("mutilstatus&"+value+" > 0");
    }
}
