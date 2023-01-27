package jdbc;

import java.util.Scanner;

public class NovaPessoa {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe o nome: ");
		String nome = entrada.nextLine();
		
		String sql = "INSERT INTO pessoas(nome) values ('" + nome + "')";
		
		entrada.close();
	}

}
