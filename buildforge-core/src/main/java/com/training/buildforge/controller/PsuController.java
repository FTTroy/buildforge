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

import com.training.buildforge.model.Psu;
import com.training.buildforge.service.PsuService;

@RestController
@RequestMapping("/psu-controller")
public class PsuController {
	
	
	@Autowired
	private PsuService service;
	
	@PostMapping("/save-psu")
	public Psu savePsu(@RequestBody Psu psu) {
		return service.savePsu(psu);
	}
	
	@PutMapping("/update-psu")
	public Psu updatePsu(@RequestBody Psu psu) {
		return service.updatePsu(psu);
	}
	
	@GetMapping("/get-psu-by-id/{id}")
	public Optional<Psu> getPsuById(@PathVariable("id") String id) {
		return service.getPsuById(id);
	}
	
	@GetMapping("/get-psu-by-brand/{brand}")
	public ArrayList<Psu> getPsuByBrand(@PathVariable("brand") String brand) {
		return service.getPsuByBrand(brand);
	}
	
	@GetMapping("/get-all-psu")
	public List<Psu> getAllPsu() {
		return service.getAllPsu();
	}
	
	@DeleteMapping("/delete-psu")
	public Boolean deletePsu(@RequestParam String id) {
		return service.deletePsu(id);
	}


}
