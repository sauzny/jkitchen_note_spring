package com.sauzny.sbgraphqldemo.controller.vo.convert;

import java.util.List;

import com.google.common.collect.Lists;
import com.sauzny.sbgraphqldemo.controller.vo.Country;
import com.sauzny.sbgraphqldemo.entity.pojo.TbCountry;
import com.sauzny.sbgraphqldemo.uitls.TimeUtils;

public final class CountryConvert {

    private CountryConvert(){}
    
    public static Country country(TbCountry tbCountry){
        Country country = new Country();
        country.setCountryId(tbCountry.getCountryId());
        country.setCountry(tbCountry.getCountry());
        country.setLastUpdate(TimeUtils.UDateToLocalDateTime(tbCountry.getLastUpdate()).toString().replace("T", " "));
        return country;
    }
    
    public static List<Country> countryList(List<TbCountry> tbCountryList){
        List<Country> countryList = Lists.newArrayList();
        tbCountryList.forEach(tbCountry -> countryList.add(country(tbCountry)));
        return countryList;
    }
}
