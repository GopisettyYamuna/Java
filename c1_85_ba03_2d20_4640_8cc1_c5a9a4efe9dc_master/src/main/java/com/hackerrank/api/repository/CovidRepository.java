package com.hackerrank.api.repository;

import com.hackerrank.api.model.Covid;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CovidRepository extends JpaRepository<Covid, Long> {
	
  
  
}
