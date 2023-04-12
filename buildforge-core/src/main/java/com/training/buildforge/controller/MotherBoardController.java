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

import com.training.buildforge.model.MotherBoard;
import com.training.buildforge.service.MotherBoardService;

@RestController
@RequestMapping("/motherboard-controller")
public class MotherBoardController {
	
	@Autowired
	private MotherBoardService service;
	
	@PostMapping("/save-motherboard")
	public MotherBoard saveMotherBoard(@RequestBody MotherBoard motherBoard) {
		return service.saveMotherBoard(motherBoard);
	}
	
	@PutMapping("/update-motherboard")
	public MotherBoard updateMotherBoard(@RequestBody MotherBoard motherBoard) {
		return service.updateMotherBoard(motherBoard);
	}
	
	@GetMapping("/get-motherboard-by-id/{id}")
	public Optional<MotherBoard> getMotherBoardById(@PathVariable("id") String id) {
		return service.getMotherBoardById(id);
	}
	
	@GetMapping("/get-motherboard-by-brand/{brand}")
	public ArrayList<MotherBoard> getMotherBoardByBrand(@PathVariable("brand") String brand) {
		return service.getMotherBoardByBrand(brand);
	}
	
	@GetMapping("/get-all-motherboard")
	public List<MotherBoard> getAllMotherBoard() {
		return service.getAllMotherBoard();
	}
	
	@GetMapping("/get-socket-compatibility")
	public Boolean getSocketCompatibility(@RequestParam String moboId,@RequestParam String cpuId) {
		return service.getSocketCompatibility(moboId,cpuId);
	}
	
	@GetMapping("/get-ddrc-compatibility")
	public Boolean getDdrcCompatibility(@RequestParam String moboId,@RequestParam String ramId) {
		return service.getDdrcCompatibility(moboId,ramId);
	}
	
	@GetMapping("/get-case-compatibility")
	public Boolean getCaseCompatibility(@RequestParam String moboId,@RequestParam String caseId) {
		return service.getCaseCompatibility(moboId,caseId);
	}
	
	@GetMapping("/get-heatsink-compatibility")
	public Boolean getHeatSinkCompatibility(@RequestParam String moboId,@RequestParam String heatSinkId) {
		return service.getHeatSinkCompatibility(moboId,heatSinkId);
	}
	
	@DeleteMapping("/delete-motherboard")
	public Boolean deleteMotherBoard(@RequestParam String id) {
		return service.deleteMotherBoard(id);
	}

}
