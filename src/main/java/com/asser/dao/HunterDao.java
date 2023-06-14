package com.asser.dao;

import com.asser.entity.Hunter;

import java.util.List;

//TODO-猎人数据增删改查
public interface HunterDao {
    /**
     * 添加猎人数据
     * @param hunter
     * @return
     */
    public String addHunter(Hunter hunter);

    /**
     * 通过UID找hunter
     * @param UID
     * @return
     */
    public Hunter findHunter(String UID);

    /**
     * 更新猎人数据
     * @param hunter
     * @return
     */
    public boolean updateHunter(Hunter hunter);

    /**
     * 删除猎人数据
     * @param UID
     * @return
     */
    public boolean deleteHunter(String UID);

    /**
     * 查找所有
     * @return
     */
    public List<Hunter> findAll();
}
