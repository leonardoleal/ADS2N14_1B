package com.senac.app.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.senac.app.ExpressaoInfixa;

public class ExpressaoInfixaTest {

	@Test
	public void testEntradaInfixaSaidaPosfixa() {
    	String infixa = "(4 + 5 /( 6 +99 ) ) + 7* 8";

		String posfixa = ExpressaoInfixa.infixa2posfixa(infixa);
		assertEquals("4 5 6 99 + / + 7 8 * +", posfixa);
	}

	@Test
	public void testResolveExpressaoInfixaAlgarismosMenorQueDez() {
    	String infixa = "( 6 * 8 / ( 6 * 9 - 6) + 4 ) + 7 * 8 - 2";
    	// 6 8 * 6 9 * 6 - / 4 + 7 8 * 2 - +

		assertEquals(59, ExpressaoInfixa.resolveExpInfixa(infixa), 0);
	}

	@Test
	public void testResolveExpressaoInfixaAlgarismosMaiorQueDez() {
    	String infixa = "( 6 * 8 / ( 6 * 9 - 6) + 10 ) + 7 * 8 - 22";
    	// 6 8 * 6 9 * 6 - / 4 + 7 8 * 22 - +

		assertEquals(45, ExpressaoInfixa.resolveExpInfixa(infixa), 0);
	}

	@Test
	public void testResolveExpressaoInfixaResultadoNegativo() {
    	String infixa = "( 6 * 8 / ( 6 * 9 - 6) + 10 ) - 545 + 7 * 8 - 22";

		assertEquals(-500, ExpressaoInfixa.resolveExpInfixa(infixa), 0);
	}
}