package com.FDMF.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Pet {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String name;
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 private Date fechaNac;
	 private String raza;
	 private int peso;
	 private boolean tiene_chip;
	 private String url_foto;
	 @ManyToOne
	 @JoinColumn(name = "owner_id")
	 private Owner owner;
	 
}