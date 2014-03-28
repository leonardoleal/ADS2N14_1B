package com.senac.banco.model;

import com.senac.banco.exception.SaldoInsuficiente;

public class Conta {

	private double saldo;
	private int numConta;
	private int numVerificacao;

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public int getNumConta() {
		return this.numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public int getNumVerificacao() {
		return this.numVerificacao;
	}

	public void depositar(double valorDeposito) {
		this.saldo += valorDeposito;
	}

	public void sacar(double valorSaque) throws SaldoInsuficiente {
		if (valorSaque > this.getSaldo()) {
			throw new SaldoInsuficiente();
		}

		this.setSaldo(this.getSaldo() - valorSaque);
	}
}
