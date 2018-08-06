package com.sauzny.sbgraphqldemo.controller.vo;

import java.util.List;

import lombok.Data;

@Data
public class City {

    private int cityId;
    
    private String city;
    
    private List<Address> addresses;
}
