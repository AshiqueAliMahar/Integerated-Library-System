package BALClasses;

import BeanClasses.Books;
import ConnectionOfMySql.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BooksBAL {

    Books books = null;
    private final static MySQLConnection MYSQLCON = new MySQLConnection();
    private final static Connection CON = MYSQLCON.getCon();

    public ArrayList<Books> getBooks() {

        ArrayList<Books> arrayListBooks = new ArrayList<>();
        String query = "SELECT * FROM `books` b LEFT JOIN `books_ issue_detail` bid USING(bk_no) WHERE bid.`bk_no` IS NULL group by b.isbn;";

        try {
            Statement statement = CON.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                resultSet.getInt(1);
                books = new Books();
                books.setBookNumber(resultSet.getInt(1));
                books.setBookNameString(resultSet.getString(2));
                books.setBookAuthorString(resultSet.getString(3));
                books.setBookCategoryString(resultSet.getString(4));
                books.setBookPublisherString(resultSet.getString(5));
                books.setBookLocation(resultSet.getString(6));
                books.setBookPublishingDate(resultSet.getDate(7));
                books.setBookIssueLimit(resultSet.getInt(8));
                books.setIsbn(resultSet.getString(9));
                books.setPages(resultSet.getInt(10));
                books.setPic(resultSet.getBytes(11));
                arrayListBooks.add(books);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return arrayListBooks;
    }
    public ArrayList<Books> getAvailBooks(String isbn) {

        ArrayList<Books> arrayListBooks = new ArrayList<>();
        String query = "SELECT * FROM `books` b LEFT JOIN `books_ issue_detail` bid USING(bk_no) WHERE bid.`bk_no` IS NULL and b.isbn='"+isbn+"'";

        try {
            Statement statement = CON.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                resultSet.getInt(1);
                books = new Books();
                books.setBookNumber(resultSet.getInt(1));
                books.setBookNameString(resultSet.getString(2));
                books.setBookAuthorString(resultSet.getString(3));
                books.setBookCategoryString(resultSet.getString(4));
                books.setBookPublisherString(resultSet.getString(5));
                books.setBookLocation(resultSet.getString(6));
                books.setBookPublishingDate(resultSet.getDate(7));
                books.setBookIssueLimit(resultSet.getInt(8));
                books.setIsbn(resultSet.getString(9));
                books.setPages(resultSet.getInt(10));
                books.setPic(resultSet.getBytes(11));
                arrayListBooks.add(books);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return arrayListBooks;
    }
    public ArrayList<Books> getTotalLibraryBooks() {

        ArrayList<Books> arrayListBooks = new ArrayList<>();
        String query = "SELECT `bk_no`,`bk_name`,`bk_author`,`bk_category`,`bk_publisher`,`bk_location`,`bk_pub_date`,`bk_issue_limit`,`isbn`,pages,pic FROM `books` group by isbn;";
        try {
            Statement statement = CON.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                resultSet.getInt(1);
                books = new Books();
                books.setBookNumber(resultSet.getInt(1));
                books.setBookNameString(resultSet.getString(2));
                books.setBookAuthorString(resultSet.getString(3));
                books.setBookCategoryString(resultSet.getString(4));
                books.setBookPublisherString(resultSet.getString(5));
                books.setBookLocation(resultSet.getString(6));
                books.setBookPublishingDate(resultSet.getDate(7));
                books.setBookIssueLimit(resultSet.getInt(8));
                books.setIsbn(resultSet.getString(9));
                books.setPages(resultSet.getInt(10));
                books.setPic(resultSet.getBytes(11));
                arrayListBooks.add(books);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return arrayListBooks;
    }
    public ArrayList<Books> getTotalLibraryBooks(String isbn) {

        ArrayList<Books> arrayListBooks = new ArrayList<>();
        String query = "SELECT `bk_no`,`bk_name`,`bk_author`,`bk_category`,`bk_publisher`,`bk_location`,`bk_pub_date`,`bk_issue_limit`,`isbn`,pages,pic FROM `books` where isbn='"+isbn+"';";
        try {
            Statement statement = CON.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                resultSet.getInt(1);
                books = new Books();
                books.setBookNumber(resultSet.getInt(1));
                books.setBookNameString(resultSet.getString(2));
                books.setBookAuthorString(resultSet.getString(3));
                books.setBookCategoryString(resultSet.getString(4));
                books.setBookPublisherString(resultSet.getString(5));
                books.setBookLocation(resultSet.getString(6));
                books.setBookPublishingDate(resultSet.getDate(7));
                books.setBookIssueLimit(resultSet.getInt(8));
                books.setIsbn(resultSet.getString(9));
                books.setPages(resultSet.getInt(10));
                books.setPic(resultSet.getBytes(11));
                arrayListBooks.add(books);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return arrayListBooks;
    }

    public ArrayList<Books> getTotalLibraryBooks(String anyString, String fieldnameString) {

        ArrayList<Books> arrayListBooks = new ArrayList<>();
        String query = "SELECT * FROM `books` where  " + fieldnameString + " like '" + anyString + "%' group by isbn;";

        try {
            Statement statement = CON.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                resultSet.getInt(1);
                books = new Books();
                books.setBookNumber(resultSet.getInt(1));
                books.setBookNameString(resultSet.getString(2));
                books.setBookAuthorString(resultSet.getString(3));
                books.setBookCategoryString(resultSet.getString(4));
                books.setBookPublisherString(resultSet.getString(5));
                books.setBookLocation(resultSet.getString(6));
                books.setBookPublishingDate(resultSet.getDate(7));
                books.setBookIssueLimit(resultSet.getInt(8));
                books.setIsbn(resultSet.getString(9));
                books.setPages(resultSet.getInt(10));
                books.setPic(resultSet.getBytes(11));
                arrayListBooks.add(books);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return arrayListBooks;
    }

    public ArrayList<Books> getBooks(String anyString, String fieldnameString) {

        ArrayList<Books> arrayListBooks = new ArrayList<>();

        String query = "SELECT bk_no,bk_name,bk_author,bk_category,bk_publisher,bk_location,bk_pub_date,bk_issue_limit,isbn,pages,pic FROM books LEFT JOIN `books_ issue_detail` bid USING(bk_no) WHERE bid.`bk_no` IS NULL AND " + fieldnameString + " like '" + anyString + "%' group by isbn; ";

        try {
            Statement statement = CON.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                resultSet.getInt(1);
                books = new Books();
                books.setBookNumber(resultSet.getInt(1));
                books.setBookNameString(resultSet.getString(2));
                books.setBookAuthorString(resultSet.getString(3));
                books.setBookCategoryString(resultSet.getString(4));
                books.setBookPublisherString(resultSet.getString(5));
                books.setBookLocation(resultSet.getString(6));
                books.setBookPublishingDate(resultSet.getDate(7));
                books.setBookIssueLimit(resultSet.getInt(8));
                books.setIsbn(resultSet.getString(9));
                books.setPages(resultSet.getInt(10));
                books.setPic(resultSet.getBytes(11));
                arrayListBooks.add(books);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return arrayListBooks;
    }

    public ArrayList<Books> getBooksIdName(String idString, String statusString) {

        ArrayList<Books> arrayListBooks = new ArrayList<>();

        String query = "SELECT b.bk_no,bk_name,bk_author,bk_category,bk_publisher,bk_location,bk_pub_date,bk_issue_limit,isbn,pages,pic FROM books b INNER JOIN `books_ issue_detail` bid ON(bid.`bk_no`=b.`bk_no` AND bid.`std_id`='" + idString + "' AND `status`='" + statusString + "');";

        try {
            Statement statement = CON.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                resultSet.getInt(1);
                books = new Books();
                books.setBookNumber(resultSet.getInt(1));
                books.setBookNameString(resultSet.getString(2));
                books.setBookAuthorString(resultSet.getString(3));
                books.setBookCategoryString(resultSet.getString(4));
                books.setBookPublisherString(resultSet.getString(5));
                books.setBookLocation(resultSet.getString(6));
                books.setBookPublishingDate(resultSet.getDate(7));
                books.setBookIssueLimit(resultSet.getInt(8));
                books.setIsbn(resultSet.getString(9));
                books.setPages(resultSet.getInt(10));
                books.setPic(resultSet.getBytes(11));
                arrayListBooks.add(books);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return arrayListBooks;
    }

    public void deleteBook(int bookId) {

        String query = "DELETE FROM books WHERE `bk_no` =" + bookId + ";";
        try {
            Statement statement = CON.createStatement();
            int check = statement.executeUpdate(query);
            if (check == 0) {
                JOptionPane.showMessageDialog(null, "Book Deletion Operation Failed");
            } else if (check == 1) {
                JOptionPane.showMessageDialog(null, "Book Deleted Successfully");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BooksBAL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateBook(Books books) {
        String query = "UPDATE books SET "
                + "`bk_name` = '" + books.getBookNameString() + "',"
                + "`bk_author` = '" + books.getBookAuthorString() + "',"
                + "`bk_category` = '" + books.getBookCategoryString() + "',"
                + "`bk_publisher` = '" + books.getBookPublisherString() + "',"
                + "  `bk_location` = '" + books.getBookLocation() + "',"
                + "  `bk_pub_date` = '" + books.getBookPublishingDate() + "',"
                + "  `bk_issue_limit` = '" + books.getBookIssueLimit() + "',"
                + "isbn='"+books.getIsbn()+"',pages='"+books.getPages()
                + "',pic=? WHERE `isbn` = '" + books.getIsbn() + "';";
        try {
            PreparedStatement ps = CON.prepareStatement(query);
            if (books.getPic().length==0) {
                ArrayList<Books> totalLibraryBooks = getTotalLibraryBooks(books.getIsbn());
                ps.setBytes(1, totalLibraryBooks.get(0).getPic());
            }else{
                ps.setBytes(1, books.getPic());
            }
            
            int check = ps.executeUpdate();
            
            
            if (check == 0) {
                JOptionPane.showMessageDialog(null, "Book Modification Operation Failed");
            } else if (check == 1) {
                JOptionPane.showMessageDialog(null, "Book Detail Updated Successfully");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BooksBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int addBook(Books books) {
        int check=0;
        String query = "INSERT INTO `library management system`.`books`\n"
                + "            (`bk_name`,\n"
                + "             `bk_author`,\n"
                + "             `bk_category`,\n"
                + "             `bk_publisher`,\n"
                + "             `bk_location`,\n"
                + "             `bk_pub_date`,\n"
                + "             `bk_issue_limit`,isbn,pages,pic)\n"
                + "VALUES ('" + books.getBookNameString() + "',\n"
                + "        '" + books.getBookAuthorString() + "',\n"
                + "        '" + books.getBookCategoryString() + "',\n"
                + "        '" + books.getBookPublisherString() + "',\n"
                + "        '" + books.getBookLocation() + "',\n"
                + "        '" + books.getBookPublishingDate() + "',\n"
                + "        '" + books.getBookIssueLimit() + "',"
                + "'"+books.getIsbn()+"','"+books.getPages()+"',?);";
        try {
            PreparedStatement ps = CON.prepareStatement(query);
            ps.setBytes(1, books.getPic());
            check = ps.executeUpdate();
//            if (check == 0) {
//                JOptionPane.showMessageDialog(null, "New Book Insertion Failed");
//            } else if (check == 1) {
//                JOptionPane.showMessageDialog(null, "New Book Inserted Successfully");
//            }
        } catch (SQLException ex) {
            Logger.getLogger(BooksBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public long getNextBookNo() {
        String query = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name='books';";
        long bookNumber = 0;
        try {
            Statement stat = CON.createStatement();
            ResultSet executeQuery = stat.executeQuery(query);
            if (executeQuery.next()) {
                bookNumber = executeQuery.getLong(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BooksBAL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bookNumber;
    }

    public boolean isAvailable(String bookNumber) {
        boolean check = false;
        String query = "SELECT\n"
                + "  `bk_no`\n"
                + "FROM `books` WHERE bk_no='"+bookNumber+"'"
                + "LIMIT 1;";
        try {
            Statement stat = CON.createStatement();
            ResultSet rs = stat.executeQuery(query);
            check=rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(BooksBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
    public boolean isISBNAvailable(String isbn) {
        boolean check = false;
        String query = "SELECT\n"
                + "  `bk_no`\n"
                + "FROM `books` WHERE isbn='"+isbn+"'"
                + "LIMIT 1;";
        try {
            Statement stat = CON.createStatement();
            ResultSet rs = stat.executeQuery(query);
            check=rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(BooksBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
    public Books getBooks(String bookNumber){
        
       String query = "SELECT * FROM `books` where  `bk_no`='"+bookNumber+"';";

        try {
            Statement statement = CON.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                resultSet.getInt(1);
                books = new Books();
                books.setBookNumber(resultSet.getInt(1));
                books.setBookNameString(resultSet.getString(2));
                books.setBookAuthorString(resultSet.getString(3));
                books.setBookCategoryString(resultSet.getString(4));
                books.setBookPublisherString(resultSet.getString(5));
                books.setBookLocation(resultSet.getString(6));
                books.setBookPublishingDate(resultSet.getDate(7));
                books.setBookIssueLimit(resultSet.getInt(8));
                books.setIsbn(resultSet.getString(9));
                books.setPages(resultSet.getInt(10));
                books.setPic(resultSet.getBytes(11));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return  books;
    }
    public static int countTotalBooks(String isbn){
        String sql="select count(isbn) from books where isbn='"+isbn+"' group by isbn";
        int count=0;
        try {
            ResultSet rs = CON.createStatement().executeQuery(sql);
            count=rs.next()?rs.getInt(1):0;
        } catch (SQLException ex) {
            Logger.getLogger(BooksBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
                
    }
    public static int countAvailBooks(String isbn){
        String sql="SELECT count(isbn) FROM `books` b LEFT JOIN `books_ issue_detail` bid USING(bk_no) WHERE bid.`bk_no` IS NULL and b.isbn='"+isbn+"' group by b.isbn;";
        int count=0;
        try {
            ResultSet rs = CON.createStatement().executeQuery(sql);
            count=rs.next()?rs.getInt(1):0;
        } catch (SQLException ex) {
            Logger.getLogger(BooksBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
                
    }
    public static int countTotalBooks(){
        String sql="select count(*) from books";
        int count=0;
        try {
            ResultSet rs = CON.createStatement().executeQuery(sql);
            count=rs.next()?rs.getInt(1):0;
        } catch (SQLException ex) {
            Logger.getLogger(BooksBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
                
    }
    public static int countAvailBooks(){
        String sql="SELECT count(*) FROM `books` b LEFT JOIN `books_ issue_detail` bid USING(bk_no) WHERE bid.`bk_no` IS NULL;";
        int count=0;
        try {
            ResultSet rs = CON.createStatement().executeQuery(sql);
            count=rs.next()?rs.getInt(1):0;
        } catch (SQLException ex) {
            Logger.getLogger(BooksBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
                
    }
    public static int countIssuedBks(){
        String sql="SELECT count(*) FROM `library management system`.`books_ issue_detail` where status='issued'";
        int count=0;
        try {
            ResultSet rs = CON.createStatement().executeQuery(sql);
            count=rs.next()?rs.getInt(1):0;
        } catch (SQLException ex) {
            Logger.getLogger(BooksBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    public static int countReservedBks(){
        String sql="SELECT count(*) FROM `library management system`.`books_ issue_detail` where status='reserved'";
        int count=0;
        try {
            ResultSet rs = CON.createStatement().executeQuery(sql);
            count=rs.next()?rs.getInt(1):0;
        } catch (SQLException ex) {
            Logger.getLogger(BooksBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
}
