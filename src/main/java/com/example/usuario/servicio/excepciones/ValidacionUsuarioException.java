package com.example.usuario.servicio.excepciones;

import java.util.Map;

public class ValidacionUsuarioException extends Exception {
	private static final long serialVersionUID = 1L;
	private Map<Integer, String> errores;

	public ValidacionUsuarioException(Map<Integer, String> errores) {

	}

	public Map<Integer, String> getErrores() {
		return errores;
	}
}
