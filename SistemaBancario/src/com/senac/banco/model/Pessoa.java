package com.senac.banco.model;

import java.util.ArrayList;
import java.util.List;


public class Pessoa {

	private String nome;
	private String endereco;
	private List<Telefone> telefones;

	public Pessoa() {
		this.telefones = new ArrayList<Telefone>();
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Telefone> getTelefones() {
		return this.telefones;
	}

	public void setTelefone(String tipo, String codigo, String numero) {
		this.telefones.add(new Telefone(tipo, codigo, numero));
	}
}