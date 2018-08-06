package com.sauzny.sbgraphqldemo.entity.pojo;

public class TbNicerButSlowerFilmListWithBLOBs extends TbNicerButSlowerFilmList {
    private String description;

    private String actors;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors == null ? null : actors.trim();
    }
}