package com.senac.banco.model;

public interface Conta {

	public double getSaldo();
	public void setNumConta(int numConta);
	public int getNumConta();
	public int getNumVerificacao();
	public void depositar(double valorDeposito);
	public void sacar(double valorSaque);
}
