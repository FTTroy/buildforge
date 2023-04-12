package com.training.buildforge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.buildforge.model.HeatSink;
import com.training.buildforge.repository.HeatSinkRepository;

@Service
public class HeatSinkService {

	@Autowired
	private HeatSinkRepository repository;

	private Logger log = LoggerFactory.getLogger(HeatSink.class);

	public HeatSink saveHeatSink(HeatSink heatSink) {
		return repository.save(heatSink);
	}

	public HeatSink updateHeatSink(HeatSink heatSink) {
		log.info("updating HeatSink with id: " + heatSink.getId());
		Optional<HeatSink> heatSinkOpt = repository.findById(heatSink.getId());
		if (!heatSinkOpt.isPresent()) {
			log.warn("HeatSink not found");
			throw new RuntimeException("id not found");
		}
		HeatSink heatSinkDb = heatSinkOpt.get();
		BeanUtils.copyProperties(heatSink, heatSinkDb);
		return repository.save(heatSinkDb);
	}

	public Optional<HeatSink> getHeatSinkById(String id) {
		Optional<HeatSink> heatSinkOpt = repository.findById(id);
		if (heatSinkOpt.isPresent()) {
			log.info("Getting heatSink with id: " + id);
			return heatSinkOpt;
		} else {
			log.info("Cannot find heatSink!");
			throw new RuntimeException("heatSink Not Found");
		}
	}

	public ArrayList<HeatSink> getHeatSinkByBrand(String brand) {
		return repository.getHeatSinkByBrand(brand);
	}
	
	public List<HeatSink> getAllHeatSink() {
		return repository.findAll();
	}

	public Boolean deleteHeatSink(String id) {
		Optional<HeatSink> heatSinkOpt = repository.findById(id);
		if (heatSinkOpt.isPresent()) {
			HeatSink heatSinkDb = heatSinkOpt.get();
			log.info("HeatSink with id: " + id + " successfully deleted!");
			repository.delete(heatSinkDb);

			return true;
		}
		log.info("Cannot delete HeatSink!");
		return false;
	}

}
