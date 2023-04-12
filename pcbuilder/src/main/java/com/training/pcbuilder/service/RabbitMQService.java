package com.training.pcbuilder.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.training.buildforge.model.PC;
import com.training.buildforge.model.Ram;
import com.training.buildforge.service.MotherBoardService;


@Component
@ComponentScan("com.training.buildforge")
public class RabbitMQService implements RabbitListenerConfigurer {

	@Autowired
	private MotherBoardService service;

	private static final Logger logger = LoggerFactory.getLogger(RabbitMQService.class);

	@Override
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
	}

	@RabbitListener(queues = "${spring.rabbitmq.queue}")
	public void receivedMessage(PC pc) {
		logger.info("Pc Details Received is.. " + pc);
		Boolean socketRs = service.getSocketCompatibility(pc.getMOBO().getId(), pc.getCpu().getId());
		Boolean caseRs = service.getCaseCompatibility(pc.getMOBO().getId(), pc.getPcCase().getId());
		Boolean heatSinkRs = service.getHeatSinkCompatibility(pc.getMOBO().getId(), pc.getHeatSink().getId());
		String error ="";
		
		for (Ram ram : pc.getRam()) {
			Boolean ddrcRs = service.getDdrcCompatibility(pc.getMOBO().getId(), ram.getId());
			if (!ddrcRs) {
				logger.info("Not compatible Ram: " + ram.getBrand() + " " + ram.getName());
			}
		}

		if (!socketRs) {
			error+=pc.getMOBO().getBrand() + " " + pc.getMOBO().getName() + " is not compatible with "
					+ pc.getCpu().getBrand() + " " + pc.getCpu().getName();
			logger.info(error);
		}

		if (!caseRs) {

			error+=pc.getMOBO().getBrand() + " " + pc.getMOBO().getName() + " is not compatible with "
					+ pc.getPcCase().getBrand() + " " + pc.getPcCase().getName();
			logger.info(error);

		}

		if (!heatSinkRs) {

			logger.info(pc.getMOBO().getBrand() + " " + pc.getMOBO().getName() + " is not compatible with "
					+ pc.getHeatSink().getBrand() + " " + pc.getHeatSink().getName());

		}

	}

}
