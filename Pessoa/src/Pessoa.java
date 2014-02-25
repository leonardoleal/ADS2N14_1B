
public class Pessoa {

	private String nome;
	private String sexo;
	private int idade;

	public Pessoa(){
		this("", "", 0);
	}

	public Pessoa(String nome, String sexo, int idade){
		this.nome = nome;
		this.sexo = sexo;
		this.idade = idade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setSexo(String sexo) {
		sexo = this.validaSexo(sexo);

		if (sexo != null) {
			this.sexo = sexo;
		} else {
			throw new IllegalArgumentException("O \"Sexo\" não foi reconhecido.");
		}
	}

	public String getSexo() {
		return sexo;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getIdade() {
		return idade;
	}

	public String validaSexo(String sexo) {
		if (sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("Masculino")){
			sexo = "M";
		}else if(sexo.equalsIgnoreCase("F")|| sexo.equalsIgnoreCase("Feminino")){
			sexo = "F";
		} else {
			sexo = null;
		}

		return sexo;
	}
}
