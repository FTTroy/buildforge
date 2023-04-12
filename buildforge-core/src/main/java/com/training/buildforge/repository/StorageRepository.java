package com.training.buildforge.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.training.buildforge.model.Storage;

@Repository
public interface StorageRepository extends MongoRepository<Storage, String>{
	
	@Query("{'brand' : ?0}")
	public ArrayList<Storage> getStorageByBrand(String brand);
	
	@Query("{'type' : ?0}")
	public Optional<List<Storage>> getStorageByType(String brand);


}
