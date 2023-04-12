package com.training.buildforge.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.buildforge.model.PC;
import com.training.buildforge.sender.RabbitMQSender;
import com.training.buildforge.service.PCService;


@RestController
@RequestMapping("/pc-controller")
public class PCController {
	
	 private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PCController.class);

	@Autowired
	private PCService service;

	private RabbitMQSender rabbitMqSender;

	@Autowired
	public PCController(RabbitMQSender rabbitMqSender) {
		this.rabbitMqSender = rabbitMqSender;
	}

	@Value("${app.message}")
	private String message;

	@PostMapping(value = "pc")
	public void publishUserDetails(@RequestParam String cpuId, @RequestParam String gpuId, @RequestParam String psuId,
			@RequestParam String ramId, @RequestParam String moboId, @RequestParam String caseId,
			@RequestParam String storageId, @RequestParam String hsId) {
		PC pc = service.PcBuilder(cpuId, gpuId, psuId, ramId, moboId, caseId, storageId, hsId);
//             try {
		rabbitMqSender.send(pc);
//             }catch(Exception e) {
//            	 logger.info("eccezione catturata in Pc Controller");
//             }
	}

}
