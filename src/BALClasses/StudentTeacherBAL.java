package BALClasses;

import BeanClasses.StudentTeacher;
import BeanClasses.StudentTeacherChild;
import ConnectionOfMySql.MySQLConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class StudentTeacherBAL {
    private final static String ID_FIELD="id";
    private final static String NAME_FIELD="name";
    private final static String POST_FIELD="post";
    private final static String EMAIL_FIELD="email";
    private final static String GENDER_FIELD="gender";
    private final static String DEPARTMENT_FIELD="dept_name";
    private final static String CNIC_FIELD="cnic";
    
 //Email, Gender, Department, CNIC
    //MySQLConnection msqlc = new MySQLConnection();

    public boolean isEmailPass(String email, String password) {

        boolean isPassEmailRight = false;
        Connection con = MySQLConnection.getCon();
        String query = "SELECT `email`,`password` FROM `student_teacher` WHERE `password`='" + password + "' AND `email`='" + email + "';";
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(query);
            isPassEmailRight = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(StudentTeacherBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isPassEmailRight;
    }

    public boolean isEmail(String email) {

        boolean isEmailRight = false;
        Connection con = MySQLConnection.getCon();
        String query = "SELECT `email` FROM `student_teacher` WHERE  `email`='" + email + "';";
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(query);
            isEmailRight = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(StudentTeacherBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isEmailRight;
    }
    
    public boolean isAvail(String id) {

        boolean isAvail = false;
        Connection con = MySQLConnection.getCon();
        String query = "SELECT `id` FROM `student_teacher` WHERE  `id`='" + id + "';";
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(query);
            isAvail = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(StudentTeacherBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isAvail;
    }

    
    public void setPassword(String passwordString, String email) {
        String query = "UPDATE `student_teacher` SET  `password` = '" + passwordString + "' WHERE `email` = '" + email + "';";
        //
        Connection con = MySQLConnection.getCon();
        try {
            Statement stat = con.createStatement();
            int check = stat.executeUpdate(query);
            if (check == 1) {
                JOptionPane.showMessageDialog(null, "Password Changed Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Password Not Changed");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public StudentTeacher getStudentTeacher(String email, String password) {

        StudentTeacher studentTeacher = new StudentTeacher();
        Connection con = MySQLConnection.getCon();
        String query = "SELECT `id`,`name`,`email`,`password`,`cnic`,`DOB`,`contact_no`,`address`,`DOA`,`pic`,`dept_name`,`gender`,`post`,`details` FROM `student_teacher` WHERE `password`='"+password+"' AND `email`='"+ email +"';";
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(query);
            if (rs.next()) {
                studentTeacher.setIdString(rs.getString(1));
                studentTeacher.setNameString(rs.getString(2));
                studentTeacher.setEmailString(rs.getString(3));
                studentTeacher.setPaswordString(rs.getString(4));
                studentTeacher.setCNICString(rs.getString(5));
                studentTeacher.setDateOfBirthDate(rs.getDate(6));
                studentTeacher.setContactNoString(rs.getString(7));
                studentTeacher.setAddressString(rs.getString(8));
                studentTeacher.setDateOfAdmission(rs.getDate(9));
                studentTeacher.setPicBlob(rs.getBytes(10));
                studentTeacher.setDepartmentName(rs.getString(11));
                studentTeacher.setGenderString(rs.getString(12));
                studentTeacher.setPostString(rs.getString(13));
                studentTeacher.setDetailsString(rs.getString(14));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentTeacherBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studentTeacher;
    }

    public StudentTeacher getStudentTeacher(String id) {

        StudentTeacher studentTeacher = new StudentTeacher();
        Connection con = MySQLConnection.getCon();
        String query = "SELECT `id`,`name`,`email`,`password`,`cnic`,`DOB`,`contact_no`,`address`,`DOA`,`pic`,`dept_name`,`gender`,`post`,`details` FROM `student_teacher` WHERE `id`='" + id + "';";
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(query);
            if (rs.next()) {
                studentTeacher.setIdString(rs.getString(1));
                studentTeacher.setNameString(rs.getString(2));
                studentTeacher.setEmailString(rs.getString(3));
                studentTeacher.setPaswordString(rs.getString(4));
                studentTeacher.setCNICString(rs.getString(5));
                studentTeacher.setDateOfBirthDate(rs.getDate(6));
                studentTeacher.setContactNoString(rs.getString(7));
                studentTeacher.setAddressString(rs.getString(8));
                studentTeacher.setDateOfAdmission(rs.getDate(9));
                studentTeacher.setPicBlob(rs.getBytes(10));
                studentTeacher.setDepartmentName(rs.getString(11));
                studentTeacher.setGenderString(rs.getString(12));
                studentTeacher.setPostString(rs.getString(13));
                studentTeacher.setDetailsString(rs.getString(14));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentTeacherBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studentTeacher;
    }

    public void setStdTchrDetail(StudentTeacher st, File file) {

        String query = "UPDATE `student_teacher` SET `id` = ?,`name` = ?,`email` = ?,`password` = ?,`cnic` = ?,`DOB` = ?,`contact_no` = ?,`address` = ?,`DOA` = ?,`pic` =?,`dept_name` = ?,`gender` = ?,`post` = ?,`details` = ? WHERE `id` = '" + st.getIdString() + "';";
        Connection con = MySQLConnection.getCon();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);

            PreparedStatement stat = con.prepareStatement(query);
            stat.setString(1, st.getIdString());
            stat.setString(2, st.getNameString());
            stat.setString(3, st.getEmailString());
            stat.setString(4, st.getPaswordString());
            stat.setString(5, st.getCNICString());
            stat.setDate(6, st.getDateOfBirthDate());
            stat.setString(7, st.getContactNoString());
            stat.setString(8, st.getAddressString());
            stat.setDate(9, st.getDateOfAdmission());
            stat.setBinaryStream(10, fileInputStream, (int) file.length());
            stat.setString(11, st.getDepartmentName());
            stat.setString(12, st.getGenderString());
            stat.setString(13, st.getPostString());
            stat.setString(14, st.getDetailsString());
            int check = stat.executeUpdate();
            if (check == 1) {
                JOptionPane.showMessageDialog(null, "Record Updated Successfully", "Info", 1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentTeacherBAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StudentTeacherBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setStdTchrDetail(StudentTeacher st) {

        String query = "UPDATE `student_teacher` SET `id` = ?,`name` = ?,`email` = ?,`password` = ?,`cnic` = ?,`DOB` = ?,`contact_no` = ?,`address` = ?,`DOA` = ?,`dept_name` = ?,`gender` = ?,`post` = ?,`details` = ? WHERE `id` = '" + st.getIdString() + "';";
        Connection con = MySQLConnection.getCon();
        try {

            PreparedStatement stat = con.prepareStatement(query);
            stat.setString(1, st.getIdString());
            stat.setString(2, st.getNameString());
            stat.setString(3, st.getEmailString());
            stat.setString(4, st.getPaswordString());
            stat.setString(5, st.getCNICString());
            stat.setDate(6, st.getDateOfBirthDate());
            stat.setString(7, st.getContactNoString());
            stat.setString(8, st.getAddressString());
            stat.setDate(9, st.getDateOfAdmission());
            stat.setString(10, st.getDepartmentName());
            stat.setString(11, st.getGenderString());
            stat.setString(12, st.getPostString());
            stat.setString(13, st.getDetailsString());
            int check = stat.executeUpdate();
            if (check == 1) {
                JOptionPane.showMessageDialog(null, "Record Updated Successfully", "Info", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Record Updation Operation Failed", "Info", 1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentTeacherBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<StudentTeacher> getStdTeacher() {
        Connection con = MySQLConnection.getCon();
        ArrayList<StudentTeacher> arrayList = new ArrayList<>();
        String query = "SELECT\n"
                + "  `id`,\n"
                + "  `name`,\n"
                + "  `email`,\n"
                + "  `password`,\n"
                + "  `cnic`,\n"
                + "  `DOB`,\n"
                + "  `contact_no`,\n"
                + "  `address`,\n"
                + "  `DOA`,\n"
                + "  `pic`,\n"
                + "  `dept_name`,\n"
                + "  `gender`,\n"
                + "  `post`,\n"
                + "  `details`\n"
                + "FROM `student_teacher`;";
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {

                StudentTeacher st = new StudentTeacher();
                st.setIdString(rs.getString(1));
                st.setNameString(rs.getString(2));
                st.setEmailString(rs.getString(3));
                st.setPaswordString(rs.getString(4));
                st.setCNICString(rs.getString(5));
                st.setDateOfBirthDate(rs.getDate(6));
                st.setContactNoString(rs.getString(7));
                st.setAddressString(rs.getString(8));
                st.setDateOfAdmission(rs.getDate(9));
                st.setPicBlob(rs.getBytes(10));
                st.setDepartmentName(rs.getString(11));
                st.setGenderString(rs.getString(12));
                st.setPostString(rs.getString(13));
                arrayList.add(st);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentTeacherBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }

    public ArrayList<StudentTeacher> findByFieldName(String fieldNameString,String searchString) {
        Connection con = MySQLConnection.getCon();
        ArrayList<StudentTeacher> arrayList = new ArrayList<>();
        String query = "SELECT\n"
                + "  `id`,\n"
                + "  `name`,\n"
                + "  `email`,\n"
                + "  `password`,\n"
                + "  `cnic`,\n"
                + "  `DOB`,\n"
                + "  `contact_no`,\n"
                + "  `address`,\n"
                + "  `DOA`,\n"
                + "  `pic`,\n"
                + "  `dept_name`,\n"
                + "  `gender`,\n"
                + "  `post`,\n"
                + "  `details`\n"
                + "FROM `student_teacher` where "+fieldNameString+" like ?;";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, searchString+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                StudentTeacher st = new StudentTeacher();
                st.setIdString(rs.getString(1));
                st.setNameString(rs.getString(2));
                st.setEmailString(rs.getString(3));
                st.setPaswordString(rs.getString(4));
                st.setCNICString(rs.getString(5));
                st.setDateOfBirthDate(rs.getDate(6));
                st.setContactNoString(rs.getString(7));
                st.setAddressString(rs.getString(8));
                st.setDateOfAdmission(rs.getDate(9));
                st.setPicBlob(rs.getBytes(10));
                st.setDepartmentName(rs.getString(11));
                st.setGenderString(rs.getString(12));
                st.setPostString(rs.getString(13));
                arrayList.add(st);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentTeacherBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }
    public boolean insertStdEmp(StudentTeacherChild stc) {

        String query = "INSERT INTO `student_teacher`\n"
                + "VALUES (?,\n"
                + "        ?,\n"
                + "        ?,\n"
                + "        ?,\n"
                + "        ?,\n"
                + "        ?,\n"
                + "        ?,\n"
                + "        ?,\n"
                + "        ?,\n"
                + "        ?,\n"
                + "        ?,\n"
                + "        ?,\n"
                + "        ?,\n"
                + "        ?);";
        Connection con = MySQLConnection.getCon();
        FileInputStream fileInputStream = null;
        try {

            PreparedStatement stat = con.prepareStatement(query);
            stat.setString(1, stc.getIdString());
            stat.setString(2, stc.getNameString());
            stat.setString(3, stc.getEmailString());
            stat.setString(4, stc.getPaswordString());
            stat.setString(5, stc.getCNICString());
            stat.setDate(6, stc.getDateOfBirthDate());
            stat.setString(7, stc.getContactNoString());
            stat.setString(8, stc.getAddressString());
            stat.setDate(9, stc.getDateOfAdmission());
            if (stc.getPicFile() == null) {
                stat.setBinaryStream(10, null);
            } else {
                fileInputStream = new FileInputStream(stc.getPicFile());
                stat.setBinaryStream(10, fileInputStream, (int) stc.getPicFile().length());
            }

            stat.setString(11, stc.getDepartmentName());
            stat.setString(12, stc.getGenderString());
            stat.setString(13, stc.getPostString());
            stat.setString(14, stc.getDetailsString());
            int check = stat.executeUpdate();
            if (check == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(StudentTeacherBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    

    public void deleteStdEmp(String id) {
        String query = "DELETE\n"
                + "FROM `student_teacher`\n"
                + "WHERE `id` = '"+id+"';";
        Connection con = MySQLConnection.getCon();
        try {
            Statement stat = con.createStatement();
            int check = stat.executeUpdate(query);
            if (check == 1) {
                JOptionPane.showMessageDialog(null, "Record Deleted Successfully", "Info", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Record Deletion Failed", "Info", 1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentTeacherBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static int countTotalPatrons(){
        String sql="SELECT count(*) FROM `library management system`.student_teacher;";
        int count=0;
        try {
            ResultSet rs = MySQLConnection.getCon().createStatement().executeQuery(sql);
            count=rs.next()?rs.getInt(1):0;
        } catch (SQLException ex) {
            Logger.getLogger(BooksBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
}
