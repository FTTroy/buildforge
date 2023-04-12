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

import com.training.buildforge.model.Ram;
import com.training.buildforge.service.RamService;

@RestController
@RequestMapping("/ram-controller")
public class RamController {
	
	@Autowired
	private RamService service;
	
	@PostMapping("/save-ram")
	public Ram saveRam(@RequestBody Ram ram) {
		return service.saveRam(ram);
	}
	
	@PutMapping("/update-ram")
	public Ram updateRam(@RequestBody Ram ram) {
		return service.updateRam(ram);
	}
	
	@GetMapping("/get-ram-by-id/{id}")
	public Optional<Ram> getRamById(@PathVariable("id") String id) {
		return service.getRamById(id);
	}
	
	@GetMapping("/get-ram-by-brand/{brand}")
	public ArrayList<Ram> getRamByBrand(@PathVariable("brand") String brand) {
		return service.getRamByBrand(brand);
	}
	
	@GetMapping("/get-all-ram")
	public List<Ram> getAllRam() {
		return service.getAllRam();
	}
	
	@DeleteMapping("/delete-ram")
	public Boolean deleteRam(@RequestParam String id) {
		return service.deleteRam(id);
	}

}
