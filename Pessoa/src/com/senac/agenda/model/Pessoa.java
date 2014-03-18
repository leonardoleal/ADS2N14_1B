package com.senac.agenda.model;

import java.util.ArrayList;
import java.util.List;


public class Pessoa {

	private String nome;
	private String endereco;
	private List<Telefone> telefone;

	public Pessoa() {
		this.telefone = new ArrayList<Telefone>();
	}
}
