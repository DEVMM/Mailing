package br.com.grupomm.mailing.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.grupomm.mailing.model.entity.Permissao;
import br.com.grupomm.mailing.model.entity.Usuario;
import br.com.grupomm.mailing.util.JPAUtil;

public class UsuarioDAO {

	public void adiciona(Usuario usuario) {

		EntityManager em = new JPAUtil().getMySql();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
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
	public void editar(Usuario usr) {

		EntityManager em = new JPAUtil().getMySql();
		em.getTransaction().begin();
		em.merge(usr);
		em.getTransaction().commit();
		System.out.println("dentro do dao: " +usr.getNome());
		System.out.println("dentro do dao:"+usr.getId());
		System.out.println("dentro do dao:"+usr.getSenha());
		System.out.println("dentro do dao:"+usr.getPermissao().getNomePermissao());
		em.close();
	}


	public void excluir(int usuario){


		EntityManager em = new JPAUtil().getMySql();
		em.getTransaction().begin();
		Usuario usuarioRemover = em.find(Usuario.class, usuario);
		em.remove(usuarioRemover);
		em.getTransaction().commit();
		em.close();
		System.out.println("call");
	}
}
