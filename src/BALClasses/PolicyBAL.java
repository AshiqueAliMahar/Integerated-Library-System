package BALClasses;

import BeanClasses.Policy;
import ConnectionOfMySql.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PolicyBAL {
    private static String sql="";
    public static Policy getValue(String policyStr){
        
        sql="SELECT `policies`.`policy_name`,`policies`.`policy_val` FROM `library management system`.`policies` where `policies`.`policy_name`=?;";
        Connection con = MySQLConnection.getCon();
        Policy policy=new Policy();
        try(PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, policyStr);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                policy.setPolicyName(rs.getString(1));
                policy.setPolicyVal(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PolicyBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return policy;
    }
    public static boolean save(Policy policy){
        boolean isSaved=false;
        sql="UPDATE `library management system`.`policies` SET `policy_val` = ? WHERE `policy_name` = ?";
        Connection con = MySQLConnection.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, policy.getPolicyVal());
            ps.setString(2, policy.getPolicyName().toString());
            isSaved=!ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PolicyBAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSaved;
    }
    
}
