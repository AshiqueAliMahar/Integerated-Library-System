package BALClasses;

import BeanClasses.StdEmployeePosts;
import ConnectionOfMySql.MySQLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class StdEmpPostBAL {

    MySQLConnection mySQLConnection = new MySQLConnection();

    public ArrayList<StdEmployeePosts> getPost() {
        Connection con = mySQLConnection.getCon();
        String query = "SELECT\n"
                + "  `post_name`\n"
                + "FROM post;";
        ArrayList<StdEmployeePosts> stdEmpPostArr = new ArrayList<>();
        try {
            StdEmployeePosts stdEmployeePosts;
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                stdEmployeePosts = new StdEmployeePosts(rs.getString(1));
                stdEmpPostArr.add(stdEmployeePosts);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StdEmpPostBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stdEmpPostArr;
    }

    public void setPost(String post) {
        String query = "INSERT INTO post\n"
                + "            (`post_name`)\n"
                + "VALUES ('" + post + "');";
        Connection con = mySQLConnection.getCon();
        try {
            Statement stat = con.createStatement();
            int check = stat.executeUpdate(query);
            if (check == 1) {
                JOptionPane.showMessageDialog(null, "Post Inserted Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Post Insertion Failed");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StdEmpPostBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updatePost(String newPost, String oldPost) {
        String query = "UPDATE post\n"
                + "SET `post_name` = '" + newPost + "'\n"
                + "WHERE `post_name` = '" + oldPost + "';";
        Connection con = mySQLConnection.getCon();
        try {
            Statement stat = con.createStatement();
            int check = stat.executeUpdate(query);
            if (check == 1) {
                JOptionPane.showMessageDialog(null, "Post Updated Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Post Updation Failed");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StdEmpPostBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletePost(String post) {
        String query = "DELETE\n"
                + "FROM post\n"
                + "WHERE `post_name` = '"+post+"';";
        Connection con = mySQLConnection.getCon();
        try {
            Statement stat = con.createStatement();
            int check = stat.executeUpdate(query);
            if (check == 1) {
                JOptionPane.showMessageDialog(null, "Post Deleted Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Post Deletion Failed");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StdEmpPostBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
