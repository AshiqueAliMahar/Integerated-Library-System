
package BeanClasses;

import java.sql.Date;

/**
 *
 * @author ashiq
 */
public class Accounts {
        private  int AccountAmount;    
        private String AccountPassword;
        private String AccountNumber;
        private  String AccountHolderName;
        private  String AccountType;
        private String AccountHolCNIC;
        private String AccountHolderAddress;
        private Date AccountOpenedDate;

    public int getAccountAmount() {
        return AccountAmount;
    }

    public void setAccountAmount(int AccountAmount) {
        this.AccountAmount = AccountAmount;
    }

    public String getAccountPassword() {
        return AccountPassword;
    }

    public void setAccountPassword(String AccountPassword) {
        this.AccountPassword = AccountPassword;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public String getAccountHolderName() {
        return AccountHolderName;
    }

    public void setAccountHolderName(String AccountHolderName) {
        this.AccountHolderName = AccountHolderName;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String AccountType) {
        this.AccountType = AccountType;
    }

    public String getAccountHolCNIC() {
        return AccountHolCNIC;
    }

    public void setAccountHolCNIC(String AccountHolCNIC) {
        this.AccountHolCNIC = AccountHolCNIC;
    }

    public String getAccountHolderAddress() {
        return AccountHolderAddress;
    }

    public void setAccountHolderAddress(String AccountHolderAddress) {
        this.AccountHolderAddress = AccountHolderAddress;
    }

    public Date getAccountOpenedDate() {
        return AccountOpenedDate;
    }

    public void setAccountOpenedDate(Date AccountOpenedDate) {
        this.AccountOpenedDate = AccountOpenedDate;
    }
        
}
