package com.cts.learningmanagementsystem.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.cts.learningmanagementsystem.entity.CourseEntity;
import com.cts.learningmanagementsystem.entity.LMSEntity;
import com.cts.learningmanagementsystem.model.CourseModel;
import com.cts.learningmanagementsystem.model.LMSModel;
import com.cts.learningmanagementsystem.repository.CourseRepository;
import com.cts.learningmanagementsystem.repository.LMSRepository;

@Service
public class LMSServiceImpl implements LMSService,UserDetailsService {
	
	@Autowired
	LMSRepository lmsRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String userEmailId)  {
		System.out.println("In loadUserName"+userEmailId);
		LMSEntity userCredentials = lmsRepository.findByUserEmailId(userEmailId);
		String email = userCredentials.getUserEmailId();
		String password = userCredentials.getPassword();
		return new User(email, password,getAuthorities(userCredentials.getUserRole()));
		
		
	}
	public Collection<GrantedAuthority> getAuthorities(String role) {
		SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(role);
		return List.of(simpleGrantedAuthority);
	}
	@Override
	public void register(LMSModel lmsModel) {
		
		LMSEntity lmsEntity = modelMapper.map(lmsModel, LMSEntity.class);
		lmsRepository.save(lmsEntity);
	}
	@Override
	public void add(CourseModel courseModel) {
		CourseEntity courseEntity = modelMapper.map(courseModel, CourseEntity.class);
		courseRepository.save(courseEntity);
		
	}

	
	@Override
	public String deleteCourse(String courseName) {
		Optional<CourseEntity> courseNameDetails=courseRepository.findById(courseName);
		if(!courseNameDetails.isEmpty()) {
			courseRepository.deleteById(courseName);
			return "Deleted";
		}
		else			
		return null;
	}
	
	@Override
	public List<CourseEntity> getAllCourseDetails() {
		return courseRepository.findAll();
	}
	@Override
	public CourseEntity getCourseDetails(String courseName) {
		Optional<CourseEntity> courseNameDetails=courseRepository.findById(courseName);
		if(!courseNameDetails.isEmpty()) {
			return courseNameDetails.get();
		}
		else			
		return null;
	}
	@Override
	public List<CourseEntity> getTechnologyDetails(String technology) {
		return courseRepository.findByTechnology(technology);
	}
	@Override
	public List<CourseEntity> getDurationByTechnology(String technology, long durationFromRange, long durationToRange) {
		
		return courseRepository.getByTechnolgyDuration(technology,durationFromRange,durationToRange);
	}

}
