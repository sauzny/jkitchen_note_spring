package com.sauzny.sb_mybatis_mds.entity.pojo;

import java.util.Date;

public class Income {
    private Long id;

    private Long userId;

    private Date incomeDate;

    private Integer totalIncome;

    private Integer totalCommission;

    private Integer totalProxyIncome;

    private Integer netIncome;

    private Integer commission;

    private Integer proxyIncome;

    private Integer orderCount;

    private Integer proxyNewCount;

    private Date createTime;

    private Date lastUpdateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(Date incomeDate) {
        this.incomeDate = incomeDate;
    }

    public Integer getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Integer totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Integer getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(Integer totalCommission) {
        this.totalCommission = totalCommission;
    }

    public Integer getTotalProxyIncome() {
        return totalProxyIncome;
    }

    public void setTotalProxyIncome(Integer totalProxyIncome) {
        this.totalProxyIncome = totalProxyIncome;
    }

    public Integer getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(Integer netIncome) {
        this.netIncome = netIncome;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public Integer getProxyIncome() {
        return proxyIncome;
    }

    public void setProxyIncome(Integer proxyIncome) {
        this.proxyIncome = proxyIncome;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getProxyNewCount() {
        return proxyNewCount;
    }

    public void setProxyNewCount(Integer proxyNewCount) {
        this.proxyNewCount = proxyNewCount;
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
}