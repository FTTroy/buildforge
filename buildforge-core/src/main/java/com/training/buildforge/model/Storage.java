package com.training.buildforge.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(value = "STORAGE")
public class Storage extends PcComponent {

	private String memorySize;

	private String writingSpeed;

	private String readingSpeed;

}
