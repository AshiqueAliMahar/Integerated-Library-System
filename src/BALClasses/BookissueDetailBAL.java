package BALClasses;

import BeanClasses.BookIssueDetail;
import BeanClasses.Policy;
import ConnectionOfMySql.MySQLConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BookissueDetailBAL {

    MySQLConnection mySQLConnection = new MySQLConnection();

    public boolean isReserved(String bookNumber) {
        boolean check = false;
        try {
            String query = "SELECT\n"
                    + "  `bk_no`,\n"
                    + "  `status`\n"
                    + "FROM `books_ issue_detail` where bk_no='" + bookNumber + "' AND status='reserved';";
            Connection con = mySQLConnection.getCon();
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(query);
            if (rs.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookissueDetailBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public boolean isReserved(String bookNumber, String id) {
        boolean check = false;
        try {
            String query = "SELECT\n"
                    + "  `bk_no`,\n"
                    + "  `status`\n"
                    + "FROM `books_ issue_detail` where bk_no='" + bookNumber + "' AND status='reserved' and std_id='" + id + "';";
            Connection con = mySQLConnection.getCon();
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(query);
            if (rs.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookissueDetailBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public boolean isIssued(String bookNumber) {
        boolean check = false;
        try {
            String query = "SELECT\n"
                    + "  `bk_no`,\n"
                    + "  `status`\n"
                    + "FROM `books_ issue_detail` where bk_no='" + bookNumber + "' AND status='issued';";
            Connection con = mySQLConnection.getCon();
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(query);
            if (rs.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookissueDetailBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public void issueBook(String bookNumber, String id) {
        try {
            String query = "INSERT INTO `books_ issue_detail`\n"
                    + "            (`bk_issue_date`,\n"
                    + "             `bk_no`,\n"
                    + "             `std_id`,\n"
                    + "             `status`)\n"
                    + "VALUES (NOW(),\n"
                    + "        '" + bookNumber + "',\n"
                    + "        '" + id + "',\n"
                    + "        'issued');";
            Connection con = mySQLConnection.getCon();
            Statement stat = con.createStatement();
            int check = stat.executeUpdate(query);
            if (check == 1) {
                JOptionPane.showMessageDialog(null, "Book is Issued On Id:" + id);
            } else {
                JOptionPane.showMessageDialog(null, "Book is Not issued On Id:" + id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookissueDetailBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<BookIssueDetail> getBooksDetailBAL(String value, String status, String fieldName) {

        String queryString = "SELECT `bk_issue_date`,`bk_no`,`std_id`,`status` FROM `books_ issue_detail` WHERE `" + fieldName + "`='" + value + "' AND `status`='" + status + "';";
        ArrayList<BookIssueDetail> arrayList = new ArrayList<>();
        BookIssueDetail bid;
        Connection con = mySQLConnection.getCon();
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(queryString);
            while (rs.next()) {
                bid = new BookIssueDetail(rs.getInt(2), rs.getDate(1), rs.getString(4), rs.getString(3));
                arrayList.add(bid);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookissueDetailBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }

    public ArrayList<BookIssueDetail> getBooksDetailsSearch(String value, String status, String fieldName) {

        String queryString = "SELECT `bk_issue_date`,`bk_no`,`std_id`,`status` FROM `books_ issue_detail` WHERE `" + fieldName + "` LIKE '" + value + "%' AND `status`='" + status + "';";
        ArrayList<BookIssueDetail> arrayList = new ArrayList<>();
        BookIssueDetail bid;
        Connection con = mySQLConnection.getCon();
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(queryString);
            while (rs.next()) {
                bid = new BookIssueDetail(rs.getInt(2), rs.getDate(1), rs.getString(4), rs.getString(3));
                arrayList.add(bid);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookissueDetailBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }

    public ArrayList<BookIssueDetail> getBooksDetail(String status) {
        //reserved
        String queryString = "SELECT `bk_issue_date`,`bk_no`,`std_id`,`status` FROM `books_ issue_detail` WHERE `status`='" + status + "';";
        ArrayList<BookIssueDetail> arrayList = new ArrayList<>();
        BookIssueDetail bid;
        Connection con = mySQLConnection.getCon();
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(queryString);
            while (rs.next()) {
                bid = new BookIssueDetail(rs.getInt(2), rs.getDate(1), rs.getString(4), rs.getString(3));
                arrayList.add(bid);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookissueDetailBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }

    public void issueBook(int bookNumber, String idString, String statusString) {

        java.util.Date d = new java.util.Date();
        Date currentDate = new Date(d.getTime());
        String queryString = "INSERT INTO `books_ issue_detail` VALUES ('" + currentDate + "'," + bookNumber + ",'" + idString + "','" + statusString + "');";

        Connection con = mySQLConnection.getCon();
        try {
            Statement stat = con.createStatement();
            int check = stat.executeUpdate(queryString);
            if (check == 1) {
                JOptionPane.showMessageDialog(null, "Selected Book Reserved To your ID");
            } else {
                JOptionPane.showMessageDialog(null, "Selected Book Is Being Not Reserved");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookissueDetailBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void issueReservedBook(String bookNo, String id) {
        try {
            String query = "UPDATE `books_ issue_detail`\n"
                    + "SET `bk_issue_date` = NOW(),`status` = 'issued'\n"
                    + "WHERE \n"
                    + "    `bk_no` = '" + bookNo + "'\n"
                    + "    AND `std_id` = '" + id + "'\n"
                    + "    AND `status` = 'reserved';";
            Connection con = mySQLConnection.getCon();
            Statement stat = con.createStatement();
            int check = stat.executeUpdate(query);
            if (check == 0) {
                JOptionPane.showMessageDialog(null, "Reserved Book Issue Operation Failed");
            } else if (check == 1) {
                JOptionPane.showMessageDialog(null, "Reserved Book Issued Successfully");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookissueDetailBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeRsrved() {

        try {
            Policy value = PolicyBAL.getValue(Policy.policies.BOOK_RESERVATION_EXPIRE_AFTER.toString());
            System.out.println(value.getPolicyVal());
            String query = "DELETE FROM `books_ issue_detail` WHERE DATEDIFF(NOW(),DATE_ADD(`bk_issue_date`,INTERVAL ? DAY))>=0 AND  `status` = 'reserved';";
            Connection con = MySQLConnection.getCon();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(value.getPolicyVal()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookissueDetailBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean removeRsrved(int bkNo, String studentId) {
        boolean isRemoved = false;
        try (Connection con = mySQLConnection.getCon();) {
            String query = "DELETE FROM `library management system`.`books_ issue_detail` WHERE bk_no=? and `status` = 'reserved' and `std_id`=?; ";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, bkNo);
            ps.setString(2, studentId);
            isRemoved = !ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BookissueDetailBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isRemoved;
    }

    public int getNoOfReservedBooks(String idString) {
        int reservedBooks = 0;
        try {
            String query = "SELECT COUNT(`bk_no`) FROM `books_ issue_detail` WHERE `std_id`='" + idString + "' AND `status`='reserved';";
            Connection con = mySQLConnection.getCon();
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(query);
            if (rs.next()) {
                reservedBooks = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BookissueDetailBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reservedBooks;
    }

    public int getNoOfIssuedBooks(String idString) {
        int issuedBks = 0;
        try {
            String query = "SELECT COUNT(`bk_no`) FROM `books_ issue_detail` WHERE `std_id`='" + idString + "' AND `status`='issued';";
            Connection con = mySQLConnection.getCon();
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(query);
            if (rs.next()) {
                issuedBks = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BookissueDetailBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return issuedBks;
    }

    public void returnBook(String id, String bkNo, String status) {
        String sql = "DELETE\n"
                + "FROM `books_ issue_detail`\n"
                + "WHERE `bk_no` = '" + bkNo + "'\n"
                + "    AND `std_id` = '" + id + "'\n"
                + "    AND `status` = '" + status + "';";
        Connection con = mySQLConnection.getCon();
        try {
            Statement stat = con.createStatement();
            int check = stat.executeUpdate(sql);
            if (check == 0) {
                JOptionPane.showMessageDialog(null, "Book Return Failed");
            } else if (check == 1) {
                JOptionPane.showMessageDialog(null, "Book Returned Successfully");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookissueDetailBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<Map<String, String>> getPenaltyPatrons() {
        String sql = "SELECT \n"
                + "	\n"
                + "    bid.`bk_no`,\n"
                + "     st.email,"
                + "    (b.bk_issue_limit)-DATEDIFF(NOW(),`bk_issue_date`) \n"
                + "    FROM `library management system`.`books_ issue_detail` bid,\n"
                + "		books b,\n"
                + "		student_teacher st\n"
                + "		where \n"
                + "		b.bk_no=bid.bk_no\n"
                + "		and \n"
                + "		status='issued'\n"
                + "		and \n"
                + "		(b.bk_issue_limit)-DATEDIFF(NOW(),`bk_issue_date`) between 0 and 3 \n"
                + "		and \n"
                + "		st.id=bid.std_id group by st.email;";
        List<Map<String, String>> patronList=new LinkedList<>();
        Connection con = MySQLConnection.getCon();
        try (Statement st = con.createStatement();){
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                Map<String,String> map=new HashMap<>();
                String bkNo=rs.getString(1);
                String email=rs.getString(2);
                String remDay=rs.getString(3);
                map.put("bkNo", bkNo);
                map.put("email", email);
                map.put("remDay", remDay);
                patronList.add(map);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookissueDetailBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patronList;
    }
}
