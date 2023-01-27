package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarPessoa {
	
	public static void main(String[] args) throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o nome a ser atualizado: ");
		String nome = entrada.nextLine(); 
		// existe um bug no nextInt; 
		System.out.println("Digite o ID a ser atualizado: ");
		int codigo = entrada.nextInt();
		
		String sql = "update pessoas set nome = ? where codigo = ?"; 
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.setInt(2, codigo);
		stmt.executeUpdate(); 
		
		System.out.println("Atualização feita com sucesso!");
		
		stmt.close();
		conexao.close();
		entrada.close();
		
	}

}
