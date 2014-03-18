package com.senac.agenda.model;

public class Telefone {
	
	private String tipo;
	private String codigo;
	private String numero;
	
	public Telefone(String tipo, String codigo, String numero) {
		this.tipo = tipo;
		this.codigo = codigo;
		this.numero = numero;
	}

	public String getTipo() {
		return this.tipo;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getNumero() {
		return this.numero;
	}
}
