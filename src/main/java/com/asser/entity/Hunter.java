package com.asser.entity;

import java.util.Date;

public class Hunter {
    private String UID;
    private String name;
    private String sex;
    private String recommend;
    private int count;

    public Hunter() {
        this.count = 0;
    }

    public Hunter(String name, String sex, String recommend) {
        this.UID = UID;
        this.name = name;
        this.sex = sex;
        this.recommend = recommend;
    }

    public Hunter(String UID, String name, String sex, String recommend) {
        this.UID = UID;
        this.name = name;
        this.sex = sex;
        this.recommend = recommend;
    }



    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Hunter{" +
                "UID='" + UID + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", recommend='" + recommend + '\'' +
                ", count=" + count +
                '}';
    }
}
