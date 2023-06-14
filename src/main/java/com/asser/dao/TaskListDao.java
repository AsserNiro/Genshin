package com.asser.dao;


import com.asser.entity.TaskList;

import java.util.List;

public interface TaskListDao {
    public boolean addTaskList(TaskList reward);

    public TaskList findTaskList(String UID,String MID);

    public boolean updateTaskList(TaskList reward);

    public boolean deleteTaskList(String UID,String MID);

    public List<TaskList> findList(String UID);
}
