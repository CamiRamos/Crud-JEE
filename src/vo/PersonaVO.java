package vo;
import javax.faces.bean.ManagedBean;

import com.sun.xml.internal.ws.api.addressing.AddressingVersion.EPR;

import dao.PersonaDAO;

@ManagedBean
public class PersonaVO {
	private String nombre, apellidos, telefono, profesion, resultado, documento,pass;
	private int edad;
	PersonaVO personaVO;
	PersonaDAO personaDAO;
	private boolean editar;
	
	public PersonaVO() {
		personaDAO = new PersonaDAO();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getProfesion() {
		return profesion;
	}
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
		
	public void consultarUsuario(){
		personaVO = personaDAO.consultarUsuario(getDocumento());
		if(personaVO!=null){
			setResultado("");
		}else{
			setResultado("No se encuentra la persona");
		}
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}


}
