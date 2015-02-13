package br.com.grupomm.mailing.util;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@ManagedBean
public class Util {

	public static HttpSession getSession() {
		return (HttpSession)
				FacesContext.
				getCurrentInstance().
				getExternalContext().
				getSession(false);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.
				getCurrentInstance().
				getExternalContext().getRequest();
	}

	public static String getUserName()
	{
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return  session.getAttribute("nomeUsuario").toString();
	}
	
	public  String getPermissao()
	{
		HttpSession session = getSession();
		if ( session != null )
			
			return  (String) session.getAttribute("permissao");
		else
			return "sem permissao";
	}
	
	public static String getEmail()
	{
		HttpSession session = getSession();
		if ( session != null ){
			return  (String) session.getAttribute("email");
		}
		return "";	
			
	}

	public static Integer getUserId()
	{
		HttpSession session = getSession();
		if ( session != null )
			return  (Integer) session.getAttribute("idUsuario");
		else
			return null;
	}
}