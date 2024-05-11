package com.cts.learningmanagementsystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CourseEntity {
	
	@Id
	private String courseName;
	private String courseDescription;
	private long courseDuration;
	private String technology;
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public long getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(long courseDuration) {
		this.courseDuration = courseDuration;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public CourseEntity(String courseName, String courseDescription, long courseDuration, String technology) {
		super();
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.courseDuration = courseDuration;
		this.technology = technology;
	}
	public CourseEntity() {
		super();
	}
	
	
	
	
	

}
