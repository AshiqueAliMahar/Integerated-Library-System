package BeanClasses;

import java.sql.Date;

public class BookIssueDetail {
    
    private int BookNo;
    private Date BookIssueDate;
    private String StatusString;
    private String IdString;

    public BookIssueDetail(int BookNo, Date BookIssueDate, String StatusString, String IdString) {
        this.BookNo = BookNo;
        this.BookIssueDate = BookIssueDate;
        this.StatusString = StatusString;
        this.IdString = IdString;
    }

    public int getBookNo() {
        return BookNo;
    }

    public void setBookNo(int BookNo) {
        this.BookNo = BookNo;
    }

    public Date getBookIssueDate() {
        return BookIssueDate;
    }

    public void setBookIssueDate(Date BookIssueDate) {
        this.BookIssueDate = BookIssueDate;
    }

    public String getStatusString() {
        return StatusString;
    }

    public void setStatusString(String StatusString) {
        this.StatusString = StatusString;
    }

    public String getIdString() {
        return IdString;
    }

    public void setIdString(String IdString) {
        this.IdString = IdString;
    }
    
}
