package com.training.buildforge.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(value = "CASE")
public class Case extends PcComponent {
	
	private String moboSupport;
	
	
	
	

}
