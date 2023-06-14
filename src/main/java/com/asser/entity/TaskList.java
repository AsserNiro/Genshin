package com.asser.entity;

import java.util.Date;

public class TaskList {
    private String UID;
    private String MID;
    private Date acceptTime;
    private String performance;

    public TaskList() {
    }

    public TaskList(String UID, String MID, Date acceptTime) {
        this.UID = UID;
        this.MID = MID;
        this.acceptTime = acceptTime;
    }

    public TaskList(String UID, String MID, Date acceptTime, String performance) {
        this.UID = UID;
        this.MID = MID;
        this.acceptTime = acceptTime;
        this.performance = performance;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getMID() {
        return MID;
    }

    public void setMID(String MID) {
        this.MID = MID;
    }

    public Date getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }
}
