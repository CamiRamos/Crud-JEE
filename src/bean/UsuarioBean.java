package bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import dao.PersonaDAO;
import vo.PersonaVO;

@ManagedBean
@SessionScoped
public class UsuarioBean {
	
	private PersonaVO miPersonaVo;
	PersonaDAO miPersonaDao;
	private String mensajeError, mensajeExitoso;
	private ArrayList<PersonaVO> listaPersonas;
	private ArrayList<String> documentos;
	
	public UsuarioBean(){
		miPersonaVo=new PersonaVO();
		miPersonaDao=new PersonaDAO();
		setListaPersonas(new ArrayList<>());
		setDocumentos(new ArrayList<>());
	}
	
	
	public void registrarUsuario(){
		listaPersonas.add(miPersonaVo);
		String res = miPersonaDao.registrarPersona(miPersonaVo);
		if(res.equals("ok")) {
			setMensajeExitoso("Registro exitoso");
			miPersonaVo = new PersonaVO();
		}else {
			setMensajeError("No se registro la persona");
		}
	}
	
	public void consultarUsuario(){
		System.out.println("Consulta de Usuario: "+miPersonaVo.getDocumento());
		miPersonaVo=miPersonaDao.consultarUsuario(miPersonaVo.getDocumento());
		if (miPersonaVo!=null) {
			
		}else{
			setMensajeError("No se encuentra la persona");
			miPersonaVo=new PersonaVO();
		}
	}
	
	public void consultaIndividual(PersonaVO personaVO){
		PersonaVO mipersonaVO;
		
		mipersonaVO = miPersonaDao.consultarUsuario(personaVO.getDocumento());
		if(mipersonaVO!=null){
			this.miPersonaVo = mipersonaVO;
		}
		
	}
	
	
	public void consultarUsuarioTabla(){
		setListaPersonas(miPersonaDao.consultarUsuarioTabla(miPersonaVo.getDocumento()));
	}
	
	public void consultarLista(){
		setListaPersonas(miPersonaDao.consultarLista());
		
	}
	
	public void eliminarUsuario(String documento) {
		String res = miPersonaDao.eliminarUsuario(documento);
		if(res.equals("ok")) {
			consultarLista();			
		}else {
			setMensajeError("No se elimino el usuario");
		}
	}
	
	public void editarPersona(){
		String res = miPersonaDao.editarPersona(miPersonaVo);
		if(res.equals("ok")){
			setMensajeExitoso("Actualizacion Exitosa");
			miPersonaVo = new PersonaVO();
			consultarLista();
		}else{
			setMensajeError("No se realizo la modificacion");
		}
	}
	
	public void modificarPersona(PersonaVO persona) {
		persona.setEditar(true);
	}
	
	public void guardarPersona(PersonaVO miPerson) {
		String res = miPersonaDao.editarPersona(miPerson);
		if(res.equals("ok")) {
			consultarLista();
		}else {
			
		}
	}
	
	public void resetearMensajes(){
		setMensajeError("");
		setMensajeExitoso("");
		miPersonaVo = new PersonaVO();
	}
	
	public PersonaVO getMiPersonaVo() {
		return miPersonaVo;
	}

	public void setMiPersonaVo(PersonaVO miPersonaVo) {
		this.miPersonaVo = miPersonaVo;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensaje) {
		this.mensajeError = mensaje;
	}


	public ArrayList<PersonaVO> getListaPersonas() {
		return listaPersonas;
	}


	public void setListaPersonas(ArrayList<PersonaVO> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}


	public ArrayList<String> getDocumentos() {
		return documentos;
	}


	public void setDocumentos(ArrayList<String> documentos) {
		this.documentos = documentos;
	}


	public String getMensajeExitoso() {
		return mensajeExitoso;
	}


	public void setMensajeExitoso(String mensajeExitoso) {
		this.mensajeExitoso = mensajeExitoso;
	}

	
	
}
