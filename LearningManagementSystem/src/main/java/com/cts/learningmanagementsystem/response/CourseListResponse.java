package com.cts.learningmanagementsystem.response;

import java.util.List;

import com.cts.learningmanagementsystem.entity.CourseEntity;

public class CourseListResponse {
	
	private List<CourseEntity> courseList;

	public List<CourseEntity> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<CourseEntity> courseList) {
		this.courseList = courseList;
	}
	
	

}
