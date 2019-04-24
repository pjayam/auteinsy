package com.example.demo.repository;

import org.springframework.data.repository.Repository;

import com.example.demo.bean.InterviewInfo;

public interface InterviewInfoRepository extends Repository<InterviewInfo, Long> {
	InterviewInfo findById(long id);

	InterviewInfo save(InterviewInfo user);

}
