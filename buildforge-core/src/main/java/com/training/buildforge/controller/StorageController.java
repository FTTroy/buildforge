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

import com.training.buildforge.model.Storage;
import com.training.buildforge.service.StorageService;

@RestController
@RequestMapping("storage-controller")
public class StorageController {
	
	@Autowired
	private StorageService service;
	
	@PostMapping("/save-storage")
	public Storage saveStorage(@RequestBody Storage storage) {
		return service.saveStorage(storage);
	}
	
	@PutMapping("/update-storage")
	public Storage updateStorage(@RequestBody Storage storage) {
		return service.updateStorage(storage);
	}
	
	@GetMapping("/get-storage-by-id/{id}")
	public Optional<Storage> getStorageById(@PathVariable("id") String id) {
		return service.getStorageById(id);
	}
	
	@GetMapping("/get-storage-by-brand/{brand}")
	public ArrayList<Storage> getStorageByBrand(@PathVariable("brand") String brand) {
		return service.getStorageByBrand(brand);
	}
	
	@GetMapping("/get-all-storage")
	public List<Storage> getAllStorage() {
		return service.getAllStorage();
	}
	
	@DeleteMapping("/delete-storage")
	public Boolean deleteStorage(@RequestParam String id) {
		return service.deleteStorage(id);
	}


}
