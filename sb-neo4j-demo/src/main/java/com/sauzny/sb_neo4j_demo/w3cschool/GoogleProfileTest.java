package com.sauzny.sb_neo4j_demo.w3cschool;

import javax.annotation.PostConstruct;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sauzny.sb_neo4j_demo.utils.GoogleProfileUtils;
import com.sauzny.sb_neo4j_demo.w3cschool.node.GoogleProfile;

@Component
public class GoogleProfileTest {

    @Autowired
    private GoogleProfileService googleProfileService;
    
    @PostConstruct
    public void foo01(){
        
        GoogleProfile profile = GoogleProfileUtils.createGoogleProfile();
        
        GoogleProfile profile1 = GoogleProfileUtils.createGoogleProfile();
        GoogleProfile profile2 = GoogleProfileUtils.createGoogleProfile();
        GoogleProfile profile3 = GoogleProfileUtils.createGoogleProfile();
        
        profile.setFriends(Lists.newArrayList(profile1, profile2, profile3));
        
        googleProfileService.create(profile);
    }
}
