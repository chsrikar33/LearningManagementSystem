package com.cts.learningmanagementsystem.service;

import java.util.List;

import com.cts.learningmanagementsystem.entity.CourseEntity;
import com.cts.learningmanagementsystem.model.CourseModel;
import com.cts.learningmanagementsystem.model.LMSModel;

public interface LMSService {

	public void register(LMSModel lmsModel);

	public void add(CourseModel courseModel);

	public List<CourseEntity> getAllCourseDetails();

	public String deleteCourse(String courseName);

	public CourseEntity getCourseDetails(String courseName);

	public List<CourseEntity> getTechnologyDetails(String technology);

	public List<CourseEntity> getDurationByTechnology(String technology, long durationFromRange, long durationToRange);

}
