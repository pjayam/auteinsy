package com.example.demo.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Interview_Info")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class InterviewInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "ph_no")
	private String phNo;

	@Column(name = "name")
	private String name;

	@Column(name = "subject")
	private String subject;

	@Column(name = "interview_id")
	private Long interviewId;

	@Column(name = "score")
	private Long score;

	@Column(name = "reply_mail_id")
	private String replyMailId;

	@Column(name = "interview_date")
	private Date interviewDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Long getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Long interviewId) {
		this.interviewId = interviewId;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public String getReplyMailId() {
		return replyMailId;
	}

	public void setReplyMailId(String replyMailId) {
		this.replyMailId = replyMailId;
	}

	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

}
