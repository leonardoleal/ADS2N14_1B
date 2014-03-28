package com.senac.banco.model;

public class Investimento extends Conta {

	private int dataCriacao;

	public int getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(int dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public void dividendos(double taxa) {
		double acressimo = super.getSaldo() * (taxa/100);

		super.setSaldo(super.getSaldo() + acressimo);
	}
}