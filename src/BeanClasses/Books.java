package BeanClasses;

import java.sql.Date;

public class Books {
    
    private int BookNumber;
    private String BookLocation;
    private int BookIssueLimit;
    private  String BookNameString;
    private String BookAuthorString;
    private String BookCategoryString;
    private String BookPublisherString;
    private Date BookPublishingDate;
    private String isbn;
    private int pages;
    private byte[] pic;
    public Books(){
        
    }

    public Books(int BookNumber, String BookLocation, int BookIssueLimit, String BookNameString, String BookAuthorString, String BookCategoryString, String BookPublisherString, Date BookPublishingDate, String isbn, int pages, byte[] pic) {
        this.BookNumber = BookNumber;
        this.BookLocation = BookLocation;
        this.BookIssueLimit = BookIssueLimit;
        this.BookNameString = BookNameString;
        this.BookAuthorString = BookAuthorString;
        this.BookCategoryString = BookCategoryString;
        this.BookPublisherString = BookPublisherString;
        this.BookPublishingDate = BookPublishingDate;
        this.isbn = isbn;
        this.pages = pages;
        this.pic = pic;
    }

    

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
    
    public int getBookNumber() {
        return BookNumber;
    }

    public void setBookNumber(int BookNumber) {
        this.BookNumber = BookNumber;
    }

    public int getBookIssueLimit() {
        return BookIssueLimit;
    }

    public void setBookIssueLimit(int BookIssueLimit) {
        this.BookIssueLimit = BookIssueLimit;
    }

    public String getBookNameString() {
        return BookNameString;
    }

    public void setBookNameString(String BookNameString) {
        this.BookNameString = BookNameString;
    }

    public String getBookAuthorString() {
        return BookAuthorString;
    }

    public void setBookAuthorString(String BookAuthorString) {
        this.BookAuthorString = BookAuthorString;
    }

    public String getBookCategoryString() {
        return BookCategoryString;
    }

    public void setBookCategoryString(String BookCategoryString) {
        this.BookCategoryString = BookCategoryString;
    }

    public String getBookPublisherString() {
        return BookPublisherString;
    }

    public void setBookPublisherString(String BookPublisherString) {
        this.BookPublisherString = BookPublisherString;
    }

    public Date getBookPublishingDate() {
        return BookPublishingDate;
    }

    public void setBookPublishingDate(Date BookPublishingDate) {
        this.BookPublishingDate = BookPublishingDate;
    }

    public String getBookLocation() {
        return BookLocation;
    }

    public void setBookLocation(String BookLocation) {
        this.BookLocation = BookLocation;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "Books{" + "BookNumber=" + BookNumber + ", BookLocation=" + BookLocation + ", BookIssueLimit=" + BookIssueLimit + ", BookNameString=" + BookNameString + ", BookAuthorString=" + BookAuthorString + ", BookCategoryString=" + BookCategoryString + ", BookPublisherString=" + BookPublisherString + ", BookPublishingDate=" + BookPublishingDate + ", isbn=" + isbn + ", pages=" + pages + ", pic=" + pic + '}';
    }

    
    
    
}
