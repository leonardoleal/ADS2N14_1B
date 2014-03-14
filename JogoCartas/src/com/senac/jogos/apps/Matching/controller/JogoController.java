package com.senac.jogos.apps.Matching.controller;

import com.senac.jogos.Jogador;
import com.senac.jogos.apps.Matching.model.MatchingCardGame;
import com.senac.jogos.cartas.Carta;

public class JogoController {

	private MatchingCardGame jogo;
	private Carta cartaJogador;
	private Jogador jogadores[];

	private int jogadorRodada;
	
	public JogoController()
	{
		jogo = new MatchingCardGame();
		cartaJogador = null;
		jogadorRodada = 0;
	}
	
	public void playTurno()
	{
		int pontos = jogo.matchCarta(cartaJogador);
		this.getJogador().addPontos(pontos);

		// descarta
		jogo.setMesa(cartaJogador);
		cartaJogador = null;
	}
	
	public void passTurno()
	{
		// passar turno perde 1 ponto
		this.getJogador().addPontos(-1);
	}
	
	public String showJogador()
	{
		return String.format("Pontos do jogador %d: %d",
									jogadorRodada+1,
									this.getJogador().getPontos()
		);
	}
	
	private String showCarta(Carta carta)
	{
		return String.format("%d%c",
						     carta.getValor(),
						     carta.getNaipe()
		);
	}

	public String showMesa()
	{
		return showCarta(jogo.getMesa());
	}
	
	public String showCartaJogador()
	{
		if (cartaJogador == null)
			cartaJogador = jogo.drawCarta();
		return showCarta(cartaJogador);
	}

	public boolean checkFimJogo()
	{
		if (jogo.getNumCartas() == 0) {
			return false;
		}

		return true;
	}

	public Jogador getJogador()
	{
		return jogadores[jogadorRodada];
	}
	
	public void nextJogador()
	{
		if (jogadorRodada < jogadores.length-1) {
			jogadorRodada++;
		} else {
			jogadorRodada = 0;
		}
	}

	private void createJogadores(int numJogadores)
	{
		// cria os jogadores
		jogadores = new Jogador[numJogadores];

		for (int i = 0; i < numJogadores; i++) {
			jogadores[i] = new Jogador();
		}
	}

	public boolean validateNumJogadores(int numJogadores)
	{
		if (numJogadores > 0 && numJogadores < 5) {
			this.createJogadores(numJogadores);
			return false;
		}

		return true;
	}
}
