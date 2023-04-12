package com.training.buildforge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.buildforge.model.Gpu;
import com.training.buildforge.repository.GpuRepository;

@Service
public class GpuService {

	private Logger log = LoggerFactory.getLogger(Gpu.class);

	@Autowired
	private GpuRepository repository;

	public Gpu saveGpu(Gpu gpu) {
		return repository.save(gpu);
	}

	public Gpu updateGpu(Gpu gpu) {
		log.info("updating Gpu with id: " + gpu.getId());
		Optional<Gpu> gpuOpt = repository.findById(gpu.getId());
		if (!gpuOpt.isPresent()) {
			log.warn("Gpu not found");
			throw new RuntimeException("id not found");
		}
		Gpu gpuDb = gpuOpt.get();
		BeanUtils.copyProperties(gpu, gpuDb);
		return repository.save(gpuDb);
	}

	public Optional<Gpu> getGpuById(String id) {
		Optional<Gpu> gpuOpt = repository.findById(id);
		if (gpuOpt.isPresent()) {
			log.info("Getting Gpu with id: " + id);
			return gpuOpt;
		} else {
			log.info("Cannot find Gpu!");
			throw new RuntimeException("Gpu Not Found");
		}
	}

	public ArrayList<Gpu> getGpuByBrand(String brand) {
		return repository.getGraphicCardByBrand(brand);
	}

	public List<Gpu> getAllGpu() {
		return repository.findAll();
	}

	public Boolean deleteGpu(String id) {
		Optional<Gpu> gpuOpt = repository.findById(id);
		if (gpuOpt.isPresent()) {
			Gpu gpuDb = gpuOpt.get();
			log.info("Gpu with id: " + id + " successfully deleted!");
			repository.delete(gpuDb);

			return true;
		}
		log.info("Cannot delete Gpu!");
		return false;
	}

}
