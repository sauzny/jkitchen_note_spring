package com.sauzny.sbgraphqldemo.controller.vo;

import java.util.List;

import lombok.Data;

@Data
public class Country {

    private int countryId;
    
    private String country;
    
    private String lastUpdate;

    private List<City> cities;
    
}
