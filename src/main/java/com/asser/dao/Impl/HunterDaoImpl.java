package com.asser.dao.Impl;

import com.asser.dao.HunterDao;
import com.asser.entity.Hunter;
import com.asser.util.Amath;
import com.asser.util.DBCoon;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HunterDaoImpl implements HunterDao {
    private String sql = null;
    private Boolean flag = false;
    @Override
    public String addHunter(Hunter hunter) {
        int i = 0;
        String UID=null;
        try{
            int id = findAll().size();
            List<Hunter> list = findAll();
            String LastUID = list.get(list.size()-1).getUID();
            id = Integer.parseInt(LastUID);
            UID = Amath.createIdAfter(id);
            System.out.println("UID is ");
            sql = "insert into user(UID,name,sex,count,recommend) values(?,?,?,?,?)";
            DBCoon.init();
            Object[] args = {UID,hunter.getName(),hunter.getSex(),hunter.getCount(),hunter.getRecommend()};
            i = DBCoon.addUpdateDelete(sql,args);
            if(i > 0){
                flag = true;
                System.out.println("猎人数据添加成功");
            }

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("猎人数据添加失败");
        }finally {
            DBCoon.close();
        }
        return UID;
    }

    @Override
    public Hunter findHunter(String UID) {
        System.out.println("UID is " + UID);
        Hunter hunter = new Hunter();
        try{
            DBCoon.init();
            sql = "select * from user where UID = ?";
            Object args[] = {UID};
            ResultSet resultSet = DBCoon.searchSql(sql,args);
            while(resultSet.next()){
                hunter.setUID(resultSet.getString("UID"));
                hunter.setName(resultSet.getString("name"));
                hunter.setSex(resultSet.getString("sex"));
                hunter.setRecommend(resultSet.getString("recommend"));
                hunter.setCount(resultSet.getInt("count"));
            }
            System.out.println("查询猎人成功");
        }catch(Exception e){
            System.out.println("查询猎人失败");
            e.printStackTrace();
        }finally{
            DBCoon.close();
        }
        return hunter;
    }

    @Override
    public boolean updateHunter(Hunter hunter) {
        flag = false;
        try{
            DBCoon.init();
            String sql = "update user set name=?,sex=?,recommend=? where UID = ? ";
            Object[] args = {hunter.getName(),hunter.getSex(),hunter.getRecommend(),hunter.getUID()};
            int i = DBCoon.addUpdateDelete(sql,args);
            if(i>0){
                flag = true;
                System.out.println("猎人存储数据更新成功");
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("猎人存储数据更新失败");
        }finally {
            DBCoon.close();
        }
        return flag;
    }

    @Override
    public boolean deleteHunter(String UID) {
        flag = false;
        try{
            DBCoon.init();
            String sql = "delete from user where UID=?";
            Object[] args = {UID};
            int i = DBCoon.addUpdateDelete(sql,args);
            if(i > 0){
                flag = true;
                System.out.println("猎人存储数据删除成功");
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("猎人存储数据删除失败");
        }finally{
            DBCoon.close();
        }
        return flag;
    }

    public List<Hunter> findAll(){
        List<Hunter> list = new ArrayList<>();
        try{
            DBCoon.init();
            sql = "select * from user";

            ResultSet resultSet = DBCoon.getAll(sql);
            while(resultSet.next()){
                Hunter hunter = new Hunter();
                hunter.setUID(resultSet.getString("UID"));
                hunter.setName(resultSet.getString("name"));
                hunter.setSex(resultSet.getString("sex"));
                hunter.setRecommend(resultSet.getString("recommend"));
                hunter.setCount(resultSet.getInt("count"));
                list.add(hunter);
            }
            System.out.println("查询猎人成功");
        }catch(Exception e){
            System.out.println("查询猎人失败");
            e.printStackTrace();
        }finally{
            DBCoon.close();
        }
        return list;
    }
}
