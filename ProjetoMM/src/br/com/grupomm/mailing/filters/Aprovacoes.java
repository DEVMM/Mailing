package br.com.grupomm.mailing.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.grupomm.mailing.dao.LoginDAO;
import br.com.grupomm.mailing.util.Util;



@WebFilter ("/aprovacoes.xhtml")
public class Aprovacoes implements Filter {

	@Override
	public void doFilter(ServletRequest request , ServletResponse response,
			FilterChain chain ) throws IOException ,ServletException{

		HttpServletRequest req = (HttpServletRequest) request ;
		HttpSession session = req.getSession();
//		String usr = null;
//		String permissao =null;

		if(session.getAttribute("nomeUsuario") == null){
			HttpServletResponse res=(HttpServletResponse) response;
			res.sendRedirect("login.xhtml");
		}
               
		if ( session.getAttribute("nomeUsuario") != null ){
			//usr = session.getAttribute("nomeUsuario").toString();
			
                
			if(session.getAttribute("permissao").equals("Usuario")){
				RequestDispatcher dd = request.getRequestDispatcher("negado.xhtml");
				dd.forward(request, response);
			}
			else{
				chain.doFilter(request,response);
			}
		}
	}
	@Override
	public void init (FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void destroy() {
	}

}