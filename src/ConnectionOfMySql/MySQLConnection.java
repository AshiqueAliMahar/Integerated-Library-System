/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionOfMySql;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class MySQLConnection {
    
    public static Connection getCon(){
        
        MySQLConnection msqlc=new MySQLConnection();
        
        String user="root";
        String password="hp15p251nz";
        String url="jdbc:mysql://"+msqlc.ip()+":3306/library management system";
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"MariaDB Connection Failed");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Driver Not Loaded");
        }
        return con;
    }
    private String ip(){
        String ip="";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("IPConfig.txt"));
            ip=(bufferedReader.readLine().trim());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ip;
    }
}
