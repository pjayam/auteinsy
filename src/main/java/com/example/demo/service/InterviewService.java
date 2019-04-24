package com.example.demo.service;

import com.example.demo.bean.InterviewInfo;

public interface InterviewService {
	
	public InterviewInfo findById(long id);

	public InterviewInfo update(InterviewInfo int_info);
}
