package com.cts.learningmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.learningmanagementsystem.entity.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,String> {

	public List<CourseEntity> findByTechnology(String technology);
	
	@Query("Select c from CourseEntity c where c.courseDuration between :durationFromRange and :durationToRange and c.technology=:technology")
	public List<CourseEntity> getByTechnolgyDuration(String technology,long durationFromRange,long durationToRange);
}
