package br.com.grupomm.mailing.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.grupomm.mailing.dao.UsuarioDAO;
import br.com.grupomm.mailing.entity.Usuario;

@ManagedBean
@SessionScoped

public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private Integer idPermissao = new Integer(0);
	private String usuarioBusca = new String("");
	private UsuarioDAO user = new UsuarioDAO();


	public Usuario getUsuario() {
		return usuario;
	}

	public  List<br.com.grupomm.mailing.entity.Permissao> getPermissoes() {
		return user.getPermissoes();
	}

	public void gravar() {
		this.usuario.setPermissao(user.getPermissaoByID(idPermissao));
		System.out.println(usuario);
		user.adiciona(this.usuario);
		this.usuario = new Usuario();
	}

	public void excluir() {
		System.out.println("excluindo usuario 1 :" +this.buscaUsuario().getNome());
		System.out.println("excluindo usuario 2 :" +this.getUsuarioBusca());

		user.excluir(this.buscaUsuario().getId());
		this.usuario = new Usuario();
	}

	public Usuario buscaUsuario(){
		System.out.println("usuario " +this.getUsuarioBusca());
		System.out.println("usuario 2 " +this.usuarioBusca);
		System.out.println("usuario 3" +usuario.toString());
		return user.listaBusca(this.getUsuarioBusca());
	}


	public Integer getIdPermissao() {
		return idPermissao;
	}

	public void setIdPermissao(Integer idPermissao) {
		this.idPermissao = idPermissao;
	}

	public String getUsuarioBusca() {
		return usuarioBusca;
	}

	public void setUsuarioBusca(String usuarioBusca) {
		this.usuarioBusca = usuarioBusca;
	}

	public UsuarioDAO getUser() {
		return user;
	}

	public void setUser(UsuarioDAO user) {
		this.user = user;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}