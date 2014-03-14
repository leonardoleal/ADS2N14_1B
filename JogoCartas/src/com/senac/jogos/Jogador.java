package com.senac.jogos;

public class Jogador {
	
	private String nome;
	private int pontos;
	private boolean pularTurno;
	
	public Jogador(String nome)
	{
		this.nome = nome;
		this.pontos = 0;
		this.pularTurno = false;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public boolean getPularTurno() {
		return this.pularTurno;
	}

	public void setPularTurno(boolean pularTurno) {
		this.pularTurno = pularTurno;
	}
}










