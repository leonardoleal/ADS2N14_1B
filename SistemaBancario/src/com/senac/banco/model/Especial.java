package com.senac.banco.model;

import com.senac.banco.exception.SaldoInsuficiente;

public class Especial extends Conta {

	private double limite;

	public double getLimite() {
		return this.limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public void sacar(double valorSaque) throws SaldoInsuficiente {
		double limiteSaque = this.getSaldo() + this.getLimite();

		if (valorSaque > limiteSaque) {
			throw new SaldoInsuficiente();
		}

		super.setSaldo(this.getSaldo() - valorSaque);
	}
}