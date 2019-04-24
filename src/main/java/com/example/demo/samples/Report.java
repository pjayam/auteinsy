package com.example.demo.samples;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.Properties;

import javax.mail.Message;

import javax.mail.MessagingException;

import javax.mail.PasswordAuthentication;

import javax.mail.Session;

import javax.mail.Transport;

import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;

import com.example.demo.utils.Constants;

public class Report {

	public static void main(String[] args) {
		sendMail();
	}

	public static void sendMail() {

		// Setting up configurations for the email connection to the Google SMTP server
		// using TLS

		Properties props = new Properties();

		props.setProperty("mail.smtp.host", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.port", "587");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.ssl.enable", "true");
		props.setProperty("mail.smtp.timeout", "10000");
		props.setProperty("mail.smtp.connectiontimeout", "10000");

		// Establishing a session with required user details

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("pavanjayam87@gmail.com", Constants.POP_PASSWORD);

			}

		});

		try {

			// Creating a Message object to set the email content

			MimeMessage msg = new MimeMessage(session);

			// Storing the comma seperated values to email addresses

			String to = "pavanjayam87@gmail.com";

			/*
			 * Parsing the String with defualt delimiter as a comma by marking the boolean
			 * as true and storing the email
			 * 
			 * addresses in an array of InternetAddress objects
			 */

			InternetAddress[] address = InternetAddress.parse(to, true);

			// Setting the recepients from the address variable

			msg.setRecipients(Message.RecipientType.TO, address);

			String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());

			msg.setSubject("Sample Mail : " + timeStamp);

			msg.setSentDate(new Date());

			msg.setText("Sampel System Generated mail");

			msg.setHeader("XPriority", "1");

			Transport.send(msg);

			System.out.println("Mail has been sent successfully");

		} catch (MessagingException mex) {

			System.out.println("Unable to send an email" + mex);

		}

	}

}
