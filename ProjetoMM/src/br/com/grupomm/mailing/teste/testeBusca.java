package br.com.grupomm.mailing.teste;

import br.com.grupomm.mailing.dao.UsuarioDAO;

public class testeBusca {

	
	public static void main(String[] args) {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
	
		System.out.println(usuarioDAO.listaBusca("").getLogin());  
		
	}
}
