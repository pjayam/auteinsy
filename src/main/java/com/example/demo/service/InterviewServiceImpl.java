package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.InterviewInfo;
import com.example.demo.repository.InterviewInfoRepository;
import com.example.demo.utils.EmailUtils;

@Service
@Transactional
public class InterviewServiceImpl implements InterviewService {

	@Autowired
	InterviewInfoRepository interviewInfoRepository;
	
	@Autowired
	EmailUtils emailUtils;

	@Override
	public InterviewInfo findById(long interview_Id) {
		return interviewInfoRepository.findById(interview_Id);
	}

	public InterviewInfo update(InterviewInfo info) {
		return interviewInfoRepository.save(info);
	}

	@Override
	public Boolean readMailAndSave() {
		
		emailUtils.save(int_info);
		return true;
	}
	
	public void sendMail() {
		
	}

}
