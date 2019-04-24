package com.example.demo.samples;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
 
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
 
public class GmailInbox {
 
    public static void main(String[] args) {
 
        GmailInbox gmail = new GmailInbox();
        gmail.read();
 
    }
 
    public void read() {
 
        Properties props = new Properties();
 
        try {
            //props.load(new FileInputStream(new File("C:\\smtp.properties")));
//            mail.smtp.host=smtp.gmail.com
//    	    mail.smtp.socketFactory.port=465
//    	    mail.smtp.socketFactory.class=javax.net.ssl.SSLSocketFactory
//    	    mail.smtp.auth=true
//    	    mail.smtp.port=465
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", 465);
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", true);
            props.put("mail.smtp.port", 465);
            System.out.println("----------------1--------------");
            Session session = Session.getDefaultInstance(props, null);
            System.out.println("----------------2--------------");
            Store store = session.getStore("imaps");
            store.connect("smtp.gmail.com", "pavanjayam87@gmail.com", "India@7887");
            System.out.println("----------------3--------------");
            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);
            int messageCount = inbox.getMessageCount();
            System.out.println("----------------4--------------");
            System.out.println("Total Messages:- " + messageCount);
 
            Message[] messages = inbox.getMessages();
            System.out.println("------------------------------"+messages.length);
 
            for (int i = 0; i < 10; i++) {
                System.out.println("Mail Subject:- " + messages[i].getSubject());
            }
 
            inbox.close(true);
            store.close();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
}
