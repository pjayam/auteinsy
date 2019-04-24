package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.InterviewInfo;
import com.example.demo.repository.InterviewInfoRepository;

@Service
@Transactional
public class InterviewServiceImpl implements InterviewService {
	
	@Autowired
	InterviewInfoRepository interviewInfoRepository;

	@Override
	public InterviewInfo findById(long interview_Id) {
		return interviewInfoRepository.findById(interview_Id);
	}
	
	public InterviewInfo update(InterviewInfo user) {
        return interviewInfoRepository.save(user);
    }

}
