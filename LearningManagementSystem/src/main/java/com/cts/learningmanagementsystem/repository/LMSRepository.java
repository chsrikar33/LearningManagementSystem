package com.cts.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cts.learningmanagementsystem.entity.LMSEntity;


@Repository
public interface LMSRepository extends JpaRepository<LMSEntity,String>{
	
	public LMSEntity findByUserEmailId(String userEmailId);

}
