package com.senac.agenda;

import com.senac.agenda.controller.PessoaController;

public class App {

	public static void main(String[] args) {
		PessoaController controller = new PessoaController();
		controller.gerarInformacoesAleatorias();
		controller.mostrarInformacoesPessoas();
	}
} 
