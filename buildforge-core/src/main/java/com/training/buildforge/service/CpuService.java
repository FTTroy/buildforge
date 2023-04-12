package com.training.buildforge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.buildforge.model.Cpu;
import com.training.buildforge.repository.CpuRepository;

@Service
public class CpuService {
	
	@Autowired
	private CpuRepository repository;

	private Logger log = LoggerFactory.getLogger(Cpu.class);

	public Cpu saveCpu(Cpu cpu) {
		return repository.save(cpu);
	}

	public Cpu updateCpu(Cpu cpu) {
		Optional<Cpu> cpuOpt = repository.findById(cpu.getId());
		if (!cpuOpt.isPresent()) {
			log.warn("Cpu not found");
			throw new RuntimeException("id not found");
		}
		Cpu cpuDb = cpuOpt.get();
		BeanUtils.copyProperties(cpu, cpuDb);
		return repository.save(cpuDb);
	}

	public Optional<Cpu> getCpuById(String id) {
		Optional<Cpu> cpuOpt = repository.findById(id);
		if (cpuOpt.isPresent()) {
			log.info("Getting Cpu with id: " + id);
			return cpuOpt;
		} else {
			log.info("Cannot find Cpu!");
			throw new RuntimeException("Cpu Not Found");
		}
	}

	public ArrayList<Cpu> getCpuByBrand(String brand) {
		return repository.getCpuByBrand(brand);
	}
	
	public Optional<List<Cpu>> findCpuBySocket(String socket){
		 return repository.getCpuBySocket(socket);
		
	}
	
	public List<Cpu> getAllCpu() {
		return repository.findAll();
	}

	public Boolean deleteCpu(String id) {
		Optional<Cpu> cpuOpt = repository.findById(id);
		if (cpuOpt.isPresent()) {
			Cpu cpuDb = cpuOpt.get();
			log.info("Cpu with id: " + id + " successfully deleted!");
			repository.delete(cpuDb);

			return true;
		}
		log.info("Cannot delete Cpu!");
		return false;
	}


}
