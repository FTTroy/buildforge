	package com.training.buildforge.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.training.buildforge.model.Gpu;

public interface GpuRepository extends MongoRepository<Gpu,String> {

	@Query("{'brand' : ?0}")
	public ArrayList<Gpu> getGraphicCardByBrand(String brand);
}
