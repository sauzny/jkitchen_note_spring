package com.sauzny.sbgraphqldemo.controller.vo.convert;

import java.util.List;

import com.google.common.collect.Lists;
import com.sauzny.sbgraphqldemo.controller.vo.Address;
import com.sauzny.sbgraphqldemo.entity.pojo.TbAddress;

public final class AddressConvert {

    private AddressConvert(){}
    
    public static Address address(TbAddress tbAddress){
        Address address = new Address();
        address.setAddressId(tbAddress.getAddressId());
        address.setAddress(tbAddress.getAddress());
        return address;
    }
    
    public static List<Address> addressList(List<TbAddress> tbAddressList){
        List<Address> addressList = Lists.newArrayList();
        tbAddressList.forEach(tbAddress -> addressList.add(address(tbAddress)));
        return addressList;
    }
}
