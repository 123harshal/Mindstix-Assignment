package com.mindstix.microserviceb.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table(name="product")
public class Product implements Serializable{
	
	private static final long serialVersionUID = 7156526077883281623L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  id;
	
	private String name;
	
	private Long price;

}
