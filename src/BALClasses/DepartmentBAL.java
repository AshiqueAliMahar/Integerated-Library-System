package BALClasses;

import BeanClasses.Department;
import ConnectionOfMySql.MySQLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DepartmentBAL {

    MySQLConnection mySQLConnection = new MySQLConnection();
    public ArrayList<Department> getDeptt() {
        ArrayList<Department> arrdp = new ArrayList<>();
        Connection connection = mySQLConnection.getCon();
        
        try {

            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery("SELECT `dept_name` FROM `department`;");
            while (rs.next()) {
                Department department = new Department();
                department.setDeptNameString(rs.getString(1));
                arrdp.add(department);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DepartmentBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrdp;
    }

    public void setDeptt(String deptt) {
        String query = "INSERT INTO department\n"
                + "            (`dept_name`)\n"
                + "VALUES ('" + deptt + "');";
        Connection con = mySQLConnection.getCon();
        try {
            Statement stat = con.createStatement();
            int check = stat.executeUpdate(query);
            if (check == 1) {
                JOptionPane.showMessageDialog(null, "Department Inserted Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Department Insertion Failed");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StdEmpPostBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateDeptt(String newDeptt, String oldDeptt) {
        String query = "UPDATE department\n"
                + "SET `dept_name` = '" + newDeptt + "'\n"
                + "WHERE `dept_name` = '" + oldDeptt + "';";
        Connection con = mySQLConnection.getCon();
        try {
            Statement stat = con.createStatement();
            int check = stat.executeUpdate(query);
            if (check == 1) {
                JOptionPane.showMessageDialog(null, "Department Updated Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Department Updation Failed");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StdEmpPostBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteDeptt(String deptt) {
        String query = "DELETE\n"
                + "FROM department\n"
                + "WHERE `dept_name` = '" + deptt + "';";
        Connection con = mySQLConnection.getCon();
        try {
            Statement stat = con.createStatement();
            int check = stat.executeUpdate(query);
            if (check == 1) {
                JOptionPane.showMessageDialog(null, "Department Deleted Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Department Deletion Failed");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StdEmpPostBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
