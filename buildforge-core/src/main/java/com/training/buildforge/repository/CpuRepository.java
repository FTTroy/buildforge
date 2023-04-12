package com.training.buildforge.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.training.buildforge.model.Cpu;

@Repository
public interface CpuRepository extends MongoRepository<Cpu, String> {
	
	@Query("{'brand' : ?0}")
	public ArrayList<Cpu> getCpuByBrand(String brand);
	
	@Query("{'socket' : ?0}")
	public Optional<List<Cpu>> getCpuBySocket(String brand);

}
