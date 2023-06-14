package com.asser.dao.Impl;

import com.asser.dao.RewardDao;
import com.asser.entity.Reward;
import com.asser.util.Amath;
import com.asser.util.DBCoon;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RewardDaoImpl implements RewardDao {
    private String sql = null;
    private Boolean flag = false;
    @Override
    public String addReward(Reward reward) {
        int i = 0;
        String RID="";
        try{
            int id = findAll().size();
            id = Integer.parseInt(findAll().get(findAll().size() - 1).getRID());
            RID = Amath.createIdAfter(id);
            DBCoon.init();
            sql = "insert into rewards(RID,name,r_recommend) values(?,?,?)";
            Object[] args = {RID,reward.getName(),reward.getR_recommend()};
            i = DBCoon.addUpdateDelete(sql,args);
            if(i>0) {
                flag = true;
                System.out.println("奖励添加成功");
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("奖励添加失败");
        }finally {
            DBCoon.close();
        }
        return RID;
    }

    @Override
    public Reward findReward(String RID) {
        Reward reward = new Reward();
        try{
            DBCoon.init();
            sql = "select * from rewards where RID = ?";
            Object args[] = {RID};
            ResultSet resultSet = DBCoon.searchSql(sql,args);
            while(resultSet.next()){
                reward.setRID(resultSet.getString("RID"));
                reward.setName(resultSet.getString("name"));
                reward.setR_recommend(resultSet.getString("r_recommend"));
            }
            System.out.println("查询任务成功");
        }catch(Exception e){
            System.out.println("查询失败");
            e.printStackTrace();
        }finally{
            DBCoon.close();
        }
        return reward;
    }

    @Override
    public boolean updateReward(Reward reward) {
        flag = false;
        try{
            DBCoon.init();
            String sql = "update rewards set name=?,r_recommend=? where RID = ?";
            Object[] args = {reward.getName(),reward.getR_recommend(),reward.getRID()};
            int i = DBCoon.addUpdateDelete(sql,args);
            if(i>0){
                flag = true;
                System.out.println("奖励存储数据更新成功");
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("奖励存储数据更新失败");
        }finally {
            DBCoon.close();
        }
        return flag;
    }

    @Override
    public boolean deleteReward(String RID) {
        flag = false;
        try{
            DBCoon.init();
            String sql = "delete from rewards where RID=?";
            Object[] args = {RID};
            int i = DBCoon.addUpdateDelete(sql,args);
            if(i > 0){
                flag = true;
                System.out.println("奖励存储数据删除成功");
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("奖励存储数据删除失败");
        }finally{
            DBCoon.close();
        }
        return flag;
    }
    public List<Reward> findAll(){
        List<Reward> list = new ArrayList<>();
        try{
            DBCoon.init();
            sql = "select * from rewards";

            ResultSet resultSet = DBCoon.getAll(sql);
            while(resultSet.next()){
                Reward reward = new Reward();
                reward.setRID(resultSet.getString("RID"));
                reward.setName(resultSet.getString("name"));
                reward.setR_recommend(resultSet.getString("r_recommend"));
                list.add(reward);
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
