package com.senac.banco.view;

import static java.lang.System.out;
import static java.lang.System.err;
import java.util.Scanner;

import com.senac.banco.controller.ContaController;

public class SistemaView {
	private static String opcao;
	private static Scanner scanner = new Scanner(System.in);

	public static void iniciar() {
		out.println("Seja bem vindo ao Sistema Bancário!");

		SistemaView.menuPrincipal();
	}

	public static void encerrar() {
		out.println("Fechando o sistema!\n  See you! :D");

		System.exit(0);
	}

	public static void mensagemOpInvalida() {
		err.println("Opção inválida...");
	}

	public static void menuPrincipal() {
		ContaController controller = new ContaController();

		do {
			out.println(
					"Digite a opção desejada:"
					+ "\n1 - Cadastar Conta"
					+ "\n2 - Transações Conta"
					+ "\nS - Sair"
			);
			SistemaView.opcao = scanner.next();

			switch (SistemaView.opcao.toUpperCase()) {
				case "1":
					controller.cadastrarConta();
					break;

				case "2":
					controller.transacoesConta();
					break;

				case "S":
					SistemaView.encerrar();
					break;

				default:
					SistemaView.mensagemOpInvalida();
					
			}
		} while (true);
	}
}