package br.com.grupomm.mailing.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.grupomm.mailing.message.GrowlView;
import br.com.grupomm.mailing.model.entity.Departamento;
import br.com.grupomm.mailing.model.entity.Permissao;
import br.com.grupomm.mailing.model.entity.Solicitacao;
import br.com.grupomm.mailing.model.entity.Usuario;
import br.com.grupomm.mailing.model.enuns.Status;
import br.com.grupomm.mailing.util.JPAUtil;

public class UsuarioDAO {

	public void adiciona(Usuario usuario, Integer idPermissao, Integer idDepartamento, String descricao) {

		EntityManager em = new JPAUtil().getMySql();

		Query query = null;
		query = em.createQuery("select u from Usuario u where u.login=:pUsuario").setParameter("pUsuario", usuario.getLogin());

		Object result = null;

		if(query.getFirstResult() == 0)
		{
			em.getTransaction().begin();
			Permissao permissao = new Permissao();
			permissao.setId(idPermissao);
			Departamento departamento = new Departamento();
			departamento.setId(idDepartamento);
			usuario.setDepartamento(departamento);
			usuario.setPermissao(permissao);
			usuario.setStatus(Status.Ativo);
			Solicitacao solicitacao = new Solicitacao();
			solicitacao.setDescricao(descricao);
			em.persist(usuario);
			em.getTransaction().commit();
			em.close();
		}
		else
		{
			GrowlView.erro("Erro", "Usuario ja cadastrado");		}
	}

	@SuppressWarnings("unchecked")
	public List<Permissao> getPermissoes() {

		EntityManager mysql = new JPAUtil().getMySql();
		Query query = mysql.createQuery("from Permissao");
		return query.getResultList();

	}
	@SuppressWarnings("unchecked")
	public List<Departamento> getDepartamento() {

		EntityManager mysql = new JPAUtil().getMySql();
		Query query = mysql.createQuery("from Departamento");
		return query.getResultList();
	}

	public Permissao getPermissaoByID(Integer id) {

		EntityManager mysql = new JPAUtil().getMySql();
		Query query = mysql.createQuery("from Permissao where id = :id").setParameter("id", id);
		return (Permissao) query.getSingleResult();

	}


	@SuppressWarnings("unchecked")
	public List<Usuario> listaUsuario(){

		EntityManager mysql = new JPAUtil().getMySql();
		Query query = mysql.createQuery("select u from Usuario u");
		List<Usuario> list = query.getResultList();
		mysql.close();
		return list;
	}

	public Usuario listaBusca(int usuario){


		EntityManager mysql = new JPAUtil().getMySql();
		Query query = mysql.createQuery("select u from Usuario u where u.id=:PIdUsuario").setParameter("PIdUsuario", usuario);
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
		System.out.println("dentro do dao: " +usr.getLogin());
		System.out.println("dentro do dao:"+usr.getId());
		System.out.println("dentro do dao:"+usr.getSenha());
		System.out.println("dentro do dao:"+usr.getPermissao().getNomePermissao());
		em.close();
	}

	public String inativarUsuario(int usuario){

		EntityManager em = new JPAUtil().getMySql();
		em.getTransaction().begin();
		Usuario usuarioInativado = em.find(Usuario.class, usuario);
		usuarioInativado.setStatus(Status.Inativo);
		em.merge(usuarioInativado);
		em.getTransaction().commit();
		em.close();
		System.out.println("call");

		return "gerenciamento";
	}
	public List<Usuario> usuarioADM(){
		EntityManager em = new JPAUtil().getMySql();
		Query query = em.createQuery("select c from Usuario c where c.permissao.id=1");
		List<Usuario> list = query.getResultList();
		em.close();

		return list;
	}
	public String ativarUsuario(int usuario){

		EntityManager em = new JPAUtil().getMySql();
		em.getTransaction().begin();
		Usuario usuarioAtivado = em.find(Usuario.class, usuario);
		usuarioAtivado.setStatus(Status.Ativo);
		em.merge(usuarioAtivado);
		em.getTransaction().commit();
		em.close();
		System.out.println("call");

		return "gerenciamento";
	}
}















