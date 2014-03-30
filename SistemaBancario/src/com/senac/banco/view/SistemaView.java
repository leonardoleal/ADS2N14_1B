package com.senac.banco.view;

import static java.lang.System.out;
import static java.lang.System.err;
import java.util.Scanner;

public class SistemaView {
	private static Scanner scanner = new Scanner(System.in);

	public void encerrar() {
		out.println("Fechando o sistema!\n  See you! :D");

		System.exit(0);
	}

	public void mensagemOpInvalida() {
		err.println("Op��o inv�lida...");
	}

	public String menuPrincipal() {
		out.println(
				"Digite a op��o desejada:"
				+ "\n1 - Cadastar Conta"
				+ "\n2 - Transa��es Conta"
				+ "\nS - Sair"
		);

		return scanner.next();
	}

	public String entradaNome() {
		out.print("Nome: ");

		return scanner.next();
	}

	public String menuTipoConta() {
		out.println(
				"Digite a op��o desejada:"
				+ "\nC - Conta Comum"
				+ "\nE - Conta Especial"
				+ "\nI - Conta Investimento"
		);

		return scanner.next();
	}

	public String entradaNumeroConta() {
		out.print("Digite o n�mero da conta: ");

		return scanner.next();
	}

	public String entradaSaldo() {
		out.print("Entre com o saldo inicial: ");

		return scanner.next();
	}

	public String entradaLimite() {
		out.print("Entre com o limite de cr�dito: ");

		return scanner.next();
	}

	public void cadastroEfetuado(String numConta, String numVerificacao) {
		out.println("Conta cadastrada! \nConta n�: " + numConta + "-" + numVerificacao);
	}

	public String menuTransacoesConta() {
		out.println(
				"Digite a op��o desejada:"
				+ "\n1 - Sacar"
				+ "\n2 - Depositar"
				+ "\n3 - Investimento"
				+ "\n4 - Saldo"
				+ "\nV - Voltar"
		);

		return scanner.next();
	}

	public String entradaValorSaque() {
		out.print("Entre com o valor: ");

		return scanner.next();
	}

	public void saqueEfetuado() {
		out.println("Saque Efetuado!");
	}

	public String entradaValorDeposito() {
		out.print("Entre com o valor: ");

		return scanner.next();
	}

	public void depositoEfetuado() {
		out.println("Deposito Efetuado!");
	}

	public String entradaTaxaDividendo() {
		out.print("Entre com a taxa: (%) ");

		return scanner.next();
	}

	public void dividendoEfetuado() {
		out.println("Dividendo Efetuado!");
	}

	public void exibeSaldo(String nome, int numConta, int numVerificacao, Double saldo) {
		out.println("Cliente: " + nome);
		out.println("Conta: " + numConta + "-" + numVerificacao);
		out.println(String.format("Saldo: %.2f", saldo));
	}

	public void exibeLimite(double limite) {
		out.println("Limite: " + String.format("Saldo: %.2f", limite));
	}

	public void exibeDataCriacao(int dataCriacao) {
		out.println("Data Crica��o: " + dataCriacao);
	}

	public void saldoInsuficiente() {
		err.println("Saldo insuficiente.");
	}

	public void clienteNaoCadastrado() {
		err.println("N�o h� cliente cadastrado.");
	}

	public void operacaoInexistente() {
		err.println("Opera��o inexistente para este tipo de conta.");
	}
}