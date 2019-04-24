package com.example.demo.samples;
//package com.example.demo;
//
//import com.sun.mail.pop3.POP3SSLStore;
//import java.io.IOException;
//import java.security.Security;
//import java.util.ArrayList;
//import java.util.Properties;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.mail.Address;
//import javax.mail.BodyPart;
//import javax.mail.FetchProfile;
//import javax.mail.Folder;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Multipart;
//import javax.mail.Part;
//import javax.mail.Session;
//import javax.mail.Store;
//import javax.mail.URLName;
//import javax.swing.JOptionPane;
//import mailtest.config.ConfigurationData;
//import mailtest.customgui.GUILogger;
//
///**
//*
//* @author Mohamed.Sami
//*/
//public class MailControl {
//
//    private ConfigurationData configurationData = new ConfigurationData();
//    private GUILogger gUILogger = GUILogger.getInstance();
//    private Session session;
//    private Store store;
//    private Folder folder;
//    private Message[] messages;
//    private FetchProfile fetchProfile;
//    private Properties properties;
//    private String username;
//    private String password;
//    
////    mail.pop3.socketFactory.class=javax.net.ssl.SSLSocketFactory
////	mail.pop3.socketFactory.fallback=false
////	mail.pop3.port=995
////	mail.pop3.socketFactory.port=995
////	mail.pop3.host=pop.gmail.com
////	mail.pop3.ssl=true
////	port=995
////	protocal=pop3
////	host=pop.gmail.com
//
//    public MailControl() {
//        init();
//    }
//
//    public final void init() {
//
//        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//        properties = configurationData.getProperties();
//
//        if (properties != null) {
//
//            session = Session.getInstance(properties, null);
//            int port = Integer.parseInt(properties.getProperty("port"));
//            URLName urln = new URLName(properties.getProperty("protocal"), properties.getProperty("host"), port, null, username, password);
//            gUILogger.logInfo("Started connecting to mail inbox ... ");
//            store = new POP3SSLStore(session, urln);
//
//
//        } else {
//            JOptionPane.showMessageDialog(null,
//                    " No properties loaded- Mail Connector Failed .",
//                    "Mail client Error", JOptionPane.ERROR_MESSAGE);
//            gUILogger.logInfo("No properties loaded- Mail Connector Failed");
//        }
//
//
//
//    }
//
//    public Message[] readAllMessages() {
//
//        if (properties == null) {
//            gUILogger.logInfo("No properties loaded- Mail Connector Failed");
//            return null;
//        }
//        try {
//            store.connect(properties.getProperty("host"), username, password);
//        } catch (MessagingException ex) {
//            JOptionPane.showMessageDialog(null,
//                    " couldn't connect to mail server ,please make sure you entered to right(username,password). Or make sure of your mail client connect configuration under props/config.properties file.",
//                    "Mail client Error", JOptionPane.ERROR_MESSAGE);
//            gUILogger.logInfo("Mail Connector Failed -" + ex);
//
//        }
//        try {
//
//            folder = store.getDefaultFolder();
//            folder = folder.getFolder("INBOX");
//            folder.open(Folder.READ_ONLY);
//            gUILogger.logInfo("Message Count Found " + folder.getMessageCount());
//            gUILogger.logInfo("New Message Count " + folder.getNewMessageCount());
//            gUILogger.logInfo("=========================================");
//            Message[] newmessages = folder.getMessages();
//            FetchProfile fp = new FetchProfile();
//            fp.add(FetchProfile.Item.ENVELOPE);
//            folder.fetch(newmessages, fp);
//            messages = newmessages;
//            return messages;
//        } catch (MessagingException ex) {
//            JOptionPane.showMessageDialog(null,
//                    "Reading the messages INBOX failed -" + ex,
//                    "Mail client Error", JOptionPane.ERROR_MESSAGE);
//            gUILogger.logInfo("Reading the messages INBOX failed -" + ex);
//        }
//
//
//
//        return messages;
//
//    }
//
//    public void refresh() {
//        readAllMessages();
//    }
//
//    public ConfigurationData getConfigurationData() {
//        return configurationData;
//    }
//
//    public void setConfigurationData(ConfigurationData configurationData) {
//        this.configurationData = configurationData;
//    }
//
//    public FetchProfile getFetchProfile() {
//        return fetchProfile;
//    }
//
//    public void setFetchProfile(FetchProfile fetchProfile) {
//        this.fetchProfile = fetchProfile;
//    }
//
//    public Folder getFolder() {
//        return folder;
//    }
//
//    public void setFolder(Folder folder) {
//        this.folder = folder;
//    }
//
//    public GUILogger getgUILogger() {
//        return gUILogger;
//    }
//
//    public void setgUILogger(GUILogger gUILogger) {
//        this.gUILogger = gUILogger;
//    }
//
//    public Message[] getMessages() {
//        return messages;
//    }
//
//    public void setMessages(Message[] messages) {
//        this.messages = messages;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Properties getProperties() {
//        return properties;
//    }
//
//    public void setProperties(Properties properties) {
//        this.properties = properties;
//    }
//
//    public Session getSession() {
//        return session;
//    }
//
//    public void setSession(Session session) {
//        this.session = session;
//    }
//
//    public Store getStore() {
//        return store;
//    }
//
//    public void setStore(Store store) {
//        this.store = store;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    @Override
//    public void finalize() {
//        try {
//            try {
//                folder.close(true);
//                store.close();
//            } catch (MessagingException ex) {
//                ex.printStackTrace();
//            }
//            super.finalize();
//        } catch (Throwable ex) {
//            Logger.getLogger(MailControl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public ArrayList<String> transform(Message[] messages) {
//
//        if (messages == null || messages.length == 0) {
//            gUILogger.logInfo("No messages found to transform");
//            return null;
//        }
//
//        ArrayList<String> arrayList = new ArrayList<String>();
//        String string = null;
//        for (int i = 0; i < messages.length;
//                i++) {
//
//            try {
//
//
//                Address[] addressList = messages[i].getFrom();
//                for (int j = 0; j < addressList.length; j++) {
//                    System.out.println("From address #" + j + " : " + addressList[j].toString());
//                }
//                System.out.println("Receive date :" + messages[i].getSentDate());
//                if (messages[i].isMimeType("text/plain")) {
//
//                    string = messages[i].getContent().toString();
//
//
//                } else {
//                    string = handleMultipart(messages[i]);
//
//
//                }
//                if (string != null) {
//                    arrayList.add(string);
//                    string = null;
//                }
//
//            } catch (MessagingException ex) {
//                JOptionPane.showMessageDialog(null,
//                        "Messages transformation failed :" + ex,
//                        "Mail client Error", JOptionPane.ERROR_MESSAGE);
//                gUILogger.logInfo("Messages transformation failed :" + ex);
//            } catch (IOException ex) {
//                JOptionPane.showMessageDialog(null,
//                        "Messages I/O transformation failed :" + ex,
//                        "Mail client Error", JOptionPane.ERROR_MESSAGE);
//                gUILogger.logInfo("Messages I/O transformation failed : " + ex);
//            }
//
//
//        }
//        return arrayList;
//    }
//
//    public String handleMultipart(Message msg) {
//
//        String content = null;
//        try {
//            String disposition;
//            BodyPart part;
//            Multipart mp = (Multipart) msg.getContent();
//
//            int mpCount = mp.getCount();
//            for (int m = 0; m < mpCount; m++) {
//                part = mp.getBodyPart(m);
//             
//                disposition = part.getDisposition();
//                if (disposition != null && disposition.equals(Part.INLINE)) {
//                    content = part.getContent().toString();
//                } else {
//                    content = part.getContent().toString();
//
//                }
//            }
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null,
//                    "Messages - Parts - Input/output transformation failed :" + ex,
//                    "Mail client Error", JOptionPane.ERROR_MESSAGE);
//            gUILogger.logInfo("Messages - Parts - Input/output transformation failed :" + ex);
//        } catch (MessagingException ex) {
//            JOptionPane.showMessageDialog(null,
//                    "Messages - Parts - transformation failed :" + ex,
//                    "Mail client Error", JOptionPane.ERROR_MESSAGE);
//            gUILogger.logInfo("Messages - Parts - transformation failed :" + ex);
//        }
//        return content;
//    }
//}
