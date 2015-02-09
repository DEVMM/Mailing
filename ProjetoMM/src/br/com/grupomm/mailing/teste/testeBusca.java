package br.com.grupomm.mailing.teste;

import java.util.List;

import br.com.grupomm.mailing.dao.IndexDAO;
import br.com.grupomm.mailing.dao.UsuarioDAO;
import br.com.grupomm.mailing.model.entity.Solicitacao;

public class testeBusca {

	
	public static void main(String[] args) {
		
		List<Solicitacao> provacoesList = new IndexDAO().listaAprovados();
		
		for (Solicitacao s : provacoesList) {
			System.out.println(s.getStatus());
		}
	
		System.out.println();  
		
	}
}
