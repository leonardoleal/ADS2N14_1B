package com.senac.jogos.apps.Matching.model;

import com.senac.jogos.cartas.Baralho;
import com.senac.jogos.cartas.Carta;

public class MatchingCardGame {

	private Baralho baralho;
	private Carta mesa;
	
	public MatchingCardGame()
	{
		this.baralho = new Baralho();
		this.mesa = baralho.drawCarta();
	}
	
	public int matchCarta(Carta carta)
	{
		int score = -2;
		
		if (carta.getNaipe() == this.mesa.getNaipe())
			score = 1;
		if (carta.getValor() == this.mesa.getValor())
			score = 4;
		
		return score;
	}
	
	public void setMesa(Carta carta)
	{
		this.mesa = carta;
	}
	
	public Carta getMesa()
	{
		return this.mesa;
	}

	
	public Carta drawCarta()
	{
		Carta carta = this.baralho.drawCarta();

		return carta;
	}

	public int getNumCartas()
	{
		return this.baralho.getNumCartas();
	}
}












