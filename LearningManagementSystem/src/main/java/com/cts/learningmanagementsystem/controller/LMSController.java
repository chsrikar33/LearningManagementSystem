package com.cts.learningmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.learningmanagementsystem.entity.CourseEntity;
import com.cts.learningmanagementsystem.model.CourseModel;
import com.cts.learningmanagementsystem.model.LMSModel;
import com.cts.learningmanagementsystem.response.CourseListResponse;
import com.cts.learningmanagementsystem.service.LMSService;
import com.cts.learningmanagementsystem.service.LMSServiceImpl;
@CrossOrigin("*")
@RestController
public class LMSController {

	@Autowired
	LMSService lmsService;
	@Autowired
	LMSServiceImpl lmsServiceImpl;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/api/v1.0/lms/company/register")
	public String register(@RequestBody LMSModel lmsModel) {
		lmsModel.setPassword(passwordEncoder.encode(lmsModel.getPassword()));
		lmsModel.setUserRole("ROLE_USER");
		lmsService.register(lmsModel);
		return"registered";

	}
	
//	@PostMapping("/login1")
//	public void login(@PathVariable String userName,@PathVariable String password) {
//		System.out.println("In Login");
//		lmsServiceImpl.loadUserByUsername(userName);
//
//	}

	@PostMapping("/admin/api/v1.0/lms/courses/add")
	public void addACourse(@RequestBody CourseModel courseModel) {
		lmsService.add(courseModel);

	}

	@GetMapping("/admin/api/v1.0/lms/courses/search/{courseName}")
	public CourseEntity getCourseDetails(@PathVariable String courseName) {
		return lmsService.getCourseDetails(courseName);
	}

	@GetMapping("/admin/api/v1.0/lms/courses/getall")
	public ResponseEntity<?> getAllDetails() {
		CourseListResponse courseListresponse=new CourseListResponse();
		courseListresponse.setCourseList(lmsService.getAllCourseDetails()); 
		return new ResponseEntity<>(courseListresponse, HttpStatus.OK);
	}

	@DeleteMapping("/admin/api/v1.0/lms/courses/delete/{courseName}")
	public String deleteCourse(@PathVariable String courseName) {

		return lmsService.deleteCourse(courseName);
	}
	
	@GetMapping("/user/api/v1.0/lms/courses/searchByTechnology/{technology}")
	public List<CourseEntity> getTechnologyDetails(@PathVariable String technology) {
		return lmsService.getTechnologyDetails(technology);
	}
	
	@GetMapping("/user/api/v1.0/lms/courses/get/{technology}/{durationFromRange}/{durationToRange}")
	public List<CourseEntity> getDurationByTechnology(@PathVariable String technology, @PathVariable long durationFromRange,@PathVariable long durationToRange) {
		return lmsService.getDurationByTechnology(technology,durationFromRange,durationToRange);
	}
	
	@GetMapping("/welcome")
	public void welcome() {
		System.out.println("Logged In");

	}

	@GetMapping("/user/welcome")
	public void userWelcome() {
		System.out.println("HaiUser");

	}

}
