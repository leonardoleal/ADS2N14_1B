import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		Scanner scanner = new Scanner(System.in);

		try{
			System.out.println("Digite o seu nome: ");
			pessoa.setNome(scanner.next());

			System.out.println("Informe o seu sexo (M/F): ");
			pessoa.setSexo(scanner.next());

			System.out.println("Informe seu idade: ");
			pessoa.setIdade(scanner.nextInt());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("Sexo: " + pessoa.getSexo());
		System.out.println("Idade: " + pessoa.getIdade() + " anos");
} 
