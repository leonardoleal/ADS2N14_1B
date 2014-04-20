package com.senac.banco.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.senac.banco.exception.SaldoInsuficiente;
import com.senac.banco.model.Cliente;
import com.senac.banco.model.Conta;
import com.senac.banco.model.Especial;
import com.senac.banco.model.Investimento;
import com.senac.banco.view.SistemaView;

public class ContaController {
	private String nomeArquivoContatos;
	private String nomeArquivoContas;
	private SistemaView sistemaV;
	private Cliente cliente;

	public ContaController() {
		this.sistemaV = new SistemaView();
		cliente = null;

		this.sistemaV.msgBoasVindas();
	}

	public void iniciarSistema(String nomeArquivoContas, String nomeArquivoContatos) {
		if (!this.fileExists(nomeArquivoContatos)) {
			sistemaV.showMsgArquivoInexistente("\"Contatos\"");

			return;
		}

		this.nomeArquivoContatos = nomeArquivoContatos;
		this.nomeArquivoContas = nomeArquivoContas;

		if (!this.fileExists(nomeArquivoContas)) {
			this.cadastrarContaContatos();
		}

		this.transacoesContaContatos();
	}

	public void cadastrarContaContatos() {
		BufferedReader arquivoContato = null;

		try {
			arquivoContato = new BufferedReader(new FileReader(this.nomeArquivoContatos));

			String linha;
			String dados[];

			while ((linha = arquivoContato.readLine()) != null) {
				dados = linha.split("#");
				cadastrarConta(dados[0], true);
			}

			sistemaV.showMsgArquivoGerado();
        } catch (FileNotFoundException e1) {
        	e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (arquivoContato != null) {
					arquivoContato.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void cadastrarConta(String nome, boolean toFile) {
		Conta conta = null;

		if (nome.isEmpty()) {
			nome = sistemaV.entradaNome();
		} else {
			sistemaV.exibeNomeCliente(nome);
		}

		//cadastrar conta para cada cliente no arquivo
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
					sistemaV.msgOpInvalida();
					break;
			}
		} while (continuar);

		this.cliente = new Cliente(nome, conta);

		if (toFile) {
			this.escreveArquivoContas();
		}

		sistemaV.cadastroEfetuado(
				Integer.toString(this.cliente.getConta().getNumConta())
				,Integer.toString(this.cliente.getConta().getNumVerificacao())
		);
	}

	public Conta cadastrarContaComum() {
		int numConta = sistemaV.entradaNumeroConta();
		double saldo = sistemaV.entradaSaldo();

		Conta conta = new Conta(numConta, saldo);

		return conta;
	}

	public Conta cadastrarContaEspecial() {
		int numConta = sistemaV.entradaNumeroConta();
		double saldo = sistemaV.entradaSaldo();
		double limite = sistemaV.entradaLimite();

		Especial conta = new Especial(numConta, saldo, limite);

		return conta;
	}

	public Conta cadastrarContaInvestimento() {
		int numConta = sistemaV.entradaNumeroConta();
		double saldo = sistemaV.entradaSaldo();

		Investimento conta = new Investimento(numConta, saldo);

		return conta;
	}


	public void transacoesContaContatos() {
		BufferedReader arquivoContato = null;

		try {
			arquivoContato = new BufferedReader(new FileReader(this.nomeArquivoContas));

			String linha;
			String dados[];

			while ((linha = arquivoContato.readLine()) != null) {
				dados = linha.split("#");
				// criar objeto Cliente
				this.transacoesConta();
			}

			sistemaV.showMsgArquivoGerado();
        } catch (FileNotFoundException e1) {
        	e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (arquivoContato != null) {
					arquivoContato.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
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
				this.taxaDividendo();
				break;

			case "4":
				this.consultarSaldo();
				break;

			case "V":
				break;

			default:
				sistemaV.msgOpInvalida();
				break;
		}
	}

	public void sacar() {
		double valorSaque = sistemaV.entradaValorSaque();

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
		double valorDeposito = sistemaV.entradaValorDeposito();

		try {
			this.cliente.getConta().depositar(valorDeposito);
			sistemaV.depositoEfetuado();
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.getStackTrace();
		}
	}

	public void taxaDividendo() {
		try {
			if (this.cliente.getConta() instanceof Investimento) {
				double taxaDividendo = sistemaV.entradaTaxaDividendo();

				((Investimento) this.cliente.getConta()).dividendos(taxaDividendo);
				sistemaV.dividendoEfetuado();
			} else {
				sistemaV.msgOpInexistente();
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.getStackTrace();
		}
	}

	public void consultarSaldo() {
		sistemaV.exibeSaldo(
				this.cliente.getNome()
				, this.cliente.getConta().getNumConta()
				, this.cliente.getConta().getNumVerificacao()
				, this.cliente.getConta().getSaldo()
		);

		if (this.cliente.getConta() instanceof Especial) {
			sistemaV.exibeLimite(((Especial) this.cliente.getConta()).getLimite());
		} else if (this.cliente.getConta() instanceof Investimento) {
			try {
				Date dataNum;
				dataNum = new SimpleDateFormat("yyyyMMdd").parse(
						Integer.toString(((Investimento) this.cliente.getConta()).getDataCriacao())
				);
				String data = new SimpleDateFormat("dd/MM/yyyy").format(dataNum);
				sistemaV.exibeDataCriacao(data);
			} catch (Exception e) {}
		}
	}

	public boolean fileExists(String nomeArquivo) {
		File f = new File(nomeArquivo);

		if (f.exists() && !f.isDirectory()) {
			return true;
		} else {
			return false;
		}
	}

	private void escreveArquivoContas() {
          BufferedWriter arquivoContas = null;
        
        try {
        	arquivoContas = new BufferedWriter(
			        			new OutputStreamWriter(
			        					new FileOutputStream(this.nomeArquivoContas, true)
			        					, "UTF-8"
			        			)
            );

        	arquivoContas.write( this.cliente.getNome() );

        	arquivoContas.write( "#" );
        	arquivoContas.write( this.cliente.getConta().getClass().getSimpleName() );

        	arquivoContas.write( "#" );
			arquivoContas.write(
					Integer.toString(
							this.cliente.getConta().getNumConta()
					)
			);

			arquivoContas.write( "#" );
			arquivoContas.write(
					Integer.toString(
							this.cliente.getConta().getNumVerificacao()
					)
			);

			arquivoContas.write( "#" );
			arquivoContas.write(
					Double.toString(
							this.cliente.getConta().getSaldo()
					)
			);

			if (this.cliente.getConta() instanceof Especial) {
				arquivoContas.write( "#" );
				arquivoContas.write(
						Double.toString(
								((Especial) this.cliente.getConta()).getLimite()
								)
						);
			}

			arquivoContas.newLine();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (arquivoContas != null) {
                	arquivoContas.flush();
                	arquivoContas.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
		this.cliente.getConta().getNumConta();
	}
}