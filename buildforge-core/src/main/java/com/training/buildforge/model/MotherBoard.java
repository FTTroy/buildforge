package com.training.buildforge.model;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(value = "MOBO")
@Component
public class MotherBoard extends PcComponent {

	private String socket;

	private String formFactor;

	private String chipset;

	private ArrayList<String> ports;

	private Integer ramSlots;

	private String nvmeSupport;

	private Ram ramSupport;

}
