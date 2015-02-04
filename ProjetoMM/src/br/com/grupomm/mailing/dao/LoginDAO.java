package br.com.grupomm.mailing.dao;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.grupomm.mailing.model.entity.Usuario;
import br.com.grupomm.mailing.util.JPAUtil;

public class LoginDAO {      

	public static Usuario login(Usuario usr) {

		EntityManager mysql = new JPAUtil().getMySql();

		Query query = mysql.createQuery("SELECT c FROM Usuario c where c.nome=:pUsuario and c.senha=:pSenha", Usuario.class).setParameter("pUsuario", usr.getNome()).setParameter("pSenha",usr.getSenha());

		@SuppressWarnings("unused")
		Usuario usuario = null;

		try{
			usuario = (Usuario)query.getSingleResult();
			return usuario;

		}catch(NoResultException e){
			return null;
		}

		finally{
			mysql.close();
		}
	}	
	

	public static String permissao(String usr){
		EntityManager mysql = new JPAUtil().getMySql();

		Query query = mysql.createQuery("select u from Usuario u where u.nome=:pUsuario").setParameter("pUsuario", usr);

		Usuario usuario = (Usuario)query.getSingleResult();

		 return usuario.getPermissao().getNomePermissao();

	}
}