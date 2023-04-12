package com.training.buildforge.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Document(value="PC")
@Component
public class PC implements Serializable {

	private static final long serialVersionUID = 1L;

	private MotherBoard MOBO;
	
	private Cpu cpu;
	
	private Gpu gpu;
	
	private Psu psu;
	
	private List<Ram> ram;
	
	private List<Storage> storage;
	
	private Case PcCase;
	
	private HeatSink heatSink;

}
