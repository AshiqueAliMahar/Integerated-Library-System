
package emailSending;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
public class EmailSend {

    public void sendMail(String email,String subjectOfMessage,String message,String notification){
        try{
            String host ="smtp.gmail.com" ;
            String user = "nisarmahar8157@gmail.com";
            String pass = "hakimALI";
            String to = email;
            String from = "nisarmahar8157@gmail.com";
            String subject = subjectOfMessage;
            String messageText = message;
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); 
            msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
            if (notification!=null) {
                JOptionPane.showMessageDialog(null,notification);
            }
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Check Internet Connectin//Contact With Developer");
            ex.printStackTrace();
        }

    }
    public static void sendMail(String subjectOfMessage,String message,InternetAddress [] address){
        try{
            String host ="smtp.gmail.com" ;
            String user = "nisarmahar8157@gmail.com";
            String pass = "hakimALI";
            String from = "nisarmahar8157@gmail.com";
            String subject = subjectOfMessage;
            String messageText = message;
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); 
            msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
            
        }catch(Exception ex)
        {
            //JOptionPane.showMessageDialog(null,"Check Internet Connectin//Contact With Developer");
            ex.printStackTrace();
        }

    }
//    public static void main(String[] args) throws AddressException {
//        InternetAddress [] emails={new InternetAddress("16cs13@students.muet.edu.pk"),new InternetAddress("ashiqueali2015@outlook.com"),new InternetAddress("nisarmahar8157@gmail.com")};
//        sendMail("hello", "hello mess", emails);
//    }
}
