package com.sauzny.sbgraphqldemo.entity.pojo;

import java.util.Date;

public class TbStore {
    private Byte storeId;

    private Byte managerStaffId;

    private Short addressId;

    private Date lastUpdate;

    public Byte getStoreId() {
        return storeId;
    }

    public void setStoreId(Byte storeId) {
        this.storeId = storeId;
    }

    public Byte getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(Byte managerStaffId) {
        this.managerStaffId = managerStaffId;
    }

    public Short getAddressId() {
        return addressId;
    }

    public void setAddressId(Short addressId) {
        this.addressId = addressId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}