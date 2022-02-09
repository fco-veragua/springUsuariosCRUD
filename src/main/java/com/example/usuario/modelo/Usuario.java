package com.example.usuario.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Usuario {
	private Integer id;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Integer edad;
}
