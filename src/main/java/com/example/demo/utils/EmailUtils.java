package com.example.demo.utils;

import java.util.List;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.bean.InterviewInfo;

@Component
public class EmailUtils {

	private static final Logger log = LoggerFactory.getLogger(EmailUtils.class);

	public Store connectToMailStore(Properties properties, String host, String hostType) {
		Store store = null;
		try {
			Session emailSession = Session.getDefaultInstance(properties);
			store = emailSession.getStore(host);
			store.connect(hostType, Constants.POP_USER, Constants.POP_PASSWORD);
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return store;
	}

	public List<InterviewInfo> readMailsAndCreateInterviewInfo() {
		List<InterviewInfo> interviewList = null;
		try {
			Properties properties = new Properties();
			properties.put("mail.pop3.host", Constants.POP_HOST_ADDRESS);
			properties.put("mail.pop3.port", Constants.POP_PORT);
			properties.put("mail.pop3.starttls.enable", "true");
			properties.put("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			properties.put("mail.pop3.auth", true);
			properties.put("mail.pop3.password", Constants.POP_PASSWORD);
			properties.put("mail.pop3.user", Constants.POP_USER);
			properties.put("mail.store.protocol", Constants.POP3_MAIL_STORE_TYPE);
			properties.put("mail.pop3.socketFactory.port", Constants.POP_PORT);

			Store store = connectToMailStore(properties, Constants.POP_HOST_ADDRESS, Constants.POP3_MAIL_STORE_TYPE);
			Folder folder = store.getDefaultFolder();

			log.info("Has new Messages in " + folder.getName() + " : " + folder.hasNewMessages());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return interviewList;
	}

}
