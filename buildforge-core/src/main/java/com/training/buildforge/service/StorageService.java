package com.training.buildforge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.buildforge.model.Storage;
import com.training.buildforge.repository.StorageRepository;

@Service
public class StorageService {

	@Autowired
	private StorageRepository repository;

	private Logger log = LoggerFactory.getLogger(Storage.class);

	public Storage saveStorage(Storage storage) {
		return repository.save(storage);
	}

	public Storage updateStorage(Storage storage) {
		log.info("updating Storage with id: " + storage.getId());
		Optional<Storage> storageOpt = repository.findById(storage.getId());
		if (!storageOpt.isPresent()) {
			log.warn("Storage not found");
			throw new RuntimeException("id not found");
		}
		Storage storageDb = storageOpt.get();
		BeanUtils.copyProperties(storage, storageDb);
		return repository.save(storageDb);
	}

	public Optional<Storage> getStorageById(String id) {
		Optional<Storage> storageOpt = repository.findById(id);
		if (storageOpt.isPresent()) {
			log.info("Getting storage with id: " + id);
			return storageOpt;
		} else {
			log.info("Cannot find storage!");
			throw new RuntimeException("storage Not Found");
		}
	}

	public ArrayList<Storage> getStorageByBrand(String brand) {
		return repository.getStorageByBrand(brand);
	}
	
	public List<Storage> getAllStorage() {
		return repository.findAll();
	}

	public Boolean deleteStorage(String id) {
		Optional<Storage> storageOpt = repository.findById(id);
		if (storageOpt.isPresent()) {
			Storage storageDb = storageOpt.get();
			log.info("Storage with id: " + id + " successfully deleted!");
			repository.delete(storageDb);

			return true;
		}
		log.info("Cannot delete Storage!");
		return false;
	}

}
