package com.senac.banco.model;

import com.senac.banco.exception.SaldoInsuficiente;

public class Conta {

	private double saldo;
	private int numConta;
	private int numVerificacao;

	public Conta(int numConta, double saldo) {
		this.setNumConta(numConta);
		this.setSaldo(saldo);
	}

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public int getNumConta() {
		return this.numConta;
	}

	protected void setNumConta(int numConta) {
		this.numConta = numConta;
		this.setNumVerificacao();
	}

	public void setNumVerificacao() {
		double tamanho, numVeririficacao;

		tamanho = Math.log10(this.getNumConta()) + 1;
		numVeririficacao = Math.ceil(Math.log(Math.pow(10,tamanho) * this.getNumConta()));

		while(numVeririficacao > 100){
			numVeririficacao = Math.ceil(Math.log(numVeririficacao));
		}

		this.numVerificacao = (int) numVeririficacao;
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
