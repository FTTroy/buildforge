package com.training.buildforge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.buildforge.model.Case;
import com.training.buildforge.model.Cpu;
import com.training.buildforge.model.Gpu;
import com.training.buildforge.model.HeatSink;
import com.training.buildforge.model.MotherBoard;
import com.training.buildforge.model.PC;
import com.training.buildforge.model.Psu;
import com.training.buildforge.model.Ram;
import com.training.buildforge.model.Storage;
import com.training.buildforge.repository.CaseRepository;
import com.training.buildforge.repository.CpuRepository;
import com.training.buildforge.repository.GpuRepository;
import com.training.buildforge.repository.HeatSinkRepository;
import com.training.buildforge.repository.MotherBoardRepository;
import com.training.buildforge.repository.PCRepository;
import com.training.buildforge.repository.PsuRepository;
import com.training.buildforge.repository.RamRepository;
import com.training.buildforge.repository.StorageRepository;

@Service
public class PCService {

	@Autowired
	PCRepository pcRepository;

	@Autowired
	CpuRepository cpuRepository;

	@Autowired
	GpuRepository gpuRepository;

	@Autowired
	PsuRepository psuRepository;

	@Autowired
	RamRepository ramRepository;

	@Autowired
	StorageRepository storageRepository;

	@Autowired
	CaseRepository caseRepository;

	@Autowired
	MotherBoardRepository motherBoardRepository;

	@Autowired
	HeatSinkRepository heatSinkRepository;

	public PC PcBuilder(String cpuId, String gpuId, String psuId, String ramId, String moboId, String pcCaseId,
			String storageId, String htId) {
		
		PC pc = new PC();

		Optional<Cpu> cpuOpt = cpuRepository.findById(cpuId);
		
		if (cpuOpt.isPresent()) {
			Cpu cpu = cpuOpt.get();
			pc.setCpu(cpu);
		}else throw new IllegalArgumentException("Cpu Not Found");
		
		Optional<Gpu> gpuOpt = gpuRepository.findById(gpuId);

		if (gpuOpt.isPresent()) {
			Gpu gpu = gpuOpt.get();
			pc.setGpu(gpu);
		}else throw new IllegalArgumentException("Gpu Not Found");
		
		Optional<Psu> psuOpt = psuRepository.findById(psuId);

		if (psuOpt.isPresent()) {
			Psu psu = psuOpt.get();
			pc.setPsu(psu);
		}else throw new IllegalArgumentException("Psu Not Found");

		Optional<Ram> ramOpt = ramRepository.findById(ramId);

		if (ramOpt.isPresent()) {
			List<Ram> ram = new ArrayList<>();
			ram.add(ramOpt.get());
			pc.setRam(ram);
		}else throw new IllegalArgumentException("Ram Not Found");

		Optional<Case> caseOpt = caseRepository.findById(pcCaseId);

		if (caseOpt.isPresent()) {
			Case pcCase = caseOpt.get();
			pc.setPcCase(pcCase);
		}else throw new IllegalArgumentException("Case Not Found");

		Optional<Storage> storageOpt = storageRepository.findById(storageId);
		
		if (storageOpt.isPresent()) {
			List<Storage> storage = new ArrayList<>();
			storage.add(storageOpt.get());
			pc.setStorage(storage);
		}else throw new IllegalArgumentException("storage Not Found");
		
		Optional<MotherBoard> moboOpt = motherBoardRepository.findById(moboId);

		if (moboOpt.isPresent()) {
			MotherBoard mobo = moboOpt.get();
			pc.setMOBO(mobo);
		}else throw new IllegalArgumentException("mobo Not Found");

		Optional<HeatSink> htOpt = heatSinkRepository.findById(htId);

		if (htOpt.isPresent()) {
			HeatSink heatSink = htOpt.get();
			pc.setHeatSink(heatSink);
		}else throw new IllegalArgumentException("HeatSink Not Found");

		return pc;

	}

}
