package com.senac.banco;

import com.senac.banco.controller.ContaController;

public class Main {

	public static void main(String[] args) {
		ContaController controller = new ContaController();

		do {
			controller.iniciarSistema();
		} while (true);
	}
}