package com.example.demo.samples;

import java.util.Date;

import javax.mail.Address;
import javax.mail.Message;

public class Mail {

	private Address email;
	private Address[] email2;
	private String subject;
	private Message message;
	private Object content;
	private Date date;

	public Address getEmail() {
		return email;
	}

	public void setEmail(Address address) {
		this.email = address;
	}

	public Address[] getEmail2() {
		return email2;
	}

	public void setEmail2(Address[] addresses) {
		this.email2 = addresses;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message messages) {
		this.message = messages;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object object) {
		this.content = object;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
