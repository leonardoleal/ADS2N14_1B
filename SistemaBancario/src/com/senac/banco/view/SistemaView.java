package com.senac.banco.view;

import static java.lang.System.out;
import static java.lang.System.err;
import java.util.Scanner;

import com.senac.banco.controller.ContaController;

public class SistemaView {
	private static String opcao;
	private static Scanner scanner = new Scanner(System.in);

	public static void iniciar() {
		out.println("Seja bem vindo ao Sistema Banc�rio!");

		SistemaView.menuPrincipal();
	}

	public static void encerrar() {
		out.println("Fechando o sistema!\n  See you! :D");

		System.exit(0);
	}

	public static void mensagemOpInvalida() {
		err.println("Op��o inv�lida...");
	}

	public static void menuPrincipal() {
		ContaController controller = new ContaController();

		do {
			out.println(
					"Digite a op��o desejada:"
					+ "\n1 - Cadastar Conta"
					+ "\n2 - Transa��es Conta"
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