//package com.asser.dao;
//
//import com.asser.entity.HolyRelic;
//import com.asser.util.DBTool;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//public class HolyRelicDao {
//    public static List<HolyRelic> selectHolyRelics() throws SQLException {
//        String sql = "select * from holy_relic";
//        Statement statement = DBTool.getConn().createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//        List<HolyRelic> holyRelics = new ArrayList<>();
//        while (resultSet.next()) {
//            HolyRelic holyRelic = new HolyRelic();
//            holyRelic.setId(resultSet.getInt("id"));
//            holyRelic.setName(resultSet.getString("name"));
//            holyRelic.setType(resultSet.getInt("type"));
//            holyRelic.setProvideHp(resultSet.getInt("provide_hp"));
//            holyRelic.setTypeName(getHolyRelicTypeName(holyRelic.getType()));
//            holyRelics.add(holyRelic);
//        }
//        return holyRelics;
//    }
//
//    public static List<HolyRelic> selectHolyRelics(String where) throws SQLException {
//        String sql = "select * from holy_relic where " + where;
//        Statement statement = DBTool.getConn().createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//        List<HolyRelic> holyRelics = new ArrayList<>();
//        while (resultSet.next()) {
//            HolyRelic holyRelic = new HolyRelic();
//            holyRelic.setId(resultSet.getInt("id"));
//            holyRelic.setName(resultSet.getString("name"));
//            holyRelic.setType(resultSet.getInt("type"));
//            holyRelic.setProvideHp(resultSet.getInt("provide_hp"));
//            holyRelic.setTypeName(getHolyRelicTypeName(holyRelic.getType()));
//            holyRelics.add(holyRelic);
//        }
//        return holyRelics;
//    }
//    private static String getHolyRelicTypeName(int type){
//        if (type==1) return "生之花";
//        else if (type==2)return "死之羽";
//        else return "理之冠";
//    }
//    public static int insertHolyRelic(HolyRelic holyRelic) throws SQLException {
//        String sql = "insert into holy_relic(name,type,provide_hp) values('" + holyRelic.getName() + "'," + holyRelic.getType() + "," + holyRelic.getProvideHp() + ")";
//        System.out.println(sql);
//        Statement statement = DBTool.getConn().createStatement();
//        statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
//        ResultSet rs = statement.getGeneratedKeys();
//        rs.next();
//        return rs.getInt(1);//返回所插入圣遗物自动生成的id
//    }
//    public static int updateHolyRelic(HolyRelic holyRelic) throws SQLException {
//        String sql = "update holy_relic set name='" + holyRelic.getName() + "',type=" +
//                holyRelic.getType() + ",provide_hp=" + holyRelic.getProvideHp() +
//                " where id=" + holyRelic.getId();
//        Statement statement = DBTool.getConn().createStatement();
//        return statement.executeUpdate(sql);//返回所影响的行数
//    }
//    public static int deleteHolyRelic(HolyRelic holyRelic) throws SQLException {
//        String sql = "delete from holy_relic where id="+holyRelic.getId();
//        Statement statement = DBTool.getConn().createStatement();
//        return statement.executeUpdate(sql);//返回所影响的行数
//    }
//}
