
package br.com.grupomm.mailing.dao;
import javax.persistence.EntityManager;

import br.com.grupomm.mailing.database.JPAUtil;
import br.com.grupomm.mailing.entity.Usuario;

public class GerenciamentoDAO {


      public void adicionar(Usuario usuario){
    
    	   EntityManager mysql = new JPAUtil().getMySql();
    	   mysql.getTransaction().begin();

    	   mysql.persist(usuario);
    	   mysql.getTransaction().commit();
    	  
    	   mysql.close();

       }
}

