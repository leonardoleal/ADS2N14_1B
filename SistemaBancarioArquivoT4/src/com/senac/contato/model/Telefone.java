package com.senac.contato.model;

public class Telefone {
	
	private String tipo;
	private String codigo;
	private String numero;
	
	public Telefone(String tipo, String codigo, String numero) {
		this.tipo = tipo;
		this.codigo = codigo;
		this.numero = numero;
	}

	public Telefone() {
		this.tipo = "";
		this.codigo = "";
		this.numero = "";
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
