package com.senac.contato.view;

import static java.lang.System.*;

public class ContatoView {

	public void printContato(String nome, String telefone, String endereco) {
		out.println("Nome: " + nome);
		out.println("Telefones: " + telefone);
		out.println("Endereço: " + endereco);
		out.println("-----------------------------");
	}
	
	public void showMsgArquivoGerado() {
		out.println("Aquivo gerado com sucesso!");
	}

	public void showMsgArquivoExiste() {
		err.println("Aquivo já existe!\nNão foi gerado o novo arquivo.");
	}
}