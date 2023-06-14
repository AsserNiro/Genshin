package com.asser.dao;

import com.asser.entity.Mission;

import java.util.List;

//TODO-任务增删改查
public interface MissionDao {
    /**
     * 增
     * @param mission
     * @return
     */
    public String addMission(Mission mission);

    /**
     * 查
     * @param MID
     * @return
     */
    public Mission findMission(String MID);

    /**
     * 更
     * @param mission
     * @return
     */
    public boolean updateMission(Mission mission);

    /**
     * 删
     * @param MID
     * @return
     */
    public boolean deleteMission(String MID);

    public List<Mission> findAll();
}
