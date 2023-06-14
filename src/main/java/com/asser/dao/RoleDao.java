//package com.asser.dao;
//
//import com.asser.entity.Role;
//import com.asser.util.DBTool;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//public class RoleDao {
//    public static List<Role> selectRoles() throws SQLException {
//        String sql = "select * from role";
//        Statement statement = DBTool.getConn().createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//        List<Role> roles = new ArrayList<>();
//        while (resultSet.next()) {
//            Role role = new Role();
//            role.setId(resultSet.getInt("id"));
//            role.setName(resultSet.getString("name"));
//            role.setIntroduce(resultSet.getString("introduce"));
//            role.setBaseHp(resultSet.getInt("base_hp"));
//            role.setHolyRelicId(resultSet.getInt("holy_relic_id"));
//            role.setWeaponId(resultSet.getInt("weapon_id"));
//            roles.add(role);
//        }
//        return roles;
//    }
//
//    public static List<Role> selectRoles(String where) throws SQLException {
//        String sql = "select * from role where " + where;
//        Statement statement = DBTool.getConn().createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//        List<Role> roles = new ArrayList<>();
//        while (resultSet.next()) {
//            Role role = new Role();
//            role.setId(resultSet.getInt("id"));
//            role.setName(resultSet.getString("name"));
//            role.setIntroduce(resultSet.getString("introduce"));
//            role.setBaseHp(resultSet.getInt("base_hp"));
//            role.setHolyRelicId(resultSet.getInt("holy_relic_id"));
//            role.setWeaponId(resultSet.getInt("weapon_id"));
//            roles.add(role);
//        }
//        return roles;
//    }
//    public static int insertRole(Role role) throws SQLException {
//        String sql = "insert into role(name,introduce,base_hp) values('" + role.getName() + "','" + role.getIntroduce() + "'," + role.getBaseHp() + ")";
//        System.out.println(sql);
//        Statement statement = DBTool.getConn().createStatement();
//        statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
//        ResultSet rs = statement.getGeneratedKeys();
//        rs.next();
//        return rs.getInt(1);//返回所插入角色自动生成的id
//    }
//    public static int updateRole(Role role) throws SQLException {
//        String sql = "update role set name='" + role.getName() + "',introduce='" + role.getIntroduce() + "',base_hp=" +
//                role.getBaseHp() + ",holy_relic_id=" + role.getHolyRelicId() + ",weapon_id=" + role.getWeaponId() +
//                " where id=" + role.getId();
//        Statement statement = DBTool.getConn().createStatement();
//        return statement.executeUpdate(sql);//返回所影响的行数
//    }
//    public static int deleteRole(Role role) throws SQLException {
//        String sql = "delete from role where id="+role.getId();
//        Statement statement = DBTool.getConn().createStatement();
//        return statement.executeUpdate(sql);//返回所影响的行数
//    }
//}
