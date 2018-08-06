package com.sauzny.sbgraphqldemo.entity.pojo;

import java.util.Date;

public class TbFilmActor extends TbFilmActorKey {
    private Date lastUpdate;

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}