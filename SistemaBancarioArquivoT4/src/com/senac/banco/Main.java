package com.senac.banco;

import com.senac.agenda.controller.PessoaController;
import com.senac.banco.controller.ContaController;

public class Main {

	public static void main(String[] args) {
		ContaController contaC = new ContaController();
		PessoaController pessoaC = new PessoaController();
		String nomeArquivo = "./data/contatos.dat";

		try {
			// cria arquivo de contatos caso não exista
			if (!pessoaC.fileExists(nomeArquivo)) {
				pessoaC.gerarInformacoesAleatorias();
				pessoaC.gerarArquivoInformacoesPessoas(nomeArquivo);
			}
		} finally {
			pessoaC = null;
		}

		do {
			contaC.iniciarSistema();
		} while (true);
	}
}