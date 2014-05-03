package com.senac.jogo.deserto;

import com.senac.jogo.deserto.exception.TanqueCombustivelCheioException;
import com.senac.jogo.deserto.exception.TanqueCombustivelVazioException;

public class Caminhao {

	private int combustivel;
	private int maxNivelCombustivel;

	public Caminhao() {
		this.combustivel = 0;
		this.maxNivelCombustivel = 6;
	}

	public int getNivelCombustivel() {
		return combustivel;
	}

	public void adicionarCombustivel() throws TanqueCombustivelCheioException {
		if (!this.canAbastecer())
			throw new TanqueCombustivelCheioException();

		this.combustivel++;
	}

	public void consumirCombustivel() throws TanqueCombustivelVazioException {
		if (!this.hasCombustivel())
			throw new TanqueCombustivelVazioException();

		this.combustivel--;
	}

	private boolean hasCombustivel() {
		return this.combustivel > 0;
	}

	private boolean canAbastecer() {
		return this.combustivel < this.maxNivelCombustivel;
	}
}