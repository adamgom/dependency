package com.isa.jjdzr.data.model;

import java.util.Objects;

public class DataBean {
    private final int id;
    private final String name;
    private final String place;
    private final boolean isActive;

    public DataBean(int id, String name, String place, boolean isActive) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataBean dataBean = (DataBean) o;
        return Objects.equals(name, dataBean.name) && Objects.equals(place, dataBean.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, place);
    }
}
