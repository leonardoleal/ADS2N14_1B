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
			out.println(
					"Carta na mesa: " + controller.showMesa()
			);

			out.print("Digite 'jogar' para jogar, 'pular' para passar a vez: ");
			
			String comando = teclado.next();
			if (comando.equalsIgnoreCase("JOGAR")) {
				out.println(
						"Carta do jogador: " + controller.showCartaJogador()
				);
				controller.playTurno();
			} else {
				controller.passTurno();
			}
			
			out.println(controller.showJogador());

			controller.nextJogador();
		}
	}
	
}
