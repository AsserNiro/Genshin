package com.asser.entity;

public class WareHouse {
    private String UID;
    private String RID;
    private int count;

    public WareHouse() {
        this.count = 0;
    }

    public WareHouse(String UID, String RID) {
        this.UID = UID;
        this.RID = RID;
        this.count = 0;
    }

    public WareHouse(String UID, String RID, int count) {
        this.UID = UID;
        this.RID = RID;
        this.count = count;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getRID() {
        return RID;
    }

    public void setRID(String RID) {
        this.RID = RID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
