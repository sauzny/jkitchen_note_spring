package com.sauzny.sbgraphqldemo.controller.vo.convert;

import java.util.List;

import com.google.common.collect.Lists;
import com.sauzny.sbgraphqldemo.controller.vo.Address;
import com.sauzny.sbgraphqldemo.entity.pojo.TbAddress;

public final class AddressConvert {

    private AddressConvert(){}
    
    public static Address address(TbAddress tbAddress){
        Address country = new Address();
        country.setAddressId(tbAddress.getAddressId());
        country.setAddress(tbAddress.getAddress());
        return country;
    }
    
    public static List<Address> addressList(List<TbAddress> tbAddressList){
        List<Address> countryList = Lists.newArrayList();
        tbAddressList.forEach(tbAddress -> countryList.add(address(tbAddress)));
        return countryList;
    }
}
