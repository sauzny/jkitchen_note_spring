package com.sauzny.sbgraphqldemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.github.pagehelper.Page;
import com.sauzny.sbgraphqldemo.controller.vo.Address;
import com.sauzny.sbgraphqldemo.controller.vo.Pagination;
import com.sauzny.sbgraphqldemo.controller.vo.convert.AddressConvert;
import com.sauzny.sbgraphqldemo.entity.pojo.TbAddress;
import com.sauzny.sbgraphqldemo.service.AddressService;

@Component
public class AddressController implements GraphQLQueryResolver, GraphQLMutationResolver{
    
    @Autowired
    private AddressService addressService;
    
    public List<Address> address(Pagination pagination){
        
        Page<TbAddress> page = addressService.findByPage(pagination.getPageNum(), pagination.getPageSize());
        List<Address> list = AddressConvert.addressList(page.getResult());
        return list;
    }
    
    public Boolean newAddress(String address){
        return true;
    }
}
