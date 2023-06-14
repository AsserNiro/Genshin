package com.asser.dao.Impl;

import com.asser.dao.MissionDao;
import com.asser.entity.Mission;
import com.asser.util.Amath;
import com.asser.util.DBCoon;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MissionDaoImpl implements MissionDao {
    private String sql = null;
    private Boolean flag = false;
    @Override
    public String addMission(Mission mission) {
        int i = 0;
        String MID="";
        try{
            int id = findAll().size();
            List<Mission> list = findAll();
            id = Integer.parseInt(list.get(list.size() - 1).getMID());
            MID = Amath.createIdAfter(id);
            DBCoon.init();
            sql = "insert into mission(MID,name,recommend,time,RID,rewardCount) values(?,?,?,?,?,?)";
            Object[] args = {MID,mission.getName(),mission.getRecommend(),mission.getTime(),mission.getRID(),mission.getRewardCount()};
            i = DBCoon.addUpdateDelete(sql,args);

            if(i>0) {
                flag = true;
                System.out.println("任务添加成功");
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("任务添加失败");
        }finally {
            DBCoon.close();
        }
        return MID;
    }

    @Override
    public Mission findMission(String MID) {
        Mission mission = new Mission();
        try{
            DBCoon.init();
            sql = "select * from mission where MID = ?";
            Object args[] = {MID};
            ResultSet resultSet = DBCoon.searchSql(sql,args);
            while(resultSet.next()){

                mission.setMID(resultSet.getString("MID"));
                mission.setName(resultSet.getString("name"));
                mission.setRecommend(resultSet.getString("recommend"));
                mission.setTime(resultSet.getInt("time"));
                mission.setRID(resultSet.getString("count"));
                mission.setRewardCount(resultSet.getInt("rewardCount"));
            }
            System.out.println("查询任务成功");
        }catch(Exception e){
            System.out.println("查询任务失败");
            e.printStackTrace();
        }finally{
            DBCoon.close();
        }
        return mission;
    }

    @Override
    public boolean updateMission(Mission mission) {
        flag = false;
        try{
            DBCoon.init();
            String sql = "update mission set name=?,recommend=?,time=?,RID=?,rewardCount=? where MID = ?";
            Object[] args = {mission.getName(),mission.getRecommend(),mission.getTime(),mission.getRID(),mission.getRewardCount(),mission.getMID()};
            int i = DBCoon.addUpdateDelete(sql,args);
            if(i>0){
                flag = true;
                System.out.println("任务存储数据更新成功");
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("任务存储数据更新失败");
        }finally {
            DBCoon.close();
        }
        return flag;
    }

    @Override
    public boolean deleteMission(String MID) {
        flag = false;
        try{
            DBCoon.init();
            String sql = "delete from mission where MID=?";
            Object[] args = {MID};
            int i = DBCoon.addUpdateDelete(sql,args);
            if(i > 0){
                flag = true;
                System.out.println("任务存储数据删除成功");
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("任务存储数据删除失败");
        }finally{
            DBCoon.close();
        }
        return flag;
    }

    public List<Mission> findAll(){
        List<Mission> list = new ArrayList<>();
        try{
            DBCoon.init();
            sql = "select * from mission";

            ResultSet resultSet = DBCoon.getAll(sql);
            while(resultSet.next()){
                Mission mission = new Mission();
                mission.setMID(resultSet.getString("MID"));
                mission.setName(resultSet.getString("name"));
                mission.setRecommend(resultSet.getString("recommend"));
                mission.setTime(resultSet.getInt("time"));
                mission.setRID(resultSet.getString("RID"));
                mission.setRewardCount(resultSet.getInt("rewardCount"));
                list.add(mission);
            }
            System.out.println("查询物品成功");
        }catch(Exception e){
            System.out.println("查询物品失败");
            e.printStackTrace();
        }finally{
            DBCoon.close();
        }
        return list;
    }
}
