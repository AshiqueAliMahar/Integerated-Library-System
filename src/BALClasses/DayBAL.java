package BALClasses;

import BeanClasses.Day;
import ConnectionOfMySql.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DayBAL {
    private static String sql="";
    public static List<Day> getDays(){
        List<Day> days=new LinkedList<>();
        sql="SELECT day_name,time FROM `library management system`.library_time;";
        
        try (Connection con = MySQLConnection.getCon();){
            ResultSet rset = con.createStatement().executeQuery(sql);
            while(rset.next()){
                Day day=new Day();
                day.setDayName(rset.getString(1));
                day.setTime(rset.getString(2));
                days.add(day);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DayBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return days;
    }
    public static boolean save(Day day){
        sql="INSERT INTO `library management system`.`library_time` (`day_name`,`time`)VALUES(?,?);";
        boolean isUpdated=false;
        try(Connection con = MySQLConnection.getCon();) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, day.getDayName().toString());
            ps.setString(2, day.getTime());
            isUpdated=!ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DayBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isUpdated;
    }
    public static boolean update(Day day){
        sql="UPDATE `library management system`.`library_time` SET `time` = ? WHERE `day_name` = ?;";
        boolean isUpdated=false;
        try(Connection con = MySQLConnection.getCon();) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(2, day.getDayName().toString());
            ps.setString(1, day.getTime());
            isUpdated=!ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DayBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isUpdated;
    }
    public static boolean isExist(String dayName){
        sql="select * from library_time WHERE `day_name` = ?";
        boolean isExist=false;
        try(Connection con = MySQLConnection.getCon();) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dayName);
            isExist=ps.executeQuery().next();
        } catch (SQLException ex) {
            Logger.getLogger(DayBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isExist;
    }
    public static Day getById(String dayName){
        sql="select day_name,time from library_time WHERE `day_name` = ?";
        Day day=new Day();
        try(Connection con = MySQLConnection.getCon();) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dayName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                day.setDayName(rs.getString(1));
                day.setTime(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DayBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return day;
    }
}
