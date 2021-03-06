package com.example.demo.samples;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

import com.example.demo.utils.Constants;

public class ReceiveMail{  
  
 public static void receiveEmail(String pop3Host, String storeType,  
  final String user, final String password) {  
  try {  
   //1) get the session object  
   Properties properties = new Properties();  
   properties.put("mail.store.protocol", "pop3");  
   //Session emailSession = Session.getDefaultInstance(properties);  
    Session emailSession = Session.getDefaultInstance(properties,
   new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
     return new PasswordAuthentication(user,password);
    }
   }); 
   //2) create the POP3 store object and connect with the pop server  
   Store emailStore = emailSession.getStore("pop3");
 emailStore.connect("pop.gmail.com","pavanjayam87@gmail.com", password);
    
  
   //3) create the folder object and open it  
   Folder emailFolder = emailStore.getFolder("INBOX");  
   emailFolder.open(Folder.READ_ONLY);  
  
   //4) retrieve the messages from the folder in an array and print it  
   Message[] messages = emailFolder.getMessages();  
   for (int i = 0; i < messages.length; i++) {  
    Message message = messages[i];  
    System.out.println("---------------------------------");  
    System.out.println("Email Number " + (i + 1));  
    System.out.println("Subject: " + message.getSubject());  
    System.out.println("From: " + message.getFrom()[0]);  
    System.out.println("Text: " + message.getContent().toString());  
   }  
  
   //5) close the store and folder objects  
   emailFolder.close(false);  
   emailStore.close();  
  
  } catch (NoSuchProviderException e) {e.printStackTrace();}   
  catch (MessagingException e) {e.printStackTrace();}  
  catch (IOException e) {e.printStackTrace();}  
 }  
  
 public static void main(String[] args) {  
  
  String host = "pop.gmail.com";//change accordingly  
  String mailStoreType = "pop3";  
  final String username= "pavanjayam87@gmail.com";  
  final String password= Constants.POP_PASSWORD;//change accordingly  
  System.out.println("Hello Welcome");
  receiveEmail(host, mailStoreType, username, password);  
  
 }  
}  
