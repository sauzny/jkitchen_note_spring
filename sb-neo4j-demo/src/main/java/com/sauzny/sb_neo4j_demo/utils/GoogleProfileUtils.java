package com.sauzny.sb_neo4j_demo.utils;

import org.apache.commons.lang3.RandomStringUtils;

import com.sauzny.sb_neo4j_demo.w3cschool.node.GoogleProfile;

public final class GoogleProfileUtils {

    private GoogleProfileUtils(){}
    
    public static GoogleProfile createGoogleProfile(){
        GoogleProfile googleProfile = new GoogleProfile();
        //googleProfile.setId(id);
        googleProfile.setAddress("address-"+RandomStringUtils.randomAlphanumeric(6, 8));
        googleProfile.setDob("dob-"+RandomStringUtils.randomAlphanumeric(6, 8));
        googleProfile.setName("name-"+RandomStringUtils.randomAlphanumeric(6, 8));
        googleProfile.setSex("sex-"+RandomStringUtils.randomAlphanumeric(6, 8));
        return googleProfile;
    }
}
