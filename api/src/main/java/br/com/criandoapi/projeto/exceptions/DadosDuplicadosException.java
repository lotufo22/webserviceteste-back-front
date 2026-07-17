package br.com.criandoapi.projeto.exceptions;

import java.util.Map;

public class DadosDuplicadosException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private final Map<String, String> errors;

	public DadosDuplicadosException(Map<String, String> errors) {
		super("Dados duplicados encontrados");
		this.errors = errors;
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
}
