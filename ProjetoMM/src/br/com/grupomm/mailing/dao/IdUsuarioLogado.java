package br.com.grupomm.mailing.dao;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.grupomm.mailing.model.entity.Usuario;
import br.com.grupomm.mailing.util.JPAUtil;

public class IdUsuarioLogado {
    
	
	public  Integer UsuarioLogado(String pUsuario){
		
		EntityManager mysql = new JPAUtil().getMySql();
		
		 TypedQuery<Usuario> query = mysql.createQuery("SELECT c FROM Usuario c where c.nome=:pUsuario", Usuario.class).setParameter("pUsuario", pUsuario);
			  Usuario usuario = query.getSingleResult();
		     
			  return usuario.getId();
	}

}
