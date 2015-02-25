package br.com.grupomm.mailing.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.grupomm.mailing.dao.UsuarioDAO;
import br.com.grupomm.mailing.model.entity.Permissao;
import br.com.grupomm.mailing.model.entity.Usuario;
import br.com.grupomm.mailing.util.JPAUtil;

public class TesteBuscaADM {
    
	private static Query query;

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getMySql();

		query = em.createQuery("select c from Permissao c");
		@SuppressWarnings("unchecked")
		List<Permissao> list = query.getResultList();
		
		for (Permissao p : list) {
			System.out.println(p.getNomePermissao());
		}
	}
}
