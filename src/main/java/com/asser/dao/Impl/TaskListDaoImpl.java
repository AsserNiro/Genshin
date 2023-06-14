package com.asser.dao.Impl;

import com.asser.dao.TaskListDao;
import com.asser.entity.TaskList;
import com.asser.util.DBCoon;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaskListDaoImpl implements TaskListDao {
    private String sql = null;
    private Boolean flag = false;
    @Override
    public boolean addTaskList(TaskList taskList) {
        flag = false;
        try{
            DBCoon.init();
            sql = "insert into tasklist(UID,MID,acceptTime,performance) values(?,?,?,?)";
            Object[] args = {taskList.getUID(),taskList.getMID(),taskList.getAcceptTime(),taskList.getPerformance()};
            int i = DBCoon.addUpdateDelete(sql,args);
            if(i>0) {
                flag = true;
                System.out.println("任务添加成功，已被"+taskList.getUID()+"号取走");
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(taskList.getUID()+"的任务添加失败");
        }finally {
            DBCoon.close();
        }
        return flag;
    }

    @Override
    public TaskList findTaskList(String UID,String MID) {
        TaskList taskList = new TaskList();
        try{
            DBCoon.init();
            sql = "select * from tasklist where UID = ? and MID = ?";
            Object args[] = {UID,MID};
            ResultSet resultSet = DBCoon.searchSql(sql,args);
            while(resultSet.next()){
                taskList.setUID(resultSet.getString("UID"));
                taskList.setMID(resultSet.getString("MID"));
                taskList.setAcceptTime(resultSet.getDate("acceptTime"));
                taskList.setPerformance(resultSet.getString("performance"));
            }
            System.out.println("查询任务成功");
        }catch(Exception e){
            System.out.println("查询失败");
            e.printStackTrace();
        }finally{
            DBCoon.close();
        }
        return taskList;
    }

    @Override
    public boolean updateTaskList(TaskList taskList) {
        flag = false;
        try{
            DBCoon.init();
            String sql = "update tasklist set UID=?,MID=?,acceptTime=?,performance=?";
            Object[] args = {taskList.getUID(),taskList.getMID(),taskList.getAcceptTime(),taskList.getPerformance()};
            int i = DBCoon.addUpdateDelete(sql,args);
            if(i>0){
                flag = true;
                System.out.println(taskList.getUID()+"任务数据更新成功");
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(taskList.getUID()+"任务数据更新失败");
        }finally {
            DBCoon.close();
        }
        return flag;
    }

    @Override
    public boolean deleteTaskList(String UID, String MID) {
        flag = false;
        try{
            DBCoon.init();
            String sql = "delete from tasklist where UID=?,MID=?";
            Object[] args = {UID,MID};
            int i = DBCoon.addUpdateDelete(sql,args);
            if(i > 0){
                flag = true;
                System.out.println(UID+"任务存储数据删除成功");
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(UID+"任务存储数据删除失败");
        }finally{
            DBCoon.close();
        }
        return flag;
    }

    @Override
    public List<TaskList> findList(String UID) {
        List<TaskList> list = new ArrayList<>();
        try{
            DBCoon.init();
            sql = "select * from tasklist where UID = ?";
            Object[] args = {UID};
            ResultSet resultSet = DBCoon.searchSql(sql,args);
            System.out.println("成功获取所有用户！");
            while (resultSet.next()) {
                TaskList taskList = new TaskList();
                taskList.setUID(resultSet.getString("UID"));
                taskList.setMID(resultSet.getString("MID"));
                taskList.setAcceptTime(resultSet.getDate("acceptTime"));
                taskList.setPerformance(resultSet.getString("performance"));
                list.add(taskList);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(UID+"查询失败");
        }finally {
            DBCoon.close();
        }
        return list;
    }


}
