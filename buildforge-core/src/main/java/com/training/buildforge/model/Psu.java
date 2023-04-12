package com.training.buildforge.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(value="PSU")
public class Psu extends PcComponent {
	
	private String watt;
	
	private String certification;
	
	

}
