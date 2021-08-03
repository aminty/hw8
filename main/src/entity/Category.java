package entity;

import base.entity.BaseEntity;

public class Category extends BaseEntity <Integer>{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
