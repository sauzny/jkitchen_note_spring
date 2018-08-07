package com.sauzny.sbgraphqldemo.controller.connections;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.sauzny.sbgraphqldemo.controller.vo.Address;
import com.sauzny.sbgraphqldemo.controller.vo.City;
import com.sauzny.sbgraphqldemo.controller.vo.convert.AddressConvert;
import com.sauzny.sbgraphqldemo.service.AddressService;

@Component
public class CityConnections implements GraphQLResolver<City>{

    @Autowired
    private AddressService addressService;
    
    public List<Address> addresses(City city){
        return AddressConvert.addressList(addressService.findByCountryId(city.getCityId()));
    }
}
