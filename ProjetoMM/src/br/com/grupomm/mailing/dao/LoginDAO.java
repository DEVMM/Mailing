package br.com.grupomm.mailing.dao;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.grupomm.mailing.database.JPAUtil;
import br.com.grupomm.mailing.entity.Usuario;

public class LoginDAO {      

	public static boolean login(String nome, String senha) {

		EntityManager mysql = new JPAUtil().getMySql();

		Query query = mysql.createQuery("SELECT c FROM Usuario c where c.nome=:pUsuario and c.senha=:pSenha", Usuario.class).setParameter("pUsuario", nome).setParameter("pSenha",senha);

		@SuppressWarnings("unused")
		Usuario usuario = null;

		try{
			usuario = (Usuario)query.getSingleResult();
			return true;

		}catch(NoResultException e){
			return false;
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