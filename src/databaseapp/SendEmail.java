/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseapp;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 *
 * @author Ernest Bieś, PWSZ Tarnów 2019
 */

public class SendEmail {
    private String recipientsTo, recipientsDW, recipientsUDW, subject, msg;
    
    public SendEmail(String recipientsTo, String subject, String msg){
        this.recipientsTo = recipientsTo;
        this.subject = subject;
        this.msg = msg;
    }
    
    public void addRecipients(String addressList, String type){
        if("DW".equals(type)){
            this.recipientsDW = addressList;
        }
        if("UDW".equals(type)){
            this.recipientsUDW = addressList;
        }
    }
    
    private Session init(){
        final String username = "ernestbies12334@gmail.com";
        final String password = "01.cK.23.xR.45";

        Properties prop = new Properties();
	prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        
        return session;
    }
    
    public boolean send(){
        Session session = init();
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ernestbies1234@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(this.recipientsTo)
            );
            
            message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(this.recipientsDW));
            message.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(this.recipientsUDW));
            
            message.setSubject(this.subject);
            message.setText(this.msg);
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            System.err.println("MessagingException. " + e);
            return false;
        }
    }
}