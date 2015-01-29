package br.com.grupomm.mailing.teste;

import java.util.List;

import br.com.grupomm.mailing.bean.UsuarioBean;
import br.com.grupomm.mailing.dao.UsuarioDAO;
import br.com.grupomm.mailing.entity.Usuario;

public class testeBusca {

	
	public static void main(String[] args) {
		
	 UsuarioDAO dao = new UsuarioDAO();
	 
	 Usuario teste = dao.listaBusca("gustavo");
	 teste.setNome("wfreitas");
	 System.out.println(teste.getNome());
	 
	 System.out.println();
	  
	}
}
