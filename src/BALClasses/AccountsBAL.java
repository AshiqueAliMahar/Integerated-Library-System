package BALClasses;

import BeanClasses.Accounts;
import ConnectionOfMySql.MySQLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AccountsBAL {

    MySQLConnection mySQLConnection = new MySQLConnection();

    public Accounts getAccount(String accountNumber) {
        Accounts accounts = new Accounts();
        String sql = "SELECT\n"
                + "  `acc_no`,\n"
                + "  `acc_hol_name`,\n"
                + "  `acc_type`,\n"
                + "  `amount`,\n"
                + "  `acc_hold_addr`,\n"
                + "  `acc_opened_date`,\n"
                + "  `acc_hol_cnic`,\n"
                + "  `bank_branch_code`,\n"
                + "  `acc_pin`\n"
                + "FROM `accounts` where `acc_no`='" + accountNumber + "';";
        Connection con = mySQLConnection.getCon();
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {

                accounts.setAccountNumber(rs.getString(1));
                accounts.setAccountHolderName(rs.getString(2));
                accounts.setAccountType(rs.getString(3));
                accounts.setAccountAmount(rs.getInt(4));
                accounts.setAccountHolderAddress(rs.getString(5));
                accounts.setAccountOpenedDate(rs.getDate(6));
                accounts.setAccountHolCNIC(rs.getString(7));
                accounts.setAccountPassword(rs.getString(9));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountsBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accounts;
    }

    public void payAmount(Accounts accounts, String accountNumber,int amount) {
        String insertAmount = "UPDATE `accounts`\n"
                + "SET `amount` = amount+"+amount+"\n"
                + "WHERE `acc_no` = '"+accountNumber+"';";
        String withDrawAmount="UPDATE `accounts`\n"
                + "SET `amount` = amount-"+amount+"\n"
                + "WHERE `acc_no` = '"+accounts.getAccountNumber()+"';";
        Connection con = mySQLConnection.getCon();
        try {
            Statement stat = con.createStatement();
            int executeUpdate = stat.executeUpdate(insertAmount);
            int check = stat.executeUpdate(withDrawAmount);
            if(executeUpdate==1 && check==1){
                JOptionPane.showMessageDialog(null,"Penalty Paid");
            }else{
                JOptionPane.showMessageDialog(null,"Penalty Payment Failed");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountsBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
