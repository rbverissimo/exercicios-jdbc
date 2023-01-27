package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirVariasPessoas {
	public static void main(String[] args) throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		Scanner entrada = new Scanner(System.in); 
		
		String deleteSQL = "delete from pessoas where codigo > ?"; 
		
		System.out.println("Passe o c�digo a partir do "
				+ "qual registros a ser�o excluidos ");
		int codigo = entrada.nextInt();
		entrada.nextLine();
		
		PreparedStatement stmt = conexao.prepareStatement(deleteSQL);
		stmt.setInt(1, codigo);
		
		int contador = stmt.executeUpdate();
		
		if (contador > 0) {
			System.out.println("Altera��o conclu�da com sucesso!!");
			
		} else {
			System.out.println("Altera��o falhou!! ");
		}
		
		System.out.println("Linhas afetadas: " + contador);
		
		
		stmt.close();
		conexao.close();
		entrada.close();
		
	}

}
