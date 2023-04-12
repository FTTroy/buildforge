package com.training.buildforge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.buildforge.model.Case;
import com.training.buildforge.model.Cpu;
import com.training.buildforge.model.HeatSink;
import com.training.buildforge.model.MotherBoard;
import com.training.buildforge.model.Ram;
import com.training.buildforge.repository.CaseRepository;
import com.training.buildforge.repository.CpuRepository;
import com.training.buildforge.repository.HeatSinkRepository;
import com.training.buildforge.repository.MotherBoardRepository;
import com.training.buildforge.repository.RamRepository;

@Service
public class MotherBoardService {

	@Autowired
	private MotherBoardRepository repository;

	@Autowired
	private CpuRepository cpuRepository;
	
	@Autowired
	private RamRepository ramRepository;
	
	@Autowired
	private CaseRepository caseRepository;
	
	@Autowired
	private HeatSinkRepository heatSinkRepository;
	
	private Logger log = LoggerFactory.getLogger(MotherBoard.class);

	public MotherBoard saveMotherBoard(MotherBoard motherBoard) {

		return repository.save(motherBoard);
	}

	public MotherBoard updateMotherBoard(MotherBoard motherBoard) {
		log.info("updating Mother Board with id: " + motherBoard.getId());
		Optional<MotherBoard> motherBoardOpt = repository.findById(motherBoard.getId());
		if (!motherBoardOpt.isPresent()) {
			log.warn("Mother Board not found");
			throw new RuntimeException("id not found");
		}
		MotherBoard motherBoardDb = motherBoardOpt.get();
		BeanUtils.copyProperties(motherBoard, motherBoardDb);
		return repository.save(motherBoardDb);
	}

	public Optional<MotherBoard> getMotherBoardById(String id) {
		Optional<MotherBoard> motherBoardOpt = repository.findById(id);
		if (motherBoardOpt.isPresent()) {
			log.info("Getting MotherBoard with id: " + id);
			return motherBoardOpt;
		} else {
			log.info("Cannot find Mother Board!");
			throw new RuntimeException("Mother Board Not Found");
		}
	}

	public ArrayList<MotherBoard> getMotherBoardByBrand(String brand) {
		return repository.getMotherBoardByBrand(brand);
	}

	public List<MotherBoard> getAllMotherBoard() {
		return repository.findAll();
	}

	public Boolean deleteMotherBoard(String id) {
		Optional<MotherBoard> motherBoardOpt = repository.findById(id);
		if (motherBoardOpt.isPresent()) {
			MotherBoard motherBoardDb = motherBoardOpt.get();
			log.info("Mother Board with id: " + id + " successfully deleted!");
			repository.delete(motherBoardDb);

			return true;
		}
		log.info("Cannot delete Mother Board!");
		return false;
	}

	public Boolean getSocketCompatibility(String moboId, String cpuId) {
		Optional<MotherBoard> mbOpt = repository.findById(moboId);
		Optional<Cpu> cpuOpt = cpuRepository.findById(cpuId);
		if (mbOpt.get().getSocket().equals(cpuOpt.get().getSocket())) {
			log.info(mbOpt.get().getBrand() + " " + mbOpt.get().getName() + " socket is compatible with "
					+ cpuOpt.get().getBrand() + " " + cpuOpt.get().getName() + " socket");
			return true;
					
		} else {
			Optional<List<Cpu>> compatibleCpu = cpuRepository.getCpuBySocket(mbOpt.get().getSocket());
			String res = "Not compatible Socket! Other compatible CPU: \n";
			for (Cpu cpu : compatibleCpu.get()) {
				res = res + cpu.getName() + "\n";
				log.info(res);
				return false;
			}
			return true;
		}

	}
	
	public Boolean getDdrcCompatibility(String moboId, String ramId) {
		Optional<MotherBoard> mbOpt = repository.findById(moboId);
		Optional<Ram> ramOpt = ramRepository.findById(ramId);
		if (mbOpt.get().getRamSupport().getDdrc().toUpperCase().equals(ramOpt.get().getDdrc().toUpperCase())) {
			log.info(mbOpt.get().getBrand() + " " + mbOpt.get().getName() + " is compatible with "
					+ ramOpt.get().getBrand() + " " + ramOpt.get().getName());
			return true;
				
		} else {
			Optional<List<Ram>> compatibleRam = ramRepository.getRamByDdrc(mbOpt.get().getRamSupport().getDdrc());
			String res = "Not compatible DDRC! Other compatible RAM: \n";
			for (Ram ram : compatibleRam.get()) {
				res = res + ram.getName() + "\n";
				return false;
			}
			return true;
		}

	}
	
	public Boolean getCaseCompatibility(String moboId, String caseId) {
		Optional<MotherBoard> mbOpt = repository.findById(moboId);
		Optional<Case> caseOpt = caseRepository.findById(caseId);
		if (mbOpt.get().getFormFactor().toUpperCase().equals(caseOpt.get().getMoboSupport().toUpperCase())) {
			log.info( mbOpt.get().getBrand() + " " + mbOpt.get().getName() + " is compatible with "
					+ caseOpt.get().getBrand() + " " + caseOpt.get().getName());
			return true;
		} else {
			Optional<List<Case>> compatibleCase = caseRepository.getCaseByMoboSupport(mbOpt.get().getFormFactor());
			String res = "Not compatible DDRC! Other compatible RAM: \n";
			for (Case cases : compatibleCase.get()) {
				res = res + cases.getName() + "\n";
				log.info(res);
				return false;
			}
			return true;
		}

	}
	
	public Boolean getHeatSinkCompatibility(String moboId, String heatSinkId) {
		Optional<MotherBoard> mbOpt = repository.findById(moboId);
		Optional<HeatSink> hsOpt = heatSinkRepository.findById(heatSinkId);
		String res = "";
		for (String hs:  hsOpt.get().getSocket()) {
		   if (mbOpt.get().getSocket().toUpperCase().equals(hs)) {
			   res = mbOpt.get().getBrand() + " " + mbOpt.get().getName() + " is compatible with "
						+ hsOpt.get().getBrand() + " " + hsOpt.get().getName();
			   log.info(res);
			return true;

		} else {
			Optional<List<HeatSink>> compatibleHs = heatSinkRepository.getHeatSinkBySocket(mbOpt.get().getSocket());
			 res = "Not compatible HeatSink! Other compatible HeatSink: \n";
		
			for (HeatSink hs1 : compatibleHs.get()) {
				res = res + hs1.getName() + "\n";
			}
			log.info(res);
			return false;
		}
	}
		return true;
}
	
	

}
