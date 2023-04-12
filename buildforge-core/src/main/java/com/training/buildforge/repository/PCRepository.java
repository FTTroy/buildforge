package com.training.buildforge.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.training.buildforge.model.PC;
@Repository
public interface PCRepository extends MongoRepository<PC, String> {

}
