package br.com.grupomm.mailing.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.grupomm.mailing.database.JPAUtil;
import br.com.grupomm.mailing.entity.Permissao;
import br.com.grupomm.mailing.entity.Usuario;

public class UsuarioDAO {

//	public UsuarioDAO(Class<Usuario> classe) {
//	}

	public void adiciona(Usuario usuario) {

		// consegue a entity manager
		EntityManager em = new JPAUtil().getMySql();

		// abre transacao
		em.getTransaction().begin();

		// persiste o objeto
		em.persist(usuario);

		// commita a transacao
		em.getTransaction().commit();

		// fecha a entity manager
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Permissao> getPermissoes() {
		
		EntityManager mysql = new JPAUtil().getMySql();
		Query query = mysql.createQuery("from Permissao");
		return query.getResultList();
	
	}
	
	public Permissao getPermissaoByID(Integer id) {
		
		EntityManager mysql = new JPAUtil().getMySql();
		Query query = mysql.createQuery("from Permissao where id = :id").setParameter("id", id);
		return (Permissao) query.getSingleResult();
		
	}
	
	
	public Usuario listaBusca(String usuario){
		
		
		EntityManager mysql = new JPAUtil().getMySql();
		Query query = mysql.createQuery("select u from Usuario u where u.nome=:pUsuario").setParameter("pUsuario", usuario);
		 Usuario usr = new Usuario();    
		 try {
			 usr = (Usuario) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("erro");
		} 
		 return usr;
	}
}
