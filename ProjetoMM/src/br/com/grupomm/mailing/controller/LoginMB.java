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
import br.com.grupomm.mailing.model.bo.LoginBO;
import br.com.grupomm.mailing.model.entity.Usuario;
import br.com.grupomm.mailing.model.enuns.TipoPermissao;
import br.com.grupomm.mailing.util.Util;

@ManagedBean
@SessionScoped
public class LoginMB implements Serializable {

	private static final long serialVersionUID = -5165511376450230953L;
	Usuario usr = new Usuario();
	private static String nome;

	public String loginProject() throws NoSuchAlgorithmException {

		LoginBO loginBO = new LoginBO();	
		return loginBO.autenticacao(this.usr);
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
	public static void setNome(String n) {
		nome = n;
	}
}