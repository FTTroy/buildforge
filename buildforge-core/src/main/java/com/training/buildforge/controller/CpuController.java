package com.training.buildforge.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.buildforge.model.Cpu;
import com.training.buildforge.service.CpuService;

@RestController
@RequestMapping("/cpu-controller")
public class CpuController {
	
	@Autowired
	private CpuService service;
	
	@PostMapping("/save-cpu")
	public Cpu saveCpu(@RequestBody Cpu cpu) {
		return service.saveCpu(cpu);
	}
	
	@PutMapping("/update-cpu")
	public Cpu updateCpu(@RequestBody Cpu cpu) {
		return service.updateCpu(cpu);
	}
	
	@GetMapping("/get-cpu-by-id/{id}")
	public Optional<Cpu> getCpuById(@PathVariable("id") String id) {
		return service.getCpuById(id);
	}
	
	@GetMapping("/get-cpu-by-brand/{brand}")
	public ArrayList<Cpu> getCpuByBrand(@PathVariable("brand") String brand) {
		return service.getCpuByBrand(brand);
	}
	
	@GetMapping("/get-all-cpu")
	public List<Cpu> getAllCpu() {
		return service.getAllCpu();
	}
	
	@DeleteMapping("/delete-ram")
	public Boolean deleteCpu(@RequestParam String id) {
		return service.deleteCpu(id);
	}

}
