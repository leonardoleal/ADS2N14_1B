package com.senac.agenda.view;

import static java.lang.System.out;

public class ContatoView {

	public void printContato(String nome, String telefone, String endereco)
	{
		out.println("Nome: " + nome);
		out.println("Telefones: " + telefone);
		out.println("Endereço: " + endereco);
	}
}
