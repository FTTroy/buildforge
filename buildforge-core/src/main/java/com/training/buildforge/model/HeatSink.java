package com.training.buildforge.model;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(value="HEATSINK")
public class HeatSink extends PcComponent {
	
	private Boolean isLiquid;
	
	private ArrayList<String> socket;

}
