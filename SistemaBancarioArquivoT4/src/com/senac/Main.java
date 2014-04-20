package com.senac;

import static java.lang.System.*;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		com.senac.banco.App appBanco = new com.senac.banco.App();
		com.senac.contato.App appContato = new com.senac.contato.App();

		do {
			out.println(
					"Escolha o sitema:"
					+ "\n1 - Contatos"
					+ "\n2 - Banco"
					+ "\nS - Sair"
			);

			switch (scanner.next().toUpperCase()) {
				case "1":
					appContato.run();
					break;

				case "2":
					appBanco.run();
					break;

				case "S":
					exit(0);
					break;

				default:
					err.println("Opção Inválida!");
					break;
			}
		} while (true);
	}
}