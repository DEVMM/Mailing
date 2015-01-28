package br.com.grupomm.mailing.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.grupomm.mailing.database.JPAUtil;
import br.com.grupomm.mailing.entity.Solicitacao;

public class AprovacaoDAO {


	@SuppressWarnings("unchecked")
	public List<Solicitacao> listaSolicitacao(){

		EntityManager mysql = new JPAUtil().getMySql();
		Query query = mysql.createQuery("select c from Solicitacao c where c.status='Aguardando'");
		List<Solicitacao> list = query.getResultList();

		mysql.close();
		return list;
	}

	public void alterAprovacao(int id, String status){
		EntityManager mysql = new JPAUtil().getMySql();
		mysql.getTransaction().begin();
		Solicitacao solicitacao = mysql.find(Solicitacao.class, id);
		solicitacao.setStatus(status);
		mysql.getTransaction().commit();
		mysql.close();

	}


}
