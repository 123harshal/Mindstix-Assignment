package com.mindstix.microservicea.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "order")
public class Order {

	@Id
	private Long id;
	
	private String orderedBy;
	
	private List<Long> items;
	
	private Long totalCost;

}