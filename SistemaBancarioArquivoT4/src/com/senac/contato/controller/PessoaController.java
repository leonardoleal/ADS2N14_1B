package com.senac.contato.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import com.senac.contato.model.Pessoa;
import com.senac.contato.view.ContatoView;

public class PessoaController {

	private Pessoa[] pessoas;
	private ContatoView contatoView;

	public PessoaController() {
		contatoView = new ContatoView();
	}

	public void mostrarInformacoesPessoas() {
		String telefones;
		int quantTelefones = 0;

		for (Pessoa pessoa : this.pessoas) {
			// caso haja mais de um telefone cadastrado, os exibe
			quantTelefones = pessoa.getTelefones().size();
			telefones = "";
			for (int i= 0; i < quantTelefones; i++) {
				telefones += "\n\t" + pessoa.getTelefones().get(i).getTipo() + ": " +
						"(" + pessoa.getTelefones().get(i).getCodigo() + ") " +
						pessoa.getTelefones().get(i).getNumero()
				;
			}

			this.contatoView.printContato(
					pessoa.getNome(),
					telefones,
					pessoa.getEndereco()
			);
		}
	}

	public void gerarArquivoInformacoesPessoas(String nomeArquivo) {
		BufferedWriter bufferedOutput = null;
		String telefones;
		int quantTelefones = 0;
        
        try {
            bufferedOutput = new BufferedWriter(
			            		new OutputStreamWriter(
			            				new FileOutputStream(nomeArquivo, true)
			            				, "UTF-8"
			            		)
            );
            
    		for (Pessoa pessoa : this.pessoas) {
    			// caso haja mais de um telefone cadastrado, os exibe
    			quantTelefones = pessoa.getTelefones().size();
    			telefones = "";
    			for (int i= 0; i < quantTelefones; i++) {
    				telefones += "$" + pessoa.getTelefones().get(i).getTipo() + ": " +
    						"(" + pessoa.getTelefones().get(i).getCodigo() + ") " +
    						pessoa.getTelefones().get(i).getNumero()
    				;
    			}

    			bufferedOutput.write( pessoa.getNome() );

    			bufferedOutput.write( "#" );
    			bufferedOutput.write( telefones );

    			bufferedOutput.write( "#" );
    			bufferedOutput.write( pessoa.getEndereco() );

    			bufferedOutput.newLine();
    		}

    		contatoView.showMsgArquivoGerado();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bufferedOutput != null) {
                    bufferedOutput.flush();
                    bufferedOutput.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
	}

	public void gerarInformacoesAleatorias() {
		int quantPessoas = 20;
		this.pessoas = new Pessoa[quantPessoas];

		for (int i = 0; i < quantPessoas; i++) {
			this.pessoas[i] = new Pessoa();

			this.pessoas[i].setNome(this.gerarNome());
			this.pessoas[i].setEndereco(this.gerarEndereco());
			this.pessoas[i].setTelefone(
					this.gerarTipoTelefone(),
					this.gerarCodigoAreaTelefone(),
					this.gerarNumeroTelefone()
			);
			this.pessoas[i].setTelefone(
					this.gerarTipoTelefone(),
					this.gerarCodigoAreaTelefone(),
					this.gerarNumeroTelefone()
			);
		}
	}

	private String gerarNome() {
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

		return nomes[0] + " " + sobrenomes[0];
	}

	private String gerarTipoTelefone() {
		String tiposTel[] = {
				"Res.", "Cel.", "Trab.",
		};

		Collections.shuffle(Arrays.asList(tiposTel));

		return tiposTel[0];
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
		// cria array de nomes e embaralha
		String tipo[] = {
				"Alameda", "Avenida", "Campo", "Chácara", "Colônia", "Condomínio", "Conjunto",
				"Distrito", "Esplanada", "Estação", "Estrada", "Favela", "Loteamento", "Morro",
				"Parque", "Praça", "Residencial", "Rodovia", "Rua", "Sítio", "Travessa", "Vale"
		};

		String logradouro[] = {
				"Nossa Senhora", "Brasil", "Paulista",
				"Veira", "dos Ministerios", "25", 
				"Brigadeiro", "Rio" 
		};

		String compLogradouro[] = {
				"de Copacabana", "Souto", "",
				"de Março", "Faria Lima", "Branco"
		};

		Collections.shuffle(Arrays.asList(tipo));
		Collections.shuffle(Arrays.asList(logradouro));
		Collections.shuffle(Arrays.asList(compLogradouro));

		return tipo[0] + " " + logradouro[0] + " " + compLogradouro[0];
	}

	public boolean fileExists(String nomeArquivo) {
		File f = new File(nomeArquivo);

		if (f.exists() && !f.isDirectory()) {
			return true;
		} else {
			return false;
		}
	}

	public void motrarMsgArquivoExiste() {
		contatoView.showMsgArquivoExiste();
	}
}
