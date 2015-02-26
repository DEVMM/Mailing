package br.com.grupomm.mailing.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.grupomm.mailing.model.entity.Solicitacao;
import br.com.grupomm.mailing.model.entity.Usuario;
import br.com.grupomm.mailing.model.entity.logRegistro;
import br.com.grupomm.mailing.model.enuns.StatusSolicitacao;
import br.com.grupomm.mailing.model.enuns.TipoPermissao;
import br.com.grupomm.mailing.util.JPAUtil;
import br.com.grupomm.mailing.util.Util;

public class LoginDAO {      

	public static Usuario login(Usuario usr) {

		EntityManager mysql = new JPAUtil().getMySql();

		Query query = mysql.createQuery("SELECT c FROM Usuario c where c.login=:pLogin and c.senha=:pSenha", Usuario.class).setParameter("pLogin", usr.getLogin()).setParameter("pSenha",usr.getSenha());

		Usuario usuario = null;

		try{
			usuario = (Usuario)query.getSingleResult();
			return usuario;

		}
		catch(NoResultException e){
			e.printStackTrace();
			return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}

		finally{
			mysql.close();
		}
	}	

	public static TipoPermissao permissao(String usr){
		EntityManager mysql = new JPAUtil().getMySql();

		Query query = mysql.createQuery("select u from Usuario u where u.nome=:pUsuario").setParameter("pUsuario", usr);
		Usuario usuario = (Usuario)query.getSingleResult();
		TipoPermissao permissao =usuario.getPermissao().getNomePermissao();

		mysql.close();
		return permissao;
	}

	public void expira() {
		System.out.println("chamou o expira");
		EntityManager mysql = new JPAUtil().getMySql();
		mysql.getTransaction().begin();
		Query query = mysql.createQuery("update Solicitacao s set s.status = 'Expirado'  where s.usuario.id= :pUsuario and s.status <> 'Expirado' and s.id in (select c.solicitacao.id from logRegistro c  where CURDATE()-c.dt >= 15)");
		query.setParameter("pUsuario", Util.getUserId());
		query.executeUpdate();
		mysql.getTransaction().commit();
		mysql.close();
	}
}

