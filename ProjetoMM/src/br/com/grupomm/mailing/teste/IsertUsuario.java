package br.com.grupomm.mailing.teste;

import javax.persistence.EntityManager;

import br.com.grupomm.mailing.database.JPAUtil;
import br.com.grupomm.mailing.entity.Solicitacao;
import br.com.grupomm.mailing.entity.Usuario;

public class IsertUsuario {
   public static void main(String[] args) {
	
	   Usuario usuario = new Usuario();
	   usuario.setNome("renato");
	   usuario.setSenha("123");
	   
       Solicitacao solicitacao = new Solicitacao();
       
       solicitacao.setQuery("teste");
       solicitacao.setQuantidade(20);
       solicitacao.setStatus("teste");
       solicitacao.setUsuario(usuario);
	   
	   EntityManager manager = new JPAUtil().getMySql();
	   
	   manager.getTransaction().begin();
	   
	  manager.persist(usuario);
	   manager.getTransaction().commit();
     manager.close();
     System.out.println("usuario inserido");
   
   } 
}