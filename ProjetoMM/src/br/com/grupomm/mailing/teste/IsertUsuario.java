package br.com.grupomm.mailing.teste;

import javax.persistence.EntityManager;

import br.com.grupomm.mailing.model.entity.Departamento;
import br.com.grupomm.mailing.model.entity.Permissao;
import br.com.grupomm.mailing.model.entity.Solicitacao;
import br.com.grupomm.mailing.model.entity.Usuario;
import br.com.grupomm.mailing.util.JPAUtil;

public class IsertUsuario {
   public static void main(String[] args) {
	
//	   Usuario usuario = new Usuario();
//	   usuario.setLogin("wfreitas");
//	   usuario.setSenha("123");
//	   
//	   Departamento departamento = new Departamento();
//	   departamento.setId(1);
//	   
//	   Permissao permissao = new Permissao();
//	   permissao.setId(1);
//	
//	   usuario.setPermissao(permissao);
//	   usuario.setDepartamento(departamento);
	   
	   EntityManager manager = new JPAUtil().getMySql();
	   
	   manager.getTransaction().begin();
	   
//	   manager.persist(usuario);
	   manager.getTransaction().commit();
     manager.close();
     System.out.println("usuario inserido");
   
   } 
}
