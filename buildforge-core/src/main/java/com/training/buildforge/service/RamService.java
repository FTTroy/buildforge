package com.training.buildforge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.buildforge.model.Ram;
import com.training.buildforge.repository.RamRepository;

@Service
public class RamService {

	@Autowired
	private RamRepository repository;

	private Logger log = LoggerFactory.getLogger(Ram.class);

	public Ram saveRam(Ram ram) {
		return repository.save(ram);
	}

	public Ram updateRam(Ram ram) {
		log.info("updating Ram with id: " + ram.getId());
		Optional<Ram> ramOpt = repository.findById(ram.getId());
		if (!ramOpt.isPresent()) {
			log.warn("Ram not found");
			throw new RuntimeException("id not found");
		}
		Ram ramDb = ramOpt.get();
		BeanUtils.copyProperties(ram, ramDb);
		return repository.save(ramDb);
	}

	public Optional<Ram> getRamById(String id) {
		Optional<Ram> ramOpt = repository.findById(id);
		if (ramOpt.isPresent()) {
			log.info("Getting Ram with id: " + id);
			return ramOpt;
		} else {
			log.info("Cannot find Ram!");
			throw new RuntimeException("Ram Not Found");
		}
	}

	public ArrayList<Ram> getRamByBrand(String brand) {
		return repository.getRamByBrand(brand);
	}
	
	public List<Ram> getAllRam() {
		return repository.findAll();
	}

	public Boolean deleteRam(String id) {
		Optional<Ram> ramOpt = repository.findById(id);
		if (ramOpt.isPresent()) {
			Ram ramDb = ramOpt.get();
			log.info("Ram with id: " + id + " successfully deleted!");
			repository.delete(ramDb);

			return true;
		}
		log.info("Cannot delete Ram!");
		return false;
	}

}
