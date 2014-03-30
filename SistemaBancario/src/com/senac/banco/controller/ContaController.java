package com.senac.banco.controller;

import com.senac.banco.exception.SaldoInsuficiente;
import com.senac.banco.model.Conta;
import com.senac.banco.model.Especial;
import com.senac.banco.model.Investimento;
import com.senac.banco.model.Cliente;
import com.senac.banco.view.ContaView;
import com.senac.banco.view.SistemaView;

public class ContaController {
	ContaView contaV;
	Cliente cliente;

	public ContaController() {
		this.contaV = new ContaView();
		this.cliente = null;
	}

	public void cadastrarConta() {
		Conta conta = null;
		String nome = contaV.entradaNome();

		boolean continuar = true;
		do {
			String tipoConta = contaV.menuTipoConta();
			
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
					SistemaView.mensagemOpInvalida();
					break;
			}
		} while (continuar);

		this.cliente = new Cliente(nome, conta);

		contaV.cadastroEfetuado(
				Integer.toString(this.cliente.getConta().getNumConta())
				,Integer.toString(this.cliente.getConta().getNumVerificacao())
		);
	}

	public Conta cadastrarContaComum() {
		int numConta = Integer.parseInt(contaV.entradaNumeroConta());
		double saldo = Double.parseDouble(contaV.entradaSaldo());

		Conta conta = new Conta(numConta, saldo);

		return conta;
	}

	public Conta cadastrarContaEspecial() {
		int numConta = Integer.parseInt(contaV.entradaNumeroConta());
		double saldo = Double.parseDouble(contaV.entradaSaldo());
		double limite = Double.parseDouble(contaV.entradaLimite());

		Especial conta = new Especial(numConta, saldo, limite);

		return conta;
	}

	public Conta cadastrarContaInvestimento() {
		int numConta = Integer.parseInt(contaV.entradaNumeroConta());
		double saldo = Double.parseDouble(contaV.entradaSaldo());

		Investimento conta = new Investimento(numConta, saldo);

		return conta;
	}

	public void transacoesConta() {
		if (this.cliente == null) {
			contaV.clienteNaoCadastrado();

			return;
		}

		contaV.menuTransacoesConta();
	}

	public void sacar() {
		double valorSaque = Double.parseDouble(contaV.entradaValorSaque());

		try {
			this.cliente.getConta().sacar(valorSaque);
			contaV.saqueEfetuado();
		} catch (SaldoInsuficiente sf) {
			contaV.saldoInsuficiente();
		}
	}

	public void depositar() {
		contaV.depositoEfetuado();
	}

	public void investir() {
		contaV.investimentoEfetuado();
	}

	public void consultarSaldo() {
		contaV.saldo("12,90");
	}
}