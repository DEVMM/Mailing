package br.com.grupomm.mailing.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.grupomm.mailing.message.GrowlView;
import br.com.grupomm.mailing.model.entity.Mapeamento;
import br.com.grupomm.mailing.model.entity.MapeamentoMM;
import br.com.grupomm.mailing.model.entity.Solicitacao;
import br.com.grupomm.mailing.util.BuscaComposite;
import br.com.grupomm.mailing.util.JPAUtil;
import br.com.grupomm.mailing.util.Util;

public class IndexDAO {

	@SuppressWarnings("unchecked")
	public  List<Solicitacao> listaAprovados(/*String usuario*/){

		EntityManager mysql = new JPAUtil().getMySql();

		Query query = mysql.createQuery("select s from Solicitacao s where s.usuario.login = :pUsuario and s.status = 'Aprovado'");

		query.setParameter("pUsuario", Util.getUserName());
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
	
	public List<Solicitacao> buscaAvancadaDAO (BuscaComposite busca){
		System.out.println(busca.toString().length());
		EntityManager mysql = new JPAUtil().getMySql();
		StringBuilder sql = new StringBuilder("select s from Solicitacao s where 1 = 1 ");
		if (busca.toString().length()!= 96){
			if(busca.getNrSolicitacao() !=null ){
				sql.append(" and s.id = "+busca.getNrSolicitacao());
			}
			
			if(busca.getDescricao() != null && !busca.getDescricao().isEmpty()){		
				sql.append(" and s.descricao like '%"+ busca.getDescricao() + "%'");
			}
			
			if(busca.getStatus() != null && !busca.getStatus().isEmpty()){
				sql.append(" and s.status in "+ busca.getStatus());
				
			}
			
			if (busca.getTipo() != null && !busca.getTipo().isEmpty()){
				sql.append(" and s.tipoSolicitacao in "+busca.getTipo());
			}
			
			if (busca.getDataFrom() != null && busca.getDataFor() !=null ){
				sql.append(" and s.dt between "+busca.getDataFrom() + " and " + busca.getDataFor() +" ");
			}
			
		}else{
			GrowlView gv = new GrowlView();
			gv.buscaAlerta();
		}

		
			
		
		
		String query = sql.toString().replace("[", "('").replace("]", "')").replace(",", "','");
		System.out.println(query);
		
		Query qr =  mysql.createQuery(query);
		
		return qr.getResultList();
//		
//		for (Solicitacao solicitacao : list) {
//			
//			System.out.println("id da solicitação: " +solicitacao.getId());
//		}
	
	}
}
