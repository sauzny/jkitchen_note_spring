package com.sauzny.sbgraphqldemo.controller.vo;

import lombok.Data;

@Data
public class Pagination {

    private int pageNum;
    private int pageSize;
    private boolean needTotal;
}
