package com.senac.banco;


import com.senac.banco.controller.ContaController;

public class Main {

	public static void main(String[] args) {
		System.out.println("Seja bem vindo ao Sistema Bancário!");

		ContaController controller = new ContaController();

		do {
			controller.iniciarSistema();
		} while (true);
	}
}