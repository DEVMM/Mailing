package br.com.grupomm.mailing.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.grupomm.mailing.model.entity.Usuario;
import br.com.grupomm.mailing.util.JPAUtil;

public class testeNovo {
    
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getMySql();

		Query query = em.createQuery("SELECT c FROM Usuario c where c.login=:pLogin and c.senha=:pSenha", Usuario.class).setParameter("pLogin", "administrador").setParameter("pSenha","202cb962ac59075b964b07152d234b70");
		@SuppressWarnings("unchecked")
		List<Usuario> list = query.getResultList();
		
		for (Usuario usuario : list) {
			System.out.println(usuario.getPermissao().getId());
			
		}
	}
}
