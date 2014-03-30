package com.senac.banco.controller;

import com.senac.banco.exception.SaldoInsuficiente;
import com.senac.banco.model.*;
import com.senac.banco.view.SistemaView;

public class ContaController {
	SistemaView sistemaV;
	Cliente cliente;

	public ContaController() {
		this.sistemaV = new SistemaView();
		cliente = null;
	}

	public void iniciarSistema() {
		String opcao = sistemaV.menuPrincipal();

		switch (opcao.toUpperCase()) {
			case "1":
				this.cadastrarConta();
				break;

			case "2":
				this.transacoesConta();
				break;

			case "S":
				sistemaV.encerrar();
				break;

			default:
				sistemaV.mensagemOpInvalida();
				break;
		}
	}

	public void cadastrarConta() {
		Conta conta = null;
		String nome = sistemaV.entradaNome();

		boolean continuar = true;
		do {
			String tipoConta = sistemaV.menuTipoConta();
			
			switch (tipoConta.toUpperCase()) {
				case "C":
					conta = this.cadastrarContaComum();
					continuar = false;
					break;

				case "E":
					conta = this.cadastrarContaEspecial();
					continuar = false;
					break;

				case "I":
					conta = this.cadastrarContaInvestimento();
					continuar = false;
					break;

				default:
					sistemaV.mensagemOpInvalida();
					break;
			}
		} while (continuar);

		this.cliente = new Cliente(nome, conta);

		sistemaV.cadastroEfetuado(
				Integer.toString(this.cliente.getConta().getNumConta())
				,Integer.toString(this.cliente.getConta().getNumVerificacao())
		);
	}

	public Conta cadastrarContaComum() {
		int numConta = Integer.parseInt(sistemaV.entradaNumeroConta());
		double saldo = Double.parseDouble(sistemaV.entradaSaldo());

		Conta conta = new Conta(numConta, saldo);

		return conta;
	}

	public Conta cadastrarContaEspecial() {
		int numConta = Integer.parseInt(sistemaV.entradaNumeroConta());
		double saldo = Double.parseDouble(sistemaV.entradaSaldo());
		double limite = Double.parseDouble(sistemaV.entradaLimite());

		Especial conta = new Especial(numConta, saldo, limite);

		return conta;
	}

	public Conta cadastrarContaInvestimento() {
		int numConta = Integer.parseInt(sistemaV.entradaNumeroConta());
		double saldo = Double.parseDouble(sistemaV.entradaSaldo());

		Investimento conta = new Investimento(numConta, saldo);

		return conta;
	}

	public void transacoesConta() {
		if (this.cliente == null) {
			sistemaV.clienteNaoCadastrado();

			return;
		}

		String opcao = sistemaV.menuTransacoesConta();

		switch (opcao.toUpperCase()) {
			case "1":
				this.sacar();
				break;

			case "2":
				this.depositar();
				break;

			case "3":
				this.investir();
				break;

			case "4":
				this.consultarSaldo();
				break;

			case "S":
				sistemaV.encerrar();
				break;

			default:
				sistemaV.mensagemOpInvalida();
				break;
		}
	}

	public void sacar() {
		double valorSaque = Double.parseDouble(sistemaV.entradaValorSaque());

		try {
			this.cliente.getConta().sacar(valorSaque);
			sistemaV.saqueEfetuado();
		} catch (SaldoInsuficiente sf) {
			sistemaV.saldoInsuficiente();
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.getStackTrace();
		}
	}

	public void depositar() {
		sistemaV.depositoEfetuado();
	}

	public void investir() {
		sistemaV.investimentoEfetuado();
	}

	public void consultarSaldo() {
		sistemaV.saldo(this.cliente.getConta().getSaldo());
	}
}