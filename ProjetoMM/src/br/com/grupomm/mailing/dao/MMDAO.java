
package br.com.grupomm.mailing.dao;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.grupomm.mailing.model.entity.Solicitacao;
import br.com.grupomm.mailing.model.entity.Usuario;
import br.com.grupomm.mailing.model.enuns.StatusSolicitacao;
import br.com.grupomm.mailing.util.JPAUtil;
import br.com.grupomm.mailing.util.Util;

public class MMDAO {

	EntityManager  manager = new JPAUtil().getEntituManager();

      public void gerarSolicitacao(String query, Solicitacao solicitacao){
    	   EntityManager  manager = new JPAUtil().getMMonline();
    	   
           Usuario usuario = new Usuario();
           
    	   usuario.setId(Util.getUserId());
    	   solicitacao.setDt(Calendar.getInstance());
    	   solicitacao.setQuery(query);
    	   solicitacao.setStatus(StatusSolicitacao.Aguardando);
    	   solicitacao.setTipoSolicitacao("MM-online");
    	  
    	   solicitacao.setUsuario(usuario);
    	   EntityManager mysql = new JPAUtil().getMySql();
    	   mysql.getTransaction().begin();
    	   mysql.persist(solicitacao);
    	   mysql.getTransaction().commit();
    	  
    	   manager.close();
    	   mysql.close();

       }
      
      public Object count(String query) {
  		EntityManager  manager = new JPAUtil().getMMonline();
  		Object q =  manager.createNativeQuery(query).getSingleResult();
  		manager.close();
  		return q;
  	}
}

