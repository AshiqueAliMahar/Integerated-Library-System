package BALClasses;

import ConnectionOfMySql.MySQLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BooksCategoryBAL {

    Connection connection = new MySQLConnection().getCon();

    public ArrayList getBookCategories() {
        ArrayList arrayList = new ArrayList();
        try {
            Statement createStatement = connection.createStatement();
            ResultSet executeQuery = createStatement.executeQuery("SELECT `book_category` FROM books_category;");
            while (executeQuery.next()) {
                arrayList.add(executeQuery.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BooksBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }

    public void insertCategory(String cName) {
        String query = "insert into `books_category` values('" + cName + "');";
        try {
            Statement stat = connection.createStatement();
            int check = stat.executeUpdate(query);
            if (check == 0) {
                JOptionPane.showMessageDialog(null, "New Category Insertion Failed");
            } else if (check == 1) {
                JOptionPane.showMessageDialog(null, "New Category Inserted Successfully");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BooksBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateCategory(String newCName, String oldCName) {
        String query = "UPDATE books_category\n"
                + "SET `book_category` = '" + newCName + "'\n"
                + "WHERE `book_category` = '" + oldCName + "';";
        try {
            Statement stat = connection.createStatement();
            int check = stat.executeUpdate(query);
            if (check == 0) {
                JOptionPane.showMessageDialog(null, " Category Updation Failed");
            } else if (check == 1) {
                JOptionPane.showMessageDialog(null, "Category Updated Successfully");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BooksBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteCategory(String cName) {
        String query = "DELETE\n"
                + "FROM books_category\n"
                + "WHERE `book_category` = '" + cName + "';";
        try {
            Statement stat = connection.createStatement();
            int check = stat.executeUpdate(query);
            if (check == 0) {
                JOptionPane.showMessageDialog(null, " Category Deletion Failed");
            } else if (check == 1) {
                JOptionPane.showMessageDialog(null, "Category Deleted Successfully");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BooksBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
