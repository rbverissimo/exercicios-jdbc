package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {
	public static void main(String[] args) throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		Scanner entrada = new Scanner(System.in); 
		
		String deleteSQL = "delete from pessoas where codigo = ?"; 
		String selectSQL = "select codigo, nome from pessoas where codigo = ?"; 
				
		
		System.out.println("Passe o código do registro a ser excluido ");
		int codigo = entrada.nextInt();
		entrada.nextLine();
		
		PreparedStatement stmt = conexao.prepareStatement(selectSQL);
		stmt.setInt(1, codigo);
		ResultSet r = stmt.executeQuery();
		
		
		if(r.next()) {
			Pessoa p = new Pessoa(r.getInt(1), r.getString(2));
			System.out.println("O nome do registro a ser excluído: " + p.getNome());
			stmt.close();
			stmt = conexao.prepareStatement(deleteSQL); 
			stmt.setInt(1, codigo);
			
			if (stmt.executeUpdate() > 0) {
				System.out.println("Alteração concluída com sucesso!!");	
				
			} else {
				System.out.println("Alteração falhou!! ");
			}
			
		}
		
		
		stmt.close();
		conexao.close();
		entrada.close();
		
	}

}
