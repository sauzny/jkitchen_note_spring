package com.sauzny.springboot.springutil.beancopier;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Product {

    private Long id;
    
    private LocalDateTime createTime;
    
    private LocalDateTime lastUpdateTime;

    private String name;

    private Integer supplierId = 0;

    private String supplierName;

    private String supplierProductNo;

    private Integer purchasePrice = 0;
    
    private Integer minDistribution = 0;
    
    private Integer maxDistribution = 0;

    private Integer state;
    
}
