package com.senac.banco.model;

public class Especial extends Comum {

	private double limite;

	public double getLimite() {
		return this.limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public void sacar(double valorSaque) {
		double saldo = 0;
		super.setSaldo(saldo);
	}
}