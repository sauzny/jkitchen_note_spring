package com.sauzny.springboot.springutil.beancopier;

import lombok.Data;

@Data
public class ProductVO {

    private Long id;
    
    private String createTime;
    
    private String lastUpdateTime;

    private String namess;

    private Integer supplierId = 0;

    private String supplierName;

    private String supplierProductNo;

    private Integer purchasePrice = 0;
    
    private Integer minDistribution = 0;
    
    private Integer maxDistribution = 0;

    private Integer state;

}
