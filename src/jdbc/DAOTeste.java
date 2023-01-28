package jdbc;

public class DAOTeste {
	
	public static void main(String[] args) {
		DAO dao = new DAO();
		
		String sql = "insert into pessoas (nome) values (?)"; 
		dao.incluir(sql, "Jurema Cabloco");
		dao.incluir(sql, "Rangevélio Nicoliro");
		dao.incluir(sql, "Jamambreiro do Jamombra"); 
		
		dao.close();
	}

}
