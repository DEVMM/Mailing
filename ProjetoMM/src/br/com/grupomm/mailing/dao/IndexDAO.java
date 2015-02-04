package br.com.grupomm.mailing.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.grupomm.mailing.model.entity.Mapeamento;
import br.com.grupomm.mailing.model.entity.MapeamentoMM;
import br.com.grupomm.mailing.model.entity.Solicitacao;
import br.com.grupomm.mailing.util.JPAUtil;
import br.com.grupomm.mailing.util.Util;

public class IndexDAO {

	@SuppressWarnings("unchecked")
	public  List<Solicitacao> listaAprovados(/*String usuario*/){

		EntityManager mysql = new JPAUtil().getMySql();

		Query query = mysql.createQuery("select s from Solicitacao s where s.usuario.nome = :pUsuario and s.status = 'Aprovado'");
		query.setParameter("pUsuario", Util.getUserName());
		List<Solicitacao> solicitacao = query.getResultList();

		return solicitacao;
	}

	public static List<Mapeamento> selectSolicitacao(int id){
		EntityManager mysql = new JPAUtil().getMySql();
		Query query = mysql.createQuery("select s from Solicitacao s where s.id=:pid").setParameter("pid", id);
		Solicitacao solicitacao = (Solicitacao)query.getSingleResult();

		EntityManager  manager = new JPAUtil().getEntituManager();
		Query query1 = manager.createNativeQuery(solicitacao.getQuery(),Mapeamento.class);

		return query1.getResultList();
	}
	public static List<MapeamentoMM> selectSolicitacaoMM(int id){
		EntityManager mysql = new JPAUtil().getMySql();
		Query query = mysql.createQuery("select s from Solicitacao s where s.id=:pid").setParameter("pid", id);
		Solicitacao solicitacao = (Solicitacao)query.getSingleResult();

		EntityManager  manager = new JPAUtil().getMMonline();
		Query query1 = manager.createNativeQuery(solicitacao.getQuery(),MapeamentoMM.class);

		return query1.getResultList();
	}

	public void removerSolicitacao(int id){
		EntityManager mysql = new JPAUtil().getMySql();
		mysql.getTransaction().begin();
		Solicitacao solicitacao = mysql.find(Solicitacao.class, id);
		solicitacao.setStatus("Baixado");
		mysql.getTransaction().commit();
		mysql.close();
	}
}
