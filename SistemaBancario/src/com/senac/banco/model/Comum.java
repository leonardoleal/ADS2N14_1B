package com.senac.banco.model;

public class Comum implements Conta {

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

	public void sacar(double valorSaque) {
		this.saldo -= valorSaque;
	}
}
