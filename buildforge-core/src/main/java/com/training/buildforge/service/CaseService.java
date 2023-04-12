package com.training.buildforge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.buildforge.model.Case;
import com.training.buildforge.repository.CaseRepository;

@Service
public class CaseService {
	
	@Autowired
	private CaseRepository repository;
	
	private Logger log = LoggerFactory.getLogger(Case.class);

	public Case saveCase(Case PcCase) {
		return repository.save(PcCase);
	}

	public Case updateCase(Case PcCase) {
		log.info("updating Case with id: " + PcCase.getId());
		Optional<Case> caseOpt = repository.findById(PcCase.getId());
		if (!caseOpt.isPresent()) {
			log.warn("Case not found");
			throw new RuntimeException("id not found");
		}
		Case caseDb = caseOpt.get();
		BeanUtils.copyProperties(PcCase, caseDb);
		return repository.save(caseDb);
	}

	public Optional<Case> getCaseById(String id) {
		Optional<Case> caseOpt = repository.findById(id);
		if (caseOpt.isPresent()) {
			log.info("Getting Case with id: " + id);
			return caseOpt;
		} else {
			log.info("Cannot find Case!");
			throw new RuntimeException("Case Not Found");
		}
	}

	public ArrayList<Case> getCaseByBrand(String brand) {
		return repository.getCaseByBrand(brand);
	}
	
	public List<Case> getAllCase() {
		return repository.findAll();
	}
	

	public Boolean deleteCase(String id) {
		Optional<Case> caseOpt = repository.findById(id);
		if (caseOpt.isPresent()) {
			Case caseDb = caseOpt.get();
			log.info("Case with id: " + id + " successfully deleted!");
			repository.delete(caseDb);

			return true;
		}
		log.info("Cannot delete Case!");
		return false;
	}
	
	

}
