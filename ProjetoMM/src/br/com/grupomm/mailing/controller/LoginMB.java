package br.com.grupomm.mailing.controller;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	String nome;

	public String loginProject() throws NoSuchAlgorithmException {
		
		String s = this.usr.getSenha();
		MessageDigest m=MessageDigest.getInstance("MD5");
		m.update(s.getBytes(),0,s.length());
		String usuarioCrip=new BigInteger(1,m.digest()).toString(16);
		usr.setSenha(usuarioCrip.toString());
		Usuario result = LoginDAO.login(this.usr);
		if (result!=null) {

			HttpSession session = Util.getSession();
			session.setAttribute("nomeUsuario", result.getLogin());
			session.setAttribute("idUsuario", result.getId());
			session.setAttribute("permissao", result.getPermissao().getNomePermissao().toString());
			session.setAttribute("email", result.getEmail());
			this.setNome(result.getNome());
			System.out.println("usuarioid "+Util.getUserId());
			LoginDAO.expira();
			
			if(result.getPermissao().getNomePermissao().equalsIgnoreCase("Aprovador")){
				return "aprovacoes?faces-redirect=true";
			}else{
				return "index?faces-redirect=true";
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}