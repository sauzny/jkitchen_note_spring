package com.sauzny.springbootweb.entity.pojo;

import java.util.Date;

public class Distribution {
    private Long id;

    private Date createTime;

    private Integer distributionPrice;

    private Date lastUpdateTime;

    private Long merchantId;

    private Long productId;

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

    public Integer getDistributionPrice() {
        return distributionPrice;
    }

    public void setDistributionPrice(Integer distributionPrice) {
        this.distributionPrice = distributionPrice;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}