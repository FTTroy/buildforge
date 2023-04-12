package com.training.buildforge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.buildforge.model.Psu;
import com.training.buildforge.repository.PsuRepository;

@Service
public class PsuService {
	
	@Autowired
	private PsuRepository repository;
	
	private Logger log = LoggerFactory.getLogger(Psu.class);

	public Psu savePsu(Psu psu) {
		return repository.save(psu);
	}

	public Psu updatePsu(Psu psu) {
		log.info("updating psu with id: " + psu.getId());
		Optional<Psu> psuOpt = repository.findById(psu.getId());
		if (!psuOpt.isPresent()) {
			log.warn("psu not found");
			throw new RuntimeException("id not found");
		}
		Psu psuDb = psuOpt.get();
		BeanUtils.copyProperties(psu, psuDb);
		return repository.save(psuDb);
	}

	public Optional<Psu> getPsuById(String id) {
		Optional<Psu> ramOpt = repository.findById(id);
		if (ramOpt.isPresent()) {
			log.info("Getting Psu with id: " + id);
			return ramOpt;
		} else {
			log.info("Cannot find Psu!");
			throw new RuntimeException("Psu Not Found");
		}
	}

	public ArrayList<Psu> getPsuByBrand(String brand) {
		return repository.getPsuByBrand(brand);
	}
	
	public List<Psu> getAllPsu() {
		return repository.findAll();
	}

	public Boolean deletePsu(String id) {
		Optional<Psu> psuOpt = repository.findById(id);
		if (psuOpt.isPresent()) {
			Psu psuDb = psuOpt.get();
			log.info("psu with id: " + id + " successfully deleted!");
			repository.delete(psuDb);

			return true;
		}
		log.info("Cannot delete psu!");
		return false;
	}
	
	

}
