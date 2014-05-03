package com.senac.jogo.deserto.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.senac.jogo.deserto.Caminhao;
import com.senac.jogo.deserto.exception.TanqueCombustivelCheioException;
import com.senac.jogo.deserto.exception.TanqueCombustivelVazioException;

public class CaminhaoTest {

	Caminhao caminhao;

	@Before
	public void setup() {
		// Preparar o ambiente de teste
		caminhao = new Caminhao();
	}

	@Test
	public void testAdcionarCobustivel() throws TanqueCombustivelCheioException {
		caminhao.adicionarCombustivel();

		assertEquals(1, caminhao.getNivelCombustivel());
	}

	@Test(expected = TanqueCombustivelCheioException.class)
	public void testNaoAdicionarCobustivelTanqueCheio() throws TanqueCombustivelCheioException {
		for (int i = 0; i < 7; i++) {
			caminhao.adicionarCombustivel();
		}
	}

	@Test
	public void testConsomeCombustivel() throws TanqueCombustivelVazioException, TanqueCombustivelCheioException {
		int nivelCombOld;

		caminhao.adicionarCombustivel();
		nivelCombOld = caminhao.getNivelCombustivel();
		caminhao.consumirCombustivel();

		assertEquals(nivelCombOld - 1, caminhao.getNivelCombustivel());
	}

	@Test(expected = TanqueCombustivelVazioException.class)
	public void testNaoComsomeSemCobustivel() throws TanqueCombustivelVazioException, TanqueCombustivelCheioException {
		for (int i = 0; i < 5; i++) {
			caminhao.adicionarCombustivel();
		}

		for (int i = 0; i < 6; i++) {
			caminhao.consumirCombustivel();
		}
	}
}