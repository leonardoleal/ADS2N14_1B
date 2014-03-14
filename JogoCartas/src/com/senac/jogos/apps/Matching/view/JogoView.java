package com.senac.jogos.apps.Matching.view;

import java.util.Scanner;
import static java.lang.System.*;
import com.senac.jogos.apps.Matching.controller.JogoController;

public class JogoView {

	private static Scanner teclado = new Scanner(System.in);
	private static JogoController controller;
	
	public static void main(String[] args)
	{
		controller = new JogoController();
		out.print("Insira a quantidade de jogadores: (1-4) ");

		while (controller.validateNumJogadores(teclado.nextInt())) {
			out.print("Valor inválido, insira novamente: (1-4) ");
		}
		

		while (controller.checkFimJogo()) {
			clearConsole();

			out.println("Turno JOGADOR " + controller.getNomeJogador());
			out.println("Carta na mesa: " + controller.showMesa());

			out.println("Digite 'jogar' para jogar,"
					+ "'pular' para passar a vez e"
					+ "'pontos' para visualizar a sua pontuação: "
			);
			String comando = teclado.next();

			if (comando.equalsIgnoreCase("PONTOS")) {
				out.println(controller.showJogador());
				continue;
			} else if (comando.equalsIgnoreCase("PULAR")) {
				if (!controller.passTurno()) {
					out.print("Você já pulou a rodada anterior e"
							+ "não é possível pular duas vezes seguidas."
					);
					continue;
				}
			} else {
				out.println("Carta do jogador: " + controller.showCartaJogador());
				controller.playTurno();
			}

			controller.nextJogador();
		}

		out.println(controller.showVencedor());
	}

	private static void clearConsole()
	{
	    try {
	        String os = System.getProperty("os.name");

	        if (os.contains("Windows")) {
	            Runtime.getRuntime().exec("cls");
	        } else {
	            Runtime.getRuntime().exec("clear");
	        }
	    } catch (Exception exception) {}
	}
	
}
