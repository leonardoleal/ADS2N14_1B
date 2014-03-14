package com.senac.jogos;

public class Jogador {
	
	private int pontos;
	
	public Jogador()
	{
		pontos = 0;
	}
	
	public int getPontos()
	{
		return pontos;
	}

	public void addPontos(int amount)
	{
		this.pontos += amount;
	}
	
	public void subtractPontos(int amount)
	{
		this.pontos -= amount;
	}
	
	public void setPontos(int pontos)
	{
		this.pontos = pontos;
	}
	
}










