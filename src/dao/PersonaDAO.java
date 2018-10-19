package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import vo.PersonaVO;

public class PersonaDAO {
	
	private String res="", consulta="";

	public String registrarPersona(PersonaVO personaVO) {
		System.out.println("Objeto persona: "+personaVO);
		Connection conn = null;
		PreparedStatement statement = null;
		Conexion conexion = new Conexion();
		
		conn = conexion.getConnection();
		
		consulta="INSERT INTO usuario(documento,nombre,edad,profesion,apellido,telefono,pass) VALUES(?,?,?,?,?,?,?)";
		
		try {
			
			statement = conn.prepareStatement(consulta);
			statement.setString(1, personaVO.getDocumento());
			statement.setString(2, personaVO.getNombre());
			statement.setInt(3, personaVO.getEdad());
			statement.setString(4, personaVO.getProfesion());
			statement.setString(5, personaVO.getApellidos());
			statement.setString(6, personaVO.getTelefono());
			statement.setString(7, personaVO.getPass());
			statement.execute();
			
			res="ok";
			
		} catch (SQLException e) {
			System.out.println("No se registro la persona: "+e.getMessage());
			res="error";
		}
		
		conexion.desconectar();
		
		return res;
	}

	public PersonaVO consultarUsuario(String documento) {
		Connection conn =null;
		PreparedStatement statement=null;
		Conexion conexion = new Conexion();
		ResultSet result = null;
		
		PersonaVO miPersona = null;
		
		conn = conexion.getConnection();
		consulta = "SELECT * FROM usuario WHERE documento = ?";
		
		try {
			
			statement = conn.prepareStatement(consulta);
			statement.setString(1, documento);
			result = statement.executeQuery();
			
			if(result.next()==true){
				System.out.println("Entra a la consulta y al if");
				miPersona = new PersonaVO();
				miPersona.setDocumento(result.getString("documento"));
				miPersona.setNombre(result.getString("nombre"));
				miPersona.setApellidos(result.getString("apellido"));
				miPersona.setEdad(result.getInt("edad"));
				miPersona.setProfesion(result.getString("profesion"));
				miPersona.setTelefono(result.getString("telefono"));
			}
			
			
			conexion.desconectar();
			
		} catch (SQLException e) {
			System.out.println("No se pudo consultar a la persona: "+e.getMessage());
		}
		
		return miPersona;
	}

	public String eliminarUsuario(String documento) {
		Connection conn = null;
		PreparedStatement statement = null;
		Conexion conexion = new Conexion();
		ResultSet result = null;
		
		conn = conexion.getConnection();
		
		consulta = "DELETE FROM usuario WHERE documento = ?";
		
		try {
			
			statement = conn.prepareStatement(consulta);
			statement.setString(1, documento);
			statement.execute();
			
			res="ok";
			
		} catch (SQLException e) {
			System.out.println("No se elimino la persona: "+e.getMessage());
			res="error";
		}
		return res;
	}

	public ArrayList<PersonaVO> consultarLista() {
		Connection conn=null;
		PreparedStatement statement = null;
		ResultSet result = null;
		Conexion conexion = new Conexion();
		
		PersonaVO personaVO = null;
		ArrayList<PersonaVO> listaUsuarios = new ArrayList<>();
		
		conn = conexion.getConnection();
		
		consulta = "SELECT * FROM usuario";
		
		try {
			
			statement = conn.prepareStatement(consulta);
			result = statement.executeQuery();
			
			while(result.next()){
				personaVO = new PersonaVO();
				personaVO.setDocumento(result.getString("documento"));
				personaVO.setNombre(result.getString("nombre"));
				personaVO.setApellidos(result.getString("apellido"));
				personaVO.setEdad(result.getInt("edad"));
				personaVO.setProfesion(result.getString("profesion"));
				personaVO.setTelefono(result.getString("telefono"));
				listaUsuarios.add(personaVO);
			}
			
			conexion.desconectar();
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta: "+e.getMessage());
		}
		
		return listaUsuarios;
	}

	public String editarPersona(PersonaVO miPersonaVo) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		Conexion conexion = new Conexion();
		
		conn = conexion.getConnection();
		
		consulta = "UPDATE usuario SET nombre=?,edad=?,profesion=?,apellido=?,telefono=? WHERE documento = ?";
		
		try {
			
			statement = conn.prepareStatement(consulta);
			statement.setString(1, miPersonaVo.getNombre());
			statement.setInt(2, miPersonaVo.getEdad());
			statement.setString(3, miPersonaVo.getProfesion());
			statement.setString(4, miPersonaVo.getApellidos());
			statement.setString(5, miPersonaVo.getTelefono());
			statement.setString(6, miPersonaVo.getDocumento());
			statement.executeUpdate();
			
			res = "ok";
			
		} catch (SQLException e) {
			System.out.println("Error al hacer la actualizacion: "+e.getMessage());
			res="error";
		}
		
		return res;
	}

	public ArrayList<PersonaVO> consultarUsuarioTabla(String documento) {
		Connection conn=null;
		PreparedStatement statement = null;
		ResultSet result = null;
		Conexion conexion = new Conexion();
		
		PersonaVO personaVO = null;
		ArrayList<PersonaVO> listaUsuarios = new ArrayList<>();
		
		conn = conexion.getConnection();
		
		consulta = "SELECT * FROM usuario WHERE documento = ?";
		
		try {
			
			statement = conn.prepareStatement(consulta);
			statement.setString(1, documento);
			result = statement.executeQuery();
			
			while(result.next()){
				personaVO = new PersonaVO();
				personaVO.setDocumento(result.getString("documento"));
				personaVO.setNombre(result.getString("nombre"));
				personaVO.setApellidos(result.getString("apellido"));
				personaVO.setEdad(result.getInt("edad"));
				personaVO.setProfesion(result.getString("profesion"));
				personaVO.setTelefono(result.getString("telefono"));
				listaUsuarios.add(personaVO);
			}
			
			conexion.desconectar();
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta: "+e.getMessage());
		}
		
		return listaUsuarios;
	}

	public String validarUser(String documento, String pass) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		Conexion conexion = new Conexion();
		
		conn = conexion.getConnection();
		
		consulta = "SELECT * FROM usuario WHERE documento = ? AND pass = ?";
		
		try {
			
			statement = conn.prepareStatement(consulta);
			statement.setString(1, documento);
			statement.setString(2, pass);
			result = statement.executeQuery();
			
			while(result.next()==true){
				res = "existe";
			}
			
			
			conexion.desconectar();
			
		} catch (SQLException e) {
			System.out.println("Usuario invalido");
			res = "error";
		}
		
		return res;
	}

}
