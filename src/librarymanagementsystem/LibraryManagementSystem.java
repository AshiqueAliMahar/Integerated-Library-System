package librarymanagementsystem;

import BALClasses.BookissueDetailBAL;
import Frames.WelcomeForm;
import email_Penalty_Students.PenaltyPatronMessage;
import java.util.HashMap;
import java.util.Map;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        BookissueDetailBAL bookissueDetailBAL=new BookissueDetailBAL();
        bookissueDetailBAL.removeRsrved();
        NimbusLook();
        
        Map<String,Integer> sizeLocation=new HashMap<>();
        sizeLocation.put("sizex", 1072);
        sizeLocation.put("sizeY", 657);
        sizeLocation.put("locx", 250);
        sizeLocation.put("locy", 50);
        WelcomeForm logInForm=new WelcomeForm(sizeLocation);
        logInForm.setVisible(true);
        PenaltyPatronMessage ppm=new PenaltyPatronMessage();
        Thread t=new Thread(ppm);
        //t.start();
    }
    
    private static void NimbusLook(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibraryManagementSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
