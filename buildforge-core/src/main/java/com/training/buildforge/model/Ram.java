package com.training.buildforge.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(value = "RAM")
public class Ram extends PcComponent {

	private String latency;

	private String frequency;

	private String memorySize;

	private String bandwidth;

	private String ddrc;

}
