package email_Penalty_Students;

import BALClasses.BookissueDetailBAL;
import emailSending.EmailSend;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class PenaltyPatronMessage extends Thread {

    private void sendMail() throws AddressException {
        //EmailSend emailSend = new EmailSend();
        String title = "MUET";
        String message = "You should return book as soon as possible";
        List<Map<String, String>> penaltyPatrons = BookissueDetailBAL.getPenaltyPatrons();
        
        InternetAddress[] address =new InternetAddress[penaltyPatrons.size()];
        int count=0;
        for (Map<String, String> penaltyPatron : penaltyPatrons) {
            address[count]=new InternetAddress(penaltyPatron.get("email"));
            count++;
        }
        EmailSend.sendMail(title, message,address);
    }

    @Override
    public void run() {
        super.run();
        try {
            sendMail();
        } catch (AddressException ex) {
            Logger.getLogger(PenaltyPatronMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
