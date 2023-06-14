package com.asser.util;

import java.sql.*;

//TODO-数据库工具类
public class DBCoon {
    static String url = "jdbc:mysql://localhost:3306/stu_work?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8";
    static String userName = "root";
    static String pwd = "zou20040303";

    static Connection connection = null;
    static ResultSet resultSet = null;
    static PreparedStatement preparedStatement = null;

    public static void init(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,userName,pwd);
            System.out.println("数据库连接成功");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }

    /**
     * 查询数据（传递参数）
     *
     * @param sql
     * @param args
     */
    public static ResultSet searchSql(String sql, Object[] args) {
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            System.out.println("查询成功！");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询失败！");
        }
        return resultSet;
    }
    /**
     * 增删改查数据（传递参数）
     *
     * @param sql
     * @param args
     */
    public static int addUpdateDelete(String sql, Object[] args) {
        int i = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            System.out.println("更新数据长度为："+args.length);
            for (int j = 0; j < args.length; j++) {
                System.out.println(args[j]);
                preparedStatement.setObject(j + 1, args[j]);
            }
            i = preparedStatement.executeUpdate();
            System.out.println("增删改成功!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("增删改失败！");
        }
        return i;
    }



    /**
     * 查询全部信息（不传参）
     *
     * @param sql
     */
    public static ResultSet getAll(String sql) {
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            System.out.println("查询成功！");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询失败!");
        }
        return resultSet;
    }

    /**
     * 关闭流
     */
    public static void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("数据流关闭异常");
        }
    }

}
