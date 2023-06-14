package com.asser.dao;

import com.asser.entity.Reward;

import java.util.List;

//TODO-奖励数据增删改查
public interface RewardDao {

    public String addReward(Reward reward);

    public Reward findReward(String RID);

    public boolean updateReward(Reward reward);

    public boolean deleteReward(String RID);

    public List<Reward> findAll();
}
