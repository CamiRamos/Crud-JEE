package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private String nombreBD = "persona";
	private String user = "root";
	private String password = "";
	private String url = "jdbc:mysql://localhost/"+nombreBD;
	
	Connection conn=null;
	
	public Conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");//se llama al Driver a utilizar
			
			conn = DriverManager.getConnection(url, user, password);
			
			if(conn!=null) {//valia la conexion a la BD
				System.out.println("Conexion a BD exitosa: "+nombreBD);
			}
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Ocurre una ClassNotFoundException: "+e.getMessage());
			
		} catch (SQLException e) {
			System.out.println("Ocurre una SQLException: "+e.getMessage());
		}
	}
	
	public Connection getConnection() {
		return conn;//retorna si la conexion fue buena o mala
	}
	
	public void desconectar() {
		conn=null;//se desconecta de la BD
	}
}
