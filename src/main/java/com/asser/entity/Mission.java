package com.asser.entity;

public class Mission {
    private String MID;
    private String name;
    private String recommend;
    private int time;
    private String RID;
    private int rewardCount;

    public Mission() {
    }

    public Mission(String name, int time, String RID, int rewardCount, String recommend) {
        this.name = name;
        this.recommend = recommend;
        this.time = time;
        this.RID = RID;
        this.rewardCount = rewardCount;
    }

    public Mission(String MID, String name, String recommend, int time, String RID, int rewardCount) {
        this.MID = MID;
        this.name = name;
        this.recommend = recommend;
        this.time = time;
        this.RID = RID;
        this.rewardCount = rewardCount;
    }

    public String getMID() {
        return MID;
    }

    public void setMID(String MID) {
        this.MID = MID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getRID() {
        return RID;
    }

    public void setRID(String RID) {
        this.RID = RID;
    }

    public int getRewardCount() {
        return rewardCount;
    }

    public void setRewardCount(int rewardCount) {
        this.rewardCount = rewardCount;
    }
}
