package com.senac.banco.model;

import java.sql.Date;

public class Investimento extends Conta {

	private int dataCriacao;

	public Investimento(int numConta, double saldo) {
		super(numConta, saldo);
		this.setDataCriacao();
	}

	public int getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao() {
		Date data = new Date(System.currentTimeMillis());
		
		String dataStr = data.toString();
		dataStr = dataStr.replaceAll("[^\\d.]", "");

		this.dataCriacao = Integer.parseInt(dataStr);
	}

	public void dividendos(double taxa) {
		double acressimo = super.getSaldo() * (taxa/100);

		super.setSaldo(super.getSaldo() + acressimo);
	}
}