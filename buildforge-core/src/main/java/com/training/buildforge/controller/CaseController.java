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

import com.training.buildforge.model.Case;
import com.training.buildforge.service.CaseService;

@RestController
@RequestMapping("/case-controller")
public class CaseController {
	
	@Autowired
	private CaseService service;
	
	@PostMapping("/save-case")
	public Case saveCase(@RequestBody Case PcCase) {
		return service.saveCase(PcCase);
	}
	
	@PutMapping("/update-case")
	public Case updateCase(@RequestBody Case PcCase) {
		return service.updateCase(PcCase);
	}
	
	@GetMapping("/get-case-by-id/{id}")
	public Optional<Case> getCaseById(@PathVariable("id") String id) {
		return service.getCaseById(id);
	}
	
	@GetMapping("/get-case-by-brand/{brand}")
	public ArrayList<Case> getCaseByBrand(@PathVariable("brand") String brand) {
		return service.getCaseByBrand(brand);
	}
	
	@GetMapping("/get-all-case")
	public List<Case> getAllCase() {
		return service.getAllCase();
	}
	
	@DeleteMapping("/delete-case")
	public Boolean deleteCase(@RequestParam String id) {
		return service.deleteCase(id);
	}


}
