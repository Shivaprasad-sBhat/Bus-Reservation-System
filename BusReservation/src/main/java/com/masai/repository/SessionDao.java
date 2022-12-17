package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.CurrentSession;
@Repository
public interface SessionDao extends JpaRepository<CurrentSession, Integer> {

	public CurrentSession findByUuid (String key);
	
	public CurrentSession findByIdAndType(int id , String type);
}
