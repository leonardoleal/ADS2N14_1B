package com.senac.banco.model;

public class Cliente {

	private String nome;
	private Conta conta;

	public Cliente(String nome, Conta conta) {
		this.nome = nome;
		this.conta = conta;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Conta getConta() {
		return this.conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}