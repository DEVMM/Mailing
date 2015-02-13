
package br.com.grupomm.mailing.dao;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.grupomm.mailing.model.entity.Solicitacao;
import br.com.grupomm.mailing.model.entity.Usuario;
import br.com.grupomm.mailing.util.JPAUtil;
import br.com.grupomm.mailing.util.Util;

public class AnuariosDAO {
	
	EntityManager  manager = new JPAUtil().getEntituManager();

	public void gerarSolicitacao(String query, Solicitacao solicitacao){
		EntityManager  manager = new JPAUtil().getEntituManager();

		//Solicitacao solicitacao = new Solicitacao();
		Usuario usuario = new Usuario();
		usuario.setId(Util.getUserId());

		solicitacao.setDt(Calendar.getInstance());
		solicitacao.setQuery(query);
		solicitacao.setStatus("Aguardando");
		solicitacao.setTipoSolicitacao("Anuarios");

		solicitacao.setUsuario(usuario);
		EntityManager mysql = new JPAUtil().getMySql();
		mysql.getTransaction().begin();
		mysql.persist(solicitacao);
		mysql.getTransaction().commit();

		manager.close();
		mysql.close();
	}

	public Object count(String query) {
		EntityManager  manager = new JPAUtil().getEntituManager();
		Object q =  manager.createNativeQuery(query).getSingleResult();
		manager.close();
		return q;
	}
}

