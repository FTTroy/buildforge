package com.training.buildforge.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(value="CPU")
public class Cpu extends PcComponent {

	private String socket;

	private String core;

	private String thread;

	private String clockSpeed;

	private String memorySupport;

	private String overclockSupport;

}
