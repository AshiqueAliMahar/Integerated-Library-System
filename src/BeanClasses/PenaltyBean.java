package BeanClasses;

public class PenaltyBean {
    
    private long bkNumber;
    private String id;
    private int amount;
    private java.sql.Date payDate;

    public long getBkNumber() {
        return bkNumber;
    }

    public void setBkNumber(long bkNumber) {
        this.bkNumber = bkNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public java.sql.Date getPayDate() {
        return payDate;
    }

    public void setPayDate(java.sql.Date payDate) {
        this.payDate = payDate;
    }
    
    
}
