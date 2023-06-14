package com.asser.entity;

public class Reward {
    private String RID;
    private String name;
    private String r_recommend;

    public Reward() {
    }

    public Reward(String name, String r_recommend) {
        this.name = name;
        this.r_recommend = r_recommend;
    }

    public Reward(String RID, String name, String r_recommend) {
        this.RID = RID;
        this.name = name;
        this.r_recommend = r_recommend;
    }

    public String getRID() {
        return RID;
    }

    public void setRID(String RID) {
        this.RID = RID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getR_recommend() {
        return r_recommend;
    }

    public void setR_recommend(String r_recommend) {
        this.r_recommend = r_recommend;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "RID='" + RID + '\'' +
                ", name='" + name + '\'' +
                ", r_recommend='" + r_recommend + '\'' +
                '}';
    }
}
