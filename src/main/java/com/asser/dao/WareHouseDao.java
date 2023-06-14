package com.asser.dao;

import com.asser.entity.TaskList;
import com.asser.entity.WareHouse;

import java.util.List;

public interface WareHouseDao {
    public boolean addWareHouse(WareHouse reward);

    public WareHouse findWareHouse(String UID,String MID);

    public boolean updateWareHouse(WareHouse reward);

    public boolean deleteWareHouse(String UID,String MID);

    public List<WareHouse> findList(String UID);
}
