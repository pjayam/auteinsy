package com.example.demo.samples;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

public class Email implements ActionListener

{

	private Mail mail;
	private List mails = new ArrayList();
	private String password;
	private String user;

	public Email() throws MessagingException, IOException {
		// EmailTable.Password.password = password;
		String host = "10.13.1.11";
		Properties properties = System.getProperties();
		Session session = Session.getDefaultInstance(properties);
		Store store = session.getStore("pop3");
		System.out.println("Step1");

		store.connect("pop.gmail.com", user, password);
		System.out.println("Step2");

		Folder folder = store.getFolder("inbox");
		folder.open(Folder.READ_ONLY);
		Message[] messages = folder.getMessages();
		System.out.println("Step3");

		int length = messages.length - 1;
		for (int i = length; i > length - 30; i--) {
			// creates new mail
			mail = new Mail();
			// sets from
			mail.setEmail(messages[i].getFrom()[0]);
			// sets to
			mail.setEmail2(messages[i].getRecipients(Message.RecipientType.TO));
			// sets subject
			mail.setSubject(messages[i].getSubject());
			// sets sent date
			mail.setDate(messages[i].getSentDate());
			// sets full message
			mail.setMessage(messages[i]);

			// sets bodyText
			mail.setContent(messages[i].getContent());

			Email.this.mails.add(mail);
		}
		System.out.println("Step4");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("Action Performed");
	}
	
	public static void main(String[] args) throws MessagingException, IOException {
		
		Email email = new Email();
		
	}
}
