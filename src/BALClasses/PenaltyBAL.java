package BALClasses;

import BeanClasses.PenaltyBean;
import ConnectionOfMySql.MySQLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PenaltyBAL {

    MySQLConnection mySQLConnection = new MySQLConnection();

    public Vector<PenaltyBean> getPenalty(String bookNumber) {
        Vector<PenaltyBean> v = new Vector<>();
        PenaltyBean penaltyBean;
        String sql = "SELECT\n"
                + "  `book_no`,\n"
                + "  `id`,\n"
                + "  `penalty_amount`,\n"
                + "  `penalty_date`\n"
                + "FROM `penalty` WHERE `book_no`='" + bookNumber + "'; ";
        Connection con = mySQLConnection.getCon();
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                penaltyBean = new PenaltyBean();
                penaltyBean.setBkNumber(rs.getLong(1));
                penaltyBean.setId(rs.getString(2));
                penaltyBean.setAmount(rs.getInt(3));
                penaltyBean.setPayDate(rs.getDate(4));
                v.add(penaltyBean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenaltyBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }

    public PenaltyBean getPAmount(String bookNumber, String id) {

        PenaltyBean penaltyBean = null;
        String sql = "SELECT\n"
                + "  `book_no`,\n"
                + "  `id`,\n"
                + "  SUM(`penalty_amount`),\n"
                + "  `penalty_date`\n"
                + "FROM `penalty` WHERE `book_no`='" + bookNumber + "' AND id='" + id + "'; ";
        Connection con = mySQLConnection.getCon();
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                penaltyBean = new PenaltyBean();
                penaltyBean.setBkNumber(rs.getLong(1));
                penaltyBean.setId(rs.getString(2));
                penaltyBean.setAmount(rs.getInt(3));
                penaltyBean.setPayDate(rs.getDate(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenaltyBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return penaltyBean;
    }

    public void setPenalty(PenaltyBean penaltyBean) {
        String sql = "INSERT INTO `penalty`\n"
                + "VALUES ('"+penaltyBean.getBkNumber()+"',\n"
                + "        '"+penaltyBean.getId()+"',\n"
                + "        '"+penaltyBean.getAmount()+"',\n"
                + "        NOW());";
        Connection con = mySQLConnection.getCon();
        try {
            Statement stat = con.createStatement();
            int executeUpdate = stat.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PenaltyBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deletePenalty(String bookNumber){
        Connection con = mySQLConnection.getCon();
        String sql="DELETE FROM penalty WHERE book_no="+bookNumber+";";
        try {
            Statement stat = con.createStatement();
            int executeUpdate = stat.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PenaltyBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
