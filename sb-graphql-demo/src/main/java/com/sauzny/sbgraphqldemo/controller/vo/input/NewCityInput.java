package com.sauzny.sbgraphqldemo.controller.vo.input;

import lombok.Data;

@Data
public class NewCityInput {

    private String city;
    
    private int countryId;
}
