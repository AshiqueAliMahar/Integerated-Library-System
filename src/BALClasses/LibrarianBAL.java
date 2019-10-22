package BALClasses;

import BeanClasses.Librarian;
import BeanClasses.LibrarianChild;
import ConnectionOfMySql.MySQLConnection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LibrarianBAL {

    Connection con = new MySQLConnection().getCon();

    public Librarian getLibrarian(String emailString, String passwordString) {

        Librarian librarian = new Librarian();
        String queryString = "SELECT `lib_id`,`lib_name`,`lib_pass`,`lib_cnic`,`lib_address`,`lib_contact_no`,`lib_email`,`lib_type`,`lib_pic`,`gender` FROM librarian WHERE lib_email='" + emailString + "' AND lib_pass='" + passwordString + "'; ";
        try {
            Statement stat = con.createStatement();
            ResultSet eResultSet = stat.executeQuery(queryString);
            if (eResultSet.next()) {
                librarian.setLibId(eResultSet.getString(1));
                librarian.setLibName(eResultSet.getString(2));
                librarian.setLibPassword(eResultSet.getString(3));
                librarian.setLibCNIC(eResultSet.getString(4));
                librarian.setLibAddress(eResultSet.getString(5));
                librarian.setLibContactNo(eResultSet.getString(6));
                librarian.setLibEmail(eResultSet.getString(7));
                librarian.setLibType(eResultSet.getString(8));
                librarian.setLibPic(eResultSet.getBytes(9));
                librarian.setGender(eResultSet.getString(10));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibrarianBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return librarian;
    }

    public boolean isEmail(String email) {

        boolean isEmailRight = false;
        String query = "SELECT `lib_email` FROM `librarian` WHERE `lib_email`='" + email + "';";
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(query);
            isEmailRight = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(StudentTeacherBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isEmailRight;
    }
    public boolean isAdmin(String id) {

        boolean isItAdmin = false;
        String query = "SELECT `lib_type` FROM `librarian` WHERE `lib_id`='" + id + "' and lib_type='Admin';";
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(query);
            isItAdmin = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(StudentTeacherBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isItAdmin;
    }
    public boolean isCnicExist(String cnic) {

        boolean isCNICExist = false;
        String query = "SELECT `lib_cnic` FROM `librarian` WHERE `lib_cnic`='" + cnic + "';";
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(query);
            isCNICExist = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(StudentTeacherBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isCNICExist;
    }

    public void setPassword(String passwordString, String email) {
        String query = "UPDATE `librarian`  SET  `lib_pass` = '" + passwordString + "' WHERE  `lib_email`= '" + email + "';";
        //
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

    public Librarian getLibrarian(String idString) {
        Librarian librarian = new Librarian();
        try {
            String query = "SELECT\n"
                    + "  `lib_id`,\n"
                    + "  `lib_name`,\n"
                    + "  `lib_pass`,\n"
                    + "  `lib_cnic`,\n"
                    + "  `lib_address`,\n"
                    + "  `lib_contact_no`,\n"
                    + "  `lib_email`,\n"
                    + "  `lib_type`,\n"
                    + "  `lib_pic`,\n"
                    + "  `gender`\n"
                    + "FROM `librarian` where `lib_id`='" + idString + "';";
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(query);
            if (rs.next()) {
                librarian = new Librarian(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getBytes(9), rs.getString(10));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibrarianBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return librarian;
    }

    public void setLibrarian(LibrarianChild librarianChild) {
        FileInputStream pic = null;
        try {

            String query = "UPDATE `librarian`\n"
                    + "SET `lib_id` = ?,\n"
                    + "  `lib_name` = ?,\n"
                    + "  `lib_pass` = ?,\n"
                    + "  `lib_cnic` = ?,\n"
                    + "  `lib_address` = ?,\n"
                    + "  `lib_contact_no` = ?,\n"
                    + "  `lib_email` = ?,\n"
                    + "  `lib_type` = ?,\n"
                    + "  `lib_pic` = ?,\n"
                    + "  `gender` = ?\n"
                    + "WHERE `lib_id` = '" + librarianChild.getLibId() + "';";
            if (librarianChild.getFileName() == null) {
                StringBuilder stringBuilder = new StringBuilder(query);
                int startIndex = stringBuilder.indexOf("`lib_pic` = ?,");
                stringBuilder = stringBuilder.delete(startIndex, startIndex + "`lib_pic` = ?,".length());
                query = stringBuilder.toString();
            } else {
                pic = new FileInputStream(librarianChild.getFileName());
            }
            PreparedStatement stat = con.prepareStatement(query);
            stat.setString(1, librarianChild.getLibId());
            stat.setString(2, librarianChild.getLibName());
            stat.setString(3, librarianChild.getLibPassword());
            stat.setString(4, librarianChild.getLibCNIC());
            stat.setString(5, librarianChild.getLibAddress());
            stat.setString(6, librarianChild.getLibContactNo());
            stat.setString(7, librarianChild.getLibEmail());
            stat.setString(8, librarianChild.getLibType());
            if (librarianChild.getFileName() == null) {
                //stat.setBinaryStream(9, pic, (int) librarianChild.getFileName().length());
                stat.setString(9, librarianChild.getGender());
            } else {
                stat.setBinaryStream(9, pic, (int) librarianChild.getFileName().length());
                stat.setString(10, librarianChild.getGender());

            }
            int check = stat.executeUpdate();
            if (check == 1) {
                JOptionPane.showMessageDialog(null, "Record Updated Successfully", "Info", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Record Updation Operation Failed", "Info", 1);
            }
        } catch (FileNotFoundException | SQLException ex) {
            Logger.getLogger(LibrarianBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int countLibrarian() {
        String sql = "SELECT count(*) FROM `library management system`.librarian where lib_type='Librarian';";
        int count = 0;
        try {
            ResultSet rs = MySQLConnection.getCon().createStatement().executeQuery(sql);
            count = rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException ex) {
            Logger.getLogger(BooksBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public List<Librarian> getLibrarians(String libType) {
        String sql = "SELECT `librarian`.`lib_id`,\n"
                + "    `librarian`.`lib_name`,\n"
                + "    `librarian`.`lib_pass`,\n"
                + "    `librarian`.`lib_cnic`,\n"
                + "    `librarian`.`lib_address`,\n"
                + "    `librarian`.`lib_contact_no`,\n"
                + "    `librarian`.`lib_email`,\n"
                + "    `librarian`.`lib_type`,\n"
                + "    `librarian`.`lib_pic`,\n"
                + "    `librarian`.`gender`\n"
                + "FROM `library management system`.`librarian` where lib_type=?;";
        List<Librarian> librarians = new LinkedList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, libType);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Librarian librarian = new Librarian();
                librarian.setLibId(rs.getString(1));
                librarian.setLibName(rs.getString(2));
                librarian.setLibPassword(rs.getString(3));
                librarian.setLibCNIC(rs.getString(4));
                librarian.setLibAddress(rs.getString(5));
                librarian.setLibContactNo(rs.getString(6));
                librarian.setLibEmail(rs.getString(7));
                librarian.setLibType(rs.getString(8));
                librarian.setLibPic(rs.getBytes(9));
                librarian.setGender(rs.getString(10));
                librarians.add(librarian);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibrarianBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return librarians;
    }

    public boolean addLibrarian(Librarian l) {
        boolean isSaved = false;
        String sql = "";
        Librarian librarian = getLibrarian(l.getLibId());
        if (librarian.getLibId() != null && librarian.getLibId().equals(l.getLibId())) {
            isSaved=update(l, librarian);
        } else {
            if (!isEmail(librarian.getLibEmail())) {
                if (!isCnicExist(librarian.getLibCNIC())) {
            sql = "INSERT INTO `librarian` (`lib_id`,`lib_name`,`lib_pass`,`lib_cnic`,`lib_address`,`lib_contact_no`,`lib_email`,`lib_type`,`lib_pic`,`gender`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            try {

                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, l.getLibId());
                ps.setString(2, l.getLibName());
                ps.setString(3, l.getLibPassword());
                ps.setString(4, l.getLibCNIC());
                ps.setString(5, l.getLibAddress());
                ps.setString(6, l.getLibContactNo());
                ps.setString(7, l.getLibEmail());
                ps.setString(8, l.getLibType());
                ps.setBytes(9, l.getLibPic());
                ps.setString(10, l.getGender());
                isSaved = !ps.execute();
            } catch (SQLException ex) {
                Logger.getLogger(LibrarianBAL.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else JOptionPane.showMessageDialog(null, "CNIC Number Already Exist");
            }else JOptionPane.showMessageDialog(null, "Email Already Exist In System");
        }
        return isSaved;
    }
    
    private boolean update(Librarian l,Librarian existent){
        boolean isSaved=false;
        if (!isAdmin(l.getLibId())) {
            
        
        String sql = "UPDATE `library management system`.`librarian`\n"
                    + "SET"
                    + "`lib_name` = ?,\n"
                    + "`lib_pass` = ?,\n"
                    + "`lib_cnic` = ?,\n"
                    + "`lib_address` = ?,\n"
                    + "`lib_contact_no` = ?,\n"
                    + "`lib_email` = ?,\n"
                    + "`lib_type` = ?,\n"
                    + "`lib_pic` = ?,\n"
                    + "`gender` = ?\n"
                    + "WHERE `lib_id` = ?;";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(10, l.getLibId());
                ps.setString(1, l.getLibName());
                ps.setString(2, l.getLibPassword());
                ps.setString(3, l.getLibCNIC());
                ps.setString(4, l.getLibAddress());
                ps.setString(5, l.getLibContactNo());
                ps.setString(6, l.getLibEmail());
                ps.setString(7, l.getLibType());
                if (l.getLibPic().length==0) ps.setBytes(8, existent.getLibPic());
                else ps.setBytes(8, l.getLibPic());
                ps.setString(9, l.getGender());
                isSaved = !ps.execute();
            } catch (SQLException ex) {
                Logger.getLogger(LibrarianBAL.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else JOptionPane.showMessageDialog(null, "You Can't Change Admin");
            return isSaved;
    }
    public  boolean deleteById(String id){
        boolean isDel=false;
        String sql="DELETE FROM `librarian` WHERE lib_id=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            isDel=!ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(LibrarianBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isDel;
    }
}

