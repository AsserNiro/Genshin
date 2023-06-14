//package com.asser.dao;
//
//import com.asser.entity.Weapon;
//import com.asser.util.DBTool;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//public class WeaponDao {
//    public static List<Weapon> selectWeapons() throws SQLException {
//        String sql = "select * from weapon";
//        Statement statement = DBTool.getConn().createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//        List<Weapon> weapons = new ArrayList<>();
//        while (resultSet.next()) {
//            Weapon weapon = new Weapon();
//            weapon.setId(resultSet.getInt("id"));
//            weapon.setName(resultSet.getString("name"));
//            weapon.setType(resultSet.getInt("type"));
//            weapon.setProvideHp(resultSet.getInt("provide_hp"));
//            weapon.setTypeName(getWeaponTypeName(weapon.getType()));
//            weapons.add(weapon);
//        }
//        return weapons;
//    }
//
//    public static List<Weapon> selectWeapons(String where) throws SQLException {
//        String sql = "select * from weapon where " + where;
//        Statement statement = DBTool.getConn().createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//        List<Weapon> weapons = new ArrayList<>();
//        while (resultSet.next()) {
//            Weapon weapon = new Weapon();
//            weapon.setId(resultSet.getInt("id"));
//            weapon.setName(resultSet.getString("name"));
//            weapon.setType(resultSet.getInt("type"));
//            weapon.setProvideHp(resultSet.getInt("provide_hp"));
//            weapon.setTypeName(getWeaponTypeName(weapon.getType()));
//            weapons.add(weapon);
//        }
//        return weapons;
//    }
//    private static String getWeaponTypeName(int type){
//        if (type==1) return "单手剑";
//        else if (type==2)return "弓箭";
//        else return "法器";
//    }
//    public static int insertWeapon(Weapon weapon) throws SQLException {
//        String sql = "insert into weapon(name,type,provide_hp) values('" + weapon.getName() + "'," + weapon.getType() + "," + weapon.getProvideHp() + ")";
//        System.out.println(sql);
//        Statement statement = DBTool.getConn().createStatement();
//        statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
//        ResultSet rs = statement.getGeneratedKeys();
//        rs.next();
//        return rs.getInt(1);//返回所插入武器自动生成的id
//    }
//    public static int updateWeapon(Weapon weapon) throws SQLException {
//        String sql = "update weapon set name='" + weapon.getName() + "',type=" +
//                weapon.getType() + ",provide_hp=" + weapon.getProvideHp() +
//                " where id=" + weapon.getId();
//        Statement statement = DBTool.getConn().createStatement();
//        return statement.executeUpdate(sql);//返回所影响的行数
//    }
//    public static int deleteWeapon(Weapon weapon) throws SQLException {
//        String sql = "delete from weapon where id="+weapon.getId();
//        Statement statement = DBTool.getConn().createStatement();
//        return statement.executeUpdate(sql);//返回所影响的行数
//    }
//}
