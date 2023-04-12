package com.training.buildforge.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class PcComponent implements Serializable {

	@Id
	private String id;
	
	private String type;
	
	private String name;

	private String brand;

	private String description;

	private String price;

}
