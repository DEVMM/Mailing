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

		}catch(NoResultException e){
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
		
		Query query = mysql.createQuery("select c from logRegistro c  where CURDATE()-c.dt >= 2 and c.solicitacao.usuario.id= :pUsuario and c.solicitacao.status <> 'Expirado'");
		query.setParameter("pUsuario", Util.getUserId());
		@SuppressWarnings("unchecked")
		List<logRegistro> list = query.getResultList();

		for (logRegistro logRegistro : list) {
			mysql.getTransaction().begin();
			mysql.flush();
			Solicitacao solicitacao = mysql.find(Solicitacao.class, logRegistro.getSolicitacao().getId());
			solicitacao.setStatus(StatusSolicitacao.Expirado);
			mysql.persist(solicitacao);
			mysql.getTransaction().commit();
		}
		mysql.close();
	}
}

