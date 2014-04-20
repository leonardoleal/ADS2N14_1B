package com.senac.contato;

import com.senac.contato.controller.PessoaController;

public class App {
	private String nomeArquivo;
	private PessoaController pessoaC;

	public App() {
		this.nomeArquivo = "./data/contatos.dat";
	}

	public String getNomeArquivo() {
		return this.nomeArquivo;
	}

	public void run() {
		this.run(this.nomeArquivo);
	}

	public void run(String nomeArquivo) {
		pessoaC = new PessoaController();

		if (!pessoaC.fileExists(nomeArquivo)) {
			pessoaC.gerarInformacoesAleatorias();
			pessoaC.gerarArquivoInformacoesPessoas(nomeArquivo);
		} else {
			pessoaC.motrarMsgArquivoExiste();
		}
	}
}