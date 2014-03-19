package com.senac.agenda.controller;

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

	public void gerarInformacoesAleatorias(int quantPessoas) {

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

		this.pessoas = new Pessoa[quantPessoas];
		int cont = 0;

		randomizaArray(nomes);
		randomizaArray(sobrenomes);

		for (String nome : nomes) {
			for (String sobrenome : sobrenomes) {
				this.pessoas[cont] = new Pessoa();

				this.pessoas[cont].setNome(nome + " " + sobrenome);
				this.pessoas[cont].setTelefone("", "", "");
				this.pessoas[cont].setEndereco("");

				cont ++;
				// se esgotar as posições encerra a função
				if (cont == quantPessoas) return;
			}
		}
	}


	static void randomizaArray(String[] array)
	{
		Random rnd = new Random();
		for (int i = array.length - 1; i > 0; i--)
		{
			int index = rnd.nextInt(i + 1);

			String temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}
}
