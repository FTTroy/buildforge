package com.training.buildforge.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.training.buildforge.model.Case;

@Repository
public interface CaseRepository extends MongoRepository<Case, String>{
	
	@Query("{'brand' : ?0}")
	public ArrayList<Case> getCaseByBrand(String brand);
	
	@Query("{'brand' : ?0}")
	public Optional<List<Case>> getCaseByMoboSupport(String moboSupport);

}
