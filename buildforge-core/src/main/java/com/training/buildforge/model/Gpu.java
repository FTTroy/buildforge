package com.training.buildforge.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(value="GPU")
public class Gpu extends PcComponent{

	private String memorySize;

	private String bandwidth;

	private String apiSupport;

}
