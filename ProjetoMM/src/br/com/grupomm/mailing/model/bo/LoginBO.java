package br.com.grupomm.mailing.model.bo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.xmlbeans.impl.regex.REUtil;

import br.com.grupomm.mailing.controller.LoginMB;
import br.com.grupomm.mailing.dao.LoginDAO;
import br.com.grupomm.mailing.message.GrowlView;
import br.com.grupomm.mailing.model.entity.Usuario;
import br.com.grupomm.mailing.model.enuns.TipoPermissao;
import br.com.grupomm.mailing.util.Util;

public class LoginBO {

	public String autenticacao(Usuario usr) throws NoSuchAlgorithmException{

		String s = usr.getSenha();
		MessageDigest m=MessageDigest.getInstance("MD5");
		m.update(s.getBytes(),0,s.length());
		String usuarioCrip=new BigInteger(1,m.digest()).toString(16);
		System.out.println(usuarioCrip.toString());
		usr.setSenha(usuarioCrip.toString());
         
		System.out.println(usr.getLogin());
		System.out.println(usr.getSenha());
//		try {

			Usuario result = LoginDAO.login(usr);

			if (result!=null) {

				HttpSession session = Util.getSession();
				session.setAttribute("nomeUsuario", result.getLogin());
				session.setAttribute("idUsuario", result.getId());
				session.setAttribute("permissao", result.getPermissao().getNomePermissao().toString());
				session.setAttribute("email", result.getEmail());
				LoginMB.setNome(result.getNome());
				System.out.println("usuarioid "+Util.getUserId());
				LoginDAO loginDAO = new LoginDAO();
				loginDAO.expira();
				if(result.getPermissao().getNomePermissao().equals(TipoPermissao.Administrador)){
					return "aprovacoes?faces-redirect=true";
				}else{
					return "index?faces-redirect=true";
				}
			} 
			
			else {
				
				GrowlView.Info("Login inválido!","Por favor, tente de novo");
				
				return "";
			}
//		} catch (Exception e) {
			//GrowlView.erro("Erro", "Tente Novamented");
			//System.out.println("erro");
		//return "";
		//}
	}
}

