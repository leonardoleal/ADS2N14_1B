package com.senac.banco;

import com.senac.banco.controller.ContaController;

public class App {
	private String nomeArquivoContatos;
	private String nomeArquivoContas;
	private ContaController contaC;

	public App() {
		this.nomeArquivoContatos = "./data/contatos.dat";
		this.nomeArquivoContas = "./data/contas.dat";
	}

	public String getNomeArquivoContas() {
		return nomeArquivoContas;
	}

	public void run() {
		this.run(this.nomeArquivoContas, this.nomeArquivoContatos);
	}

	public void run(String nomeArquivo, int numParam) {
		if (numParam == 0) {
			this.run(nomeArquivo, this.nomeArquivoContatos);
		} else {
			this.run(this.nomeArquivoContas, nomeArquivo);
		}
	}

	public void run(String nomeArquivoContas, String nomeArquivoContatos) {
		contaC = new ContaController();

		contaC.iniciarSistema(nomeArquivoContas, nomeArquivoContatos);
	}
}