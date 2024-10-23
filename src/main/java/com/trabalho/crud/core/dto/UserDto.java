package com.trabalho.crud.core.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String nome;
    private String cpf;
    private String animal;
    private String raça;
}
