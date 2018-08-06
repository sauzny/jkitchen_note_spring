package com.sauzny.sbgraphqldemo.entity.pojo;

import java.math.BigDecimal;

public class TbSalesByFilmCategory {
    private String category;

    private BigDecimal totalSales;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }
}