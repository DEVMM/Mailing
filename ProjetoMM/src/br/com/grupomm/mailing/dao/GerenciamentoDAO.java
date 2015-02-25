
package br.com.grupomm.mailing.dao;
import javax.persistence.EntityManager;

import br.com.grupomm.mailing.model.entity.Usuario;
import br.com.grupomm.mailing.util.JPAUtil;

public class GerenciamentoDAO {


	public void adicionar(Usuario usuario){

		EntityManager mysql = new JPAUtil().getMySql();
		mysql.getTransaction().begin();

		mysql.persist(usuario);
		mysql.getTransaction().commit();

		mysql.close();
	}
}

