package com.sauzny.springbootweb.entity.pojo;

import java.util.Date;

public class Product {
    private Long id;

    private Date createTime;

    private Date lastUpdateTime;

    private String name;

    private Integer purchasePrice;

    private Integer state;

    private Integer supplierId;

    private String supplierName;

    private String supplierProductNo;

    private Integer maxDistribution;

    private Integer minDistribution;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Integer purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public String getSupplierProductNo() {
        return supplierProductNo;
    }

    public void setSupplierProductNo(String supplierProductNo) {
        this.supplierProductNo = supplierProductNo == null ? null : supplierProductNo.trim();
    }

    public Integer getMaxDistribution() {
        return maxDistribution;
    }

    public void setMaxDistribution(Integer maxDistribution) {
        this.maxDistribution = maxDistribution;
    }

    public Integer getMinDistribution() {
        return minDistribution;
    }

    public void setMinDistribution(Integer minDistribution) {
        this.minDistribution = minDistribution;
    }
}