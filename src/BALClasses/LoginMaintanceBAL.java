/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BALClasses;

import Frames.AdminLibrarian.AdminLibForm;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ali.ashique
 */
public class LoginMaintanceBAL {
    public static void logIn(String idString) {
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader("loginAL.txt"));
            String id = bufferedReader.readLine();
            if (id != null && id.length() > 0) {
                bufferedReader.close();
            } else {
                FileWriter fileWriter = new FileWriter("loginAL.txt", true);
                fileWriter.write(idString);
                fileWriter.flush();
                fileWriter.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(AdminLibForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
