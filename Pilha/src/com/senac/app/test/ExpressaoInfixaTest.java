package com.senac.app.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.senac.app.ExpressaoInfixa;

public class ExpressaoInfixaTest {

	@Test
	public void testEntradaInfixaSaidaPosfixa() {
    	String infixa = "( 4 + 5 / ( 6 + 9 ) ) + 7 * 8";

		String posfixa = ExpressaoInfixa.infixa2posfixa(infixa);
		assertEquals("4569+/+78*+", posfixa);
	}

	@Test
	public void testResolveExpressaoInfixa() {
    	String infixa = "( 6 * 8 / ( 6 * 9 - 6) + 4 ) + 7 * 8 - 2";
    	// 68*69*6-/4+78*2+-

		assertEquals(59, ExpressaoInfixa.resolveExpInfixa(infixa), 0);
	}
}