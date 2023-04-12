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

import com.training.buildforge.model.Gpu;
import com.training.buildforge.service.GpuService;

@RestController
@RequestMapping("/gpu-controller")
public class GpuController {

	@Autowired
	public GpuService service;
	
	@PostMapping("/save-gpu")
	public Gpu saveGpu(@RequestBody Gpu gpu) {
		return service.saveGpu(gpu);
	}
	
	@PutMapping("/update-gpu")
	public Gpu updateGpu(@RequestBody Gpu gpu) {
		return service.updateGpu(gpu);
	}
	
	@GetMapping("/get-gpu-by-id/{id}")
	public Optional<Gpu> getGpuById(@PathVariable("id") String id) {
		return service.getGpuById(id);
	}
	
	@GetMapping("/get-gpu-by-brand/{brand}")
	public ArrayList<Gpu> getGpuByBrand(@PathVariable("brand") String brand) {
		return service.getGpuByBrand(brand);
	}
	
	@GetMapping("/get-all-gpu")
	public List<Gpu> getAllGpu() {
		return service.getAllGpu();
	}
	
	@DeleteMapping("/delete-gpu")
	public Boolean deleteGpu(@RequestParam String id) {
		return service.deleteGpu(id);
	}
}
