package BALClasses;

import java.awt.Image;
import java.util.Date;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GeneralBAL {
    public static boolean isEmailCorrect(String emailString){
        boolean isEmailCorrect=false;
        InternetAddress obj;
        try {
            obj = new InternetAddress(emailString);
            obj.validate();
            isEmailCorrect = true;
        } catch (AddressException ex) {
            isEmailCorrect = false;
            JOptionPane.showMessageDialog(null, "Enter correct Email address","Warning",0);
        }
        return isEmailCorrect;
    }

    public ImageIcon getImageIcon(byte[] imageBytes){
        ImageIcon image = new ImageIcon(imageBytes);
        Image im = image.getImage();
        Image myImg = im.getScaledInstance(177, 175, Image.SCALE_SMOOTH);
        ImageIcon newImage = new ImageIcon(myImg);
        return newImage;
    }
    public long getIssueToNowDays(java.sql.Date d){
        long days=(new java.sql.Date(new Date().getTime()).getTime()-d.getTime())/(1000*60*60*24);
        return days;
    }
    
}
