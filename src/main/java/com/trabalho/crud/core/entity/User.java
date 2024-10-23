package com.trabalho.crud.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"USER\"")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;

    private String nome;

    private String cpf;

    private String animal;

    private String raça;

}
