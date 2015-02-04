
package br.com.grupomm.mailing.dao;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.grupomm.mailing.model.entity.Solicitacao;
import br.com.grupomm.mailing.model.entity.Usuario;
import br.com.grupomm.mailing.util.JPAUtil;
import br.com.grupomm.mailing.util.Util;

public class MMDAO {


      public void solicitacao(String query){
    	  
    	   EntityManager  manager = new JPAUtil().getMMonline();
    	   
    	   List q = manager.createNativeQuery(query).getResultList();
    	   
    	   Solicitacao solicitacao = new Solicitacao();
           Usuario usuario = new Usuario();
           
    	   usuario.setId(Util.getUserId());
    	   solicitacao.setDt(Calendar.getInstance());
    	   solicitacao.setQuery(query);
    	   solicitacao.setQuantidade(q.size());
    	   solicitacao.setStatus("Aguardando");
    	   solicitacao.setTipoSolicitacao("MM-online");
    	  
    	   solicitacao.setUsuario(usuario);
    	   EntityManager mysql = new JPAUtil().getMySql();
    	   mysql.getTransaction().begin();
    	   mysql.persist(solicitacao);
    	   mysql.getTransaction().commit();
    	  
    	   manager.close();
    	   mysql.close();

       }
}

