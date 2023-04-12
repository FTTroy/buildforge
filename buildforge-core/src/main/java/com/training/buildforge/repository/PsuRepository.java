package com.training.buildforge.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.training.buildforge.model.Psu;

@Repository
public interface PsuRepository extends MongoRepository<Psu, String> {
	
	@Query("{'brand' : ?0}")
	public ArrayList<Psu> getPsuByBrand(String brand);

}
