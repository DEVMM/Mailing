package br.com.grupomm.mailing.teste;

import java.util.List;

import br.com.grupomm.mailing.dao.UsuarioDAO;
import br.com.grupomm.mailing.model.entity.Usuario;

public class TesteBuscaADM {
    
	public static void main(String[] args) {
		
		List<Usuario> usuario = new UsuarioDAO().usuarioADM();
		
		for (Usuario usuario2 : usuario) {
			System.out.println(usuario2.getEmail());
		}
	}
}
