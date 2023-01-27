package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlterarNomePessoa {
	
	public static void main(String[] args) throws SQLException{
		
		Connection conexao = FabricaConexao.getConexao();
		Scanner entrada = new Scanner(System.in); 
		
		System.out.println("Digite o código da pessoa para atualizar: ");
		int codigo = entrada.nextInt();
		
		String select = "SELECT codigo, nome FROM pessoas where codigo = ?";
		String update = "update pessoas set nome = ? where codigo = ?"; 
		
		
		PreparedStatement stmt = conexao.prepareStatement(select);
		stmt.setInt(1, codigo);
		ResultSet r = stmt.executeQuery();
		
		// List<Pessoa> pessoas = new ArrayList<>();
		
		if(r.next()) {
			Pessoa p = new Pessoa(r.getInt(1), r.getString(2));
			System.out.println("O nome atual é: " + p.getNome());
			entrada.nextLine();
			System.out.println("Informe o novo nome: ");
			String novoNome = entrada.nextLine(); 
			
			stmt.close();
			stmt = conexao.prepareStatement(update); 
			stmt.setString(1, novoNome);
			stmt.setInt(2, codigo);
			stmt.execute();
			
			System.out.println("Alteração concluída com sucesso!!");
			
		}
		
		
		stmt.close();
		conexao.close();
		entrada.close();
	}

}
