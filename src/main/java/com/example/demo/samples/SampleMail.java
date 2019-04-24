package com.example.demo.samples;

import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.Properties;

import javax.mail.FetchProfile;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.mail.internet.MimeUtility;

public class SampleMail {

	private static final String username = "pavanjayam87@gmail.com";
	private static final String password = "India@7887";

	// public static void main(String[] args) {
	// Properties props = System.getProperties();
	// props.setProperty("mail.store.protocol", "imaps");
	// try {
	// Session session = Session.getDefaultInstance(props, null);
	// Store store = session.getStore("imaps");
	// store.connect("imap.gmail.com", "pavanjayam87@gmail.com", "India@7887");
	// Folder inbox = store.getFolder("inbox");
	// inbox.open(Folder.READ_ONLY);
	// int messageCount = inbox.getMessageCount();
	// System.out.println(messageCount);
	// } catch (NoSuchProviderException e) {
	// e.printStackTrace();
	// System.exit(1);
	// } catch (MessagingException e) {
	// e.printStackTrace();
	// System.exit(2);
	// }
	// }

	// public static void main(String[] args) throws MessagingException {
	//
	// String host = "imap.gmail.com";
	// String username = "pavanjayam87@gmail.com";
	// String password = "India@7887";
	// Properties props = new Properties();
	// props.setProperty("mail.imap.ssl.enable", "true");
	// // set any other needed mail.imap.* properties here
	// Session session = Session.getInstance(props);
	// Store store = session.getStore("imaps");
	// store.connect(host, username, password);
	//
	// }

	// public static void main(String[] args) throws MessagingException {

	// Properties props = System.getProperties();
	// props.setProperty("mail.store.protocol", "imaps");
	// try {
	// Session session = Session.getDefaultInstance(props, null);
	// Store store = session.getStore("imaps");
	// store.connect("imap.gmail.com", username, password);
	// System.out.println("Connected");
	// } catch (NoSuchProviderException e) {
	// e.printStackTrace();
	// System.exit(1);
	// } catch (MessagingException e) {
	// e.printStackTrace();
	// System.exit(2);
	// }

	// Properties props = System.getProperties();
	// props.setProperty("mail.store.protocol", "imaps");
	// props.setProperty("mail.imaps.host", "imap.gmail.com");
	// props.setProperty("mail.imaps.port", "993");
	// props.setProperty("mail.imaps.connectiontimeout", "5000");
	// props.setProperty("mail.imaps.timeout", "5000");
	// props.setProperty("mail.imap.socketFactory.class",
	// "javax.net.ssl.SSLSocketFactory");
	// props.setProperty("mail.imap.socketFactory.fallback", "false");
	//
	//
	// props.setProperty("http.proxySet", "true");
	// props.setProperty("http.proxyHost", proxyHost);
	// props.setProperty("http.proxyPort", proxyPort);
	// props.setProperty("mail.imap.port", "993");
	// props.setProperty("mail.store.protocol", "imaps");
	//
	//
	//
	// try {
	// Session session = Session.getDefaultInstance(props, null);
	// Store store = session.getStore("imaps");
	// store.connect("imap.gmail.com", username,password);
	// System.out.println("DONE");
	// } catch (NoSuchProviderException e) {
	// e.printStackTrace();
	// System.exit(1);
	// } catch (MessagingException e) {
	// e.printStackTrace();
	// System.exit(2);
	// }
	//
	// String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	// Properties pop3Props = new Properties();
	// pop3Props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
	// pop3Props.setProperty("mail.pop3.socketFactory.fallback", "false");
	// pop3Props.setProperty("mail.pop3.port", "995");
	// pop3Props.setProperty("mail.pop3.socketFactory.port", "995");
	// URLName url; url = new URLName("pop3", "pop.gmail.com", 995, "", username,
	// password);
	// Session session = Session.getInstance(pop3Props, null);
	// POP3SSLStore store = new POP3SSLStore(session, url);
	// store.connect();
	//
	// // Get default folder
	// Folder folder = store.getDefaultFolder();
	//
	// // Get any folder by name
	// Folder[] folderList = folder.list();

	// Properties props = new Properties();
	// props.setProperty("http.proxySet", "true");
	// props.setProperty("http.proxyHost", proxyHost);
	// props.setProperty("http.proxyPort", proxyPort);
	// props.setProperty("mail.imap.port", "993");
	// props.setProperty("mail.store.protocol", "imaps");
	// Session session = Session.getInstance(props, null);
	// Store store = session.getStore("imaps");
	// store.connect("imap.gmail.com", email, pass);
	// Folder inbox = store.getFolder("INBOX");
	// inbox.open(Folder.READ_ONLY);

	// }

//	public static void main(String argv[]) throws Exception {
//
//		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
//
//		// Get a Properties object
//		Properties props = System.getProperties();
//		props.setProperty("proxySet", "true");
//		props.setProperty("socksProxyHost", "192.168.155.1");//172.17.171.153
//		props.setProperty("socksProxyPort", "1080");
//
//		props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
//		props.setProperty("mail.pop3.socketFactory.fallback", "false");
//		props.setProperty("mail.pop3.port", "995");
//		props.setProperty("mail.pop3.socketFactory.port", "995");
//
//		Session session = Session.getDefaultInstance(props, null);
//
//		URLName urln = new URLName("pop3", "pop.gmail.com", 995, null, username, password);
//		Store store = session.getStore(urln);
//		Folder inbox = null;
//		try {
//			store.connect();
//			inbox = store.getFolder("INBOX");
//			inbox.open(Folder.READ_ONLY);
//			FetchProfile profile = new FetchProfile();
//			profile.add(FetchProfile.Item.ENVELOPE);
//			Message[] messages = inbox.getMessages();
//			inbox.fetch(messages, profile);
//			System.out.println("Inbox Number of Message" + messages.length);
//
//		}
//
//		finally {
//
//			try {
//
//				inbox.close(false);
//
//			}
//
//			catch (Exception e) {
//
//			}
//
//			try {
//
//				store.close();
//
//			}
//
//			catch (Exception e) {
//
//			}
//
//		}
//
//	}
//
//	protected static String decodeText(String text)
//
//			throws UnsupportedEncodingException {
//
//		if (text == null)
//
//			return null;
//
//		if (text.startsWith("=?GB") || text.startsWith("=?gb"))
//
//			text = MimeUtility.decodeText(text);
//
//		else
//
//			text = new String(text.getBytes("ISO8859_1"));
//
//		return text;
//
//	}

}
