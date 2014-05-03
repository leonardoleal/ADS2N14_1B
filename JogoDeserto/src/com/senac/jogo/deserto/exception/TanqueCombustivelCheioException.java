package com.senac.jogo.deserto.exception;

public class TanqueCombustivelCheioException extends Exception {
	private static final long serialVersionUID = 1L;

	public TanqueCombustivelCheioException() {
		super("Nivel de combustivel no máximo.");
	}
}