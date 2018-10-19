package bean;

import javax.faces.bean.ManagedBean;

import dao.PersonaDAO;
import vo.PersonaVO;

@ManagedBean
public class LoginBean {
	private PersonaVO personaVO;
	private PersonaDAO personaDAO;
	private String mensajeError;
	
	public LoginBean(){
		setPersonaVO(new PersonaVO());
		setPersonaDAO(new PersonaDAO());
	}
	
	public String validarUser(){
		String msj="";
		
		String res = personaDAO.validarUser(personaVO.getDocumento(),personaVO.getPass());
		if(res.equals("existe")){
			msj="inicio.jsf";
		}else{
			msj="index.jsf";
			setMensajeError ("Usuario Inavlido");
		}
		
		return msj;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	public PersonaVO getPersonaVO() {
		return personaVO;
	}

	public void setPersonaVO(PersonaVO personaVO) {
		this.personaVO = personaVO;
	}

	public PersonaDAO getPersonaDAO() {
		return personaDAO;
	}

	public void setPersonaDAO(PersonaDAO personaDAO) {
		this.personaDAO = personaDAO;
	}
}
