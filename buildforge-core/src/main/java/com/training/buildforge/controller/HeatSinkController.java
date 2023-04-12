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

import com.training.buildforge.model.HeatSink;
import com.training.buildforge.service.HeatSinkService;

@RestController
@RequestMapping("heatsink-controller")
public class HeatSinkController {
	
	@Autowired
	private HeatSinkService service;
	
	@PostMapping("/save-heatsink")
	public HeatSink saveHeatSink(@RequestBody HeatSink psu) {
		return service.saveHeatSink(psu);
	}
	
	@PutMapping("/update-heatsink")
	public HeatSink updateHeatSink(@RequestBody HeatSink psu) {
		return service.updateHeatSink(psu);
	}
	
	@GetMapping("/get-heatsink-by-id/{id}")
	public Optional<HeatSink> getHeatSinkById(@PathVariable("id") String id) {
		return service.getHeatSinkById(id);
	}
	
	@GetMapping("/get-heatsink-by-brand/{brand}")
	public ArrayList<HeatSink> getHeatSinkByBrand(@PathVariable("brand") String brand) {
		return service.getHeatSinkByBrand(brand);
	}
	
	@GetMapping("/get-all-heatsink")
	public List<HeatSink> getAllHeatSink() {
		return service.getAllHeatSink();
	}
	
	@DeleteMapping("/delete-heatsink")
	public Boolean deleteHeatSink(@RequestParam String id) {
		return service.deleteHeatSink(id);
	}


}
