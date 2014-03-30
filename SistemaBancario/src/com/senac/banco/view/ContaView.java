package com.senac.banco.view;

import static java.lang.System.out;
import static java.lang.System.err;
import java.util.Scanner;

import com.senac.banco.controller.ContaController;

public class ContaView {
	private static Scanner scanner = new Scanner(System.in);
	private static ContaController controller = new ContaController();
	private String opcao;

	public String entradaNome() {
		out.print("Nome: ");

		return scanner.next();
	}

	public String menuTipoConta() {
		out.println(
				"Digite a opção desejada:"
				+ "\nC - Conta Comum"
				+ "\nE - Conta Especial"
				+ "\nI - Conta Investimento"
		);

		return scanner.next();
	}

	public String entradaNumeroConta() {
		out.print("Digite o número da conta: ");

		return scanner.next();
	}

	public String entradaSaldo() {
		out.print("Entre com o saldo inicial: ");

		return scanner.next();
	}

	public String entradaLimite() {
		out.print("Entre com o limite de crédito: ");

		return scanner.next();
	}

	public void cadastroEfetuado(String numConta, String numVerificacao) {
		out.println("Conta cadastrada! \nConta nº: " + numConta + "-" + numVerificacao);
	}

	public void menuTransacoesConta() {
		out.println(
				"Digite a opção desejada:"
				+ "\n1 - Sacar"
				+ "\n2 - Depositar"
				+ "\n3 - Investimento"
				+ "\n4 - Saldo"
				+ "\nV - Voltar"
		);
		this.opcao = scanner.next();

		switch (this.opcao.toUpperCase()) {
			case "1":
				controller.sacar();
				break;

			case "2":
				controller.depositar();
				break;

			case "3":
				controller.investir();
				break;

			case "4":
				 controller.consultarSaldo();
				break;

			case "V":
				break;

			default:
				SistemaView.mensagemOpInvalida();
		}
	}

	public String entradaValorSaque() {
		out.print("Entre com o valor:");

		return scanner.next();
	}

	public void saqueEfetuado() {
		out.println("Saque Efetuado!");
	}

	public String depositar() {
		out.print("Entre com o valor:");

		return scanner.next();
	}

	public void depositoEfetuado() {
		out.println("Deposito Efetuado!");
	}

	public String investir() {
		out.print("Entre com a taxa: (%)");

		return scanner.next();
	}

	public void investimentoEfetuado() {
		out.println("Investimento Efetuado!");
	}

	public void saldo(String saldo) {
		out.println("Saldo: " + saldo);
	}

	public void saldoInsuficiente() {
		err.println("Saldo insuficiente.");
	}

	public void clienteNaoCadastrado() {
		err.println("Não há cliente cadastrado.");
	}
}