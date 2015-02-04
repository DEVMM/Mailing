package br.com.grupomm.mailing.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.grupomm.mailing.dao.LoginDAO;
import br.com.grupomm.mailing.model.entity.Usuario;
import br.com.grupomm.mailing.util.Util;

@ManagedBean
@SessionScoped

public class LoginMB implements Serializable {

	private static final long serialVersionUID = -5165511376450230953L;
	Usuario usr = new Usuario();

	public String loginProject() {
		Usuario result = LoginDAO.login(this.usr);
		if (result!=null) {

			HttpSession session = Util.getSession();
			session.setAttribute("nomeUsuario", result.getNome());
			session.setAttribute("idUsuario", result.getId());
			session.setAttribute("permissao", result.getPermissao().getNomePermissao().toString());

			System.out.println(result.getPermissao().getNomePermissao());
			if(result.getNome().equalsIgnoreCase("Aprovador")){
				return "aprovacoes";
			}else{
				return "index";
			}
		} 
		else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Login inválido!",
							"Por favor, tente de novo"));
			return "login";
		}
	}

	public String logout() {
		HttpSession session = Util.getSession();
		session.invalidate();
		return "login";
	}

	public Usuario getUsr() {
		return usr;
	}

	public void setUsr(Usuario usr) {
		this.usr = usr;
	}
}