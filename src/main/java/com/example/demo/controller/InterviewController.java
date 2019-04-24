package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.InterviewInfo;
import com.example.demo.service.InterviewService;

@RestController
@RequestMapping(value="/interview/")
public class InterviewController {
	
	@Autowired
    InterviewService interviewService;
	
	@GetMapping(value="getScore")
    public ResponseEntity<String> getStatus(@RequestParam("id") long id){
		
        InterviewInfo int_info = interviewService.findById(id);
        if (int_info==null) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<String>("Score : "+int_info.getScore(),HttpStatus.OK);
        
    }
	
	@PutMapping(value="updateScore")
    public ResponseEntity<String> updateInterivewStatus(@RequestParam("id") long id,@RequestParam("score") Long score){
		
        InterviewInfo int_info = interviewService.findById(id);
        if (int_info==null) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        int_info.setScore(score);
        interviewService.update(int_info);
        return new ResponseEntity<String>(HttpStatus.OK);
        
    }

}
