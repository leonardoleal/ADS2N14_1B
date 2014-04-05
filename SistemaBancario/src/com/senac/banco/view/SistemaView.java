package com.senac.banco.view;

import static java.lang.System.out;
import static java.lang.System.err;
import java.util.Scanner;

public class SistemaView {
	private static Scanner scanner = new Scanner(System.in);

	public String menuPrincipal() {
		out.println(
				"Digite a opção desejada:"
				+ "\n1 - Cadastar Conta"
				+ "\n2 - Transações Conta"
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
				"Digite a opção desejada:"
				+ "\nC - Conta Comum"
				+ "\nE - Conta Especial"
				+ "\nI - Conta Investimento"
		);

		return scanner.next();
	}

	public int entradaNumeroConta() {
		out.print("Digite o número da conta: ");

	    return this.lerNumIntPos();
	}

	public double entradaSaldo() {
		out.print("Entre com o saldo inicial: ");

	    return this.lerNumDoubPos();
	}

	public double entradaLimite() {
		out.print("Entre com o limite de crédito: ");

	    return this.lerNumDoubPos();
	}

	public void cadastroEfetuado(String numConta, String numVerificacao) {
		out.println("Conta cadastrada! \nConta nº: " + numConta + "-" + numVerificacao);
	}

	public String menuTransacoesConta() {
		out.println(
				"Digite a opção desejada:"
				+ "\n1 - Sacar"
				+ "\n2 - Depositar"
				+ "\n3 - Investimento"
				+ "\n4 - Saldo"
				+ "\nV - Voltar"
		);

		return scanner.next();
	}

	public double entradaValorSaque() {
		out.println("Entre com o valor: ");

	    return this.lerNumIntPos();
	}

	public void saqueEfetuado() {
		out.println("Saque Efetuado!");
	}

	public double entradaValorDeposito() {
		out.print("Entre com o valor: ");

	    return this.lerNumDoubPos();
	}

	public void depositoEfetuado() {
		out.println("Deposito Efetuado!");
	}

	public double entradaTaxaDividendo() {
		out.print("Entre com a taxa: (%) ");

	    return this.lerNumDoubPos();
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

	public void exibeDataCriacao(String dataCriacao) {
		out.println("Data Cricação: " + dataCriacao);
	}

	public void saldoInsuficiente() {
		err.println("Saldo insuficiente.");
	}

	public void clienteNaoCadastrado() {
		err.println("Não há cliente cadastrado.");
	}

	public void msgBoasVindas() {
		System.out.println("Seja bem vindo ao Sistema Bancário!");
	}

	public void msgEncerrando() {
		out.println("Fechando o sistema!\n  See you! :D");

		System.exit(0);
	}

	public void msgOpInvalida() {
		err.println("Opção inválida...");
	}

	public void msgOpInexistente() {
		err.println("Operação inexistente para este tipo de conta.");
	}

	public void msgValorInvalido() {
		// err sai primeiro no console do eclipse, com arquivo jar não acontece
		err.println("Valor inválido para esta operação.");
		out.print("Tente novamente: ");
	}

	public int lerNumIntPos() {
        int num;

        do {
            while (!scanner.hasNextInt()) {
                scanner.next();
                this.msgValorInvalido();
            }

            num = scanner.nextInt();

            if (num <= 0) {
            	this.msgValorInvalido();
            	continue;
			}

            break;
        } while (true);

        return num;
	}

	public double lerNumDoubPos() {
        double num;

        do {
            while (!scanner.hasNextDouble()) {
                scanner.next();
                this.msgValorInvalido();
            }

            num = scanner.nextDouble();

            if (num <= 0) {
            	this.msgValorInvalido();
            	continue;
			}

            break;
        } while (true);

        return num;
	}
}