package com.training.buildforge.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.training.buildforge.model.HeatSink;

@Repository
public interface HeatSinkRepository extends MongoRepository<HeatSink, String>{
	
	@Query("{'brand' : ?0}")
	public ArrayList<HeatSink> getHeatSinkByBrand(String brand);
	
	@Query("{'brand' : ?0}")
	public Optional<List<HeatSink>> getHeatSinkBySocket(String socket);

}
