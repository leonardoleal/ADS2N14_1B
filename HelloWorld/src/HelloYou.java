import java.util.Scanner;

public class HelloYou {
	private String userName;

	public HelloYou() {
		// n�o foi poss�vel testar na plataforma MAC. Ubuntu/Windows OK
		try {
			// Inicializa userName com o usu�rio logado no SO
			this.userName = System.getProperty("user.name");
		} catch (Exception e) {}
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		// caso user name n�o seja v�lido, solicita ao usu�rio que insira um nome
		if (this.userName == null || this.userName.isEmpty()) {
		    Scanner scanner = new Scanner (System.in);

		    System.out.println("Digite seu nome: ");
		    this.setUserName(scanner.next());

		    scanner.close();
		}

		return this.userName;
	}

	public String getMsgHello() {
		return "Hello " + this.getUserName() + "!";
	}

	public void printMsgHello() {
		System.out.println(this.getMsgHello());
	}
}