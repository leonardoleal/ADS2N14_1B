package com.senac.jogo.deserto.exception;

public class TanqueCombustivelVazioException extends Exception {
	private static final long serialVersionUID = 1L;

	public TanqueCombustivelVazioException() {
		super("Sem combustível.");
	}
}