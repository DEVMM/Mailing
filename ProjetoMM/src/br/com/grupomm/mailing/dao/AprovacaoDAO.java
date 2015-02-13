package br.com.grupomm.mailing.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.grupomm.mailing.model.entity.Permissao;
import br.com.grupomm.mailing.model.entity.Solicitacao;
import br.com.grupomm.mailing.model.entity.Usuario;
import br.com.grupomm.mailing.model.entity.logRegistro;
import br.com.grupomm.mailing.util.JPAUtil;
import br.com.grupomm.mailing.util.Util;

public class AprovacaoDAO {


	@SuppressWarnings("unchecked")
	public List<Solicitacao> listaSolicitacao(){

		EntityManager mysql = new JPAUtil().getMySql();
		Query query = mysql.createQuery("select c from Solicitacao c where c.status='Aguardando'");
		List<Solicitacao> list = query.getResultList();
		mysql.close();
		return list;
	}

	public void alterAprovacao(Solicitacao soli, String motivo){
		
		
		EntityManager mysql = new JPAUtil().getMySql();
		mysql.getTransaction().begin();
		Solicitacao solicitacao = mysql.find(Solicitacao.class, soli.getId());
		solicitacao.setStatus(soli.getStatus());
		Usuario usuario = new Usuario();
		usuario.setId(Util.getUserId());
		logRegistro log = new logRegistro();
		log.setUsuario(usuario);
		log.setMotivoRejeicao(motivo);
		log.setSolicitacao(solicitacao);
		log.setDt(Calendar.getInstance());
		mysql.persist(log);
		mysql.getTransaction().commit();
		mysql.close();
	}
}
