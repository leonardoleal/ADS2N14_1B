package com.senac.agenda.controller;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import com.senac.agenda.model.Pessoa;
import com.senac.agenda.view.ContatoView;

public class PessoaController {

	private Pessoa[] pessoas;

	public PessoaController() {}

	public void mostrarInformacoesPessoas() {
		
		ContatoView contatoView = new ContatoView();
		String telefones = "";
		int quantTelefones = 0;

		for (Pessoa pessoa : this.pessoas) {
			
			quantTelefones = pessoa.getTelefones().size();
			for (int i= 0; i < quantTelefones; i++) {
				telefones = pessoa.getTelefones().get(i).getTipo() + ": " +
						"(" + pessoa.getTelefones().get(i).getCodigo() + ") " +
						pessoa.getTelefones().get(i).getNumero()
				;
			}

			contatoView.printContato(
					pessoa.getNome(),
					telefones,
					pessoa.getEndereco()
			);
		}
	}

	public void gerarInformacoesAleatorias() {
		int cont = 0;
		int quantPessoas = 50;
		this.pessoas = new Pessoa[quantPessoas];

		// cria array de nomes e embaralha
		String nomes[] = {
				"João", "Maria", "José",
				"Matheus", "Jesus", "Abraão",
				"Madalena", "Cain", "Abel", "Noé",
				"Baby", "Eva", "Dino", "Leonardo"
		};

		String sobrenomes[] = {
				"da Silva", "de Deus", "dos Anjos",
				"dos Santos", "dos Reis", "Silva Sauro", "Leal"
		};

		Collections.shuffle(Arrays.asList(nomes));
		Collections.shuffle(Arrays.asList(sobrenomes));

		for (String nome : nomes) {
			for (String sobrenome : sobrenomes) {
				this.pessoas[cont] = new Pessoa();

				this.pessoas[cont].setNome(nome + " " + sobrenome);
				this.pessoas[cont].setEndereco(this.gerarEndereco());
				this.pessoas[cont].setTelefone(
						this.gerarTipoTelefone(),
						this.gerarCodigoAreaTelefone(),
						this.gerarNumeroTelefone()
				);

				cont ++;
				// se esgotar as posições encerra a função
				if (cont == quantPessoas) {
					Collections.shuffle(Arrays.asList(this.pessoas));
					return;
				}
			}
		}
	}

	private String gerarTipoTelefone() {
		Random rand = new Random();

		return "";
	}

	private String gerarCodigoAreaTelefone() {
		Random rand = new Random();
		
		return String.format("%d%d", rand.nextInt(9)+1, rand.nextInt(10));
	}

	private String gerarNumeroTelefone() {
		Random rand = new Random();

		return String.format("%d%02d-%04d", rand.nextInt(9)+1, rand.nextInt(100), rand.nextInt(10000));
	}

	private String gerarEndereco() {
		Random rand = new Random();

		return "";
	}
}
