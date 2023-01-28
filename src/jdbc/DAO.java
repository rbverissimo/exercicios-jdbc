package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class DAO {
	
	private Connection conexao;
	private Connection getConexao() {
		try {
			if(conexao != null && !conexao.isClosed()) {
				return conexao; 
			}
		} catch (SQLException e) {
			
		}
		
		conexao = FabricaConexao.getConexao();
		return conexao; 
	}

}
