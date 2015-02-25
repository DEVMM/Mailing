package br.com.grupomm.mailing.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.grupomm.mailing.message.GrowlView;
import br.com.grupomm.mailing.model.entity.Mapeamento;
import br.com.grupomm.mailing.model.entity.MapeamentoMM;
import br.com.grupomm.mailing.model.entity.Solicitacao;
import br.com.grupomm.mailing.model.entity.Usuario;
import br.com.grupomm.mailing.model.entity.logRegistro;
import br.com.grupomm.mailing.model.enuns.StatusSolicitacao;
import br.com.grupomm.mailing.util.BuscaComposite;
import br.com.grupomm.mailing.util.JPAUtil;
import br.com.grupomm.mailing.util.Util;

public class IndexDAO  implements Serializable{


	private static final long serialVersionUID = 6913275428350159148L;

	@SuppressWarnings("unchecked")
	public  List<Solicitacao> listaAprovados(){

		EntityManager mysql = new JPAUtil().getMySql();

		Query query = mysql.createQuery("select s from Solicitacao s where s.usuario.login = :pUsuario and s.status = 'Aprovado'");

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
		solicitacao.setStatus(StatusSolicitacao.Baixado);
		mysql.getTransaction().commit();
		mysql.close();
	}
	@SuppressWarnings("unchecked")
	public List<Solicitacao> buscaAvancadaDAO (BuscaComposite busca){
		System.out.println(busca.toString().length());
		EntityManager mysql = new JPAUtil().getMySql();
		StringBuilder sql = new StringBuilder("select s from Solicitacao s where s.usuario.id = :pUsuarioId ");
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


				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			      String dataFrom = dateFormat.format(busca.getDataFrom());
			      String dataFor = dateFormat.format(busca.getDataFor());
			      
			      sql.append(" and s.dt between '"+dataFrom+"' and '"+dataFor+"'");
			}

		}else{
			GrowlView.showMessage("Aviso", "Preencha as duas datas");
		}

		String query = sql.toString().replace("[", "('").replace("]", "')").replace(",", "','").replace("' ", "'");
		System.out.println(query);

		Query qr =  mysql.createQuery(query).setParameter("pUsuarioId", Util.getUserId());

		return qr.getResultList();
	}

	public void alterStatus(Solicitacao soli) {

		EntityManager mysql = new JPAUtil().getMySql();
		mysql.getTransaction().begin();
		mysql.merge(soli);
		mysql.getTransaction().commit();
		mysql.close();

	}
}

