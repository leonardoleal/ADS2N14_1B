package com.senac.banco.model;

import com.senac.agenda.model.Pessoa;

public class Cliente extends Pessoa{

	private Conta conta;

	public Cliente(String nome, Conta conta) {
		super.setNome(nome);
		this.conta = conta;
	}

	public Conta getConta() {
		return this.conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}