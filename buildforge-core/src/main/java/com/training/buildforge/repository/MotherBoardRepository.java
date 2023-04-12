package com.training.buildforge.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.training.buildforge.model.MotherBoard;

@Repository
public interface MotherBoardRepository  extends MongoRepository<MotherBoard, String>{

	@Query("{'brand' : ?0}")
	public ArrayList<MotherBoard> getMotherBoardByBrand(String brand);
}
