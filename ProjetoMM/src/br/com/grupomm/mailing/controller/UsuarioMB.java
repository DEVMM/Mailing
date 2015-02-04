package br.com.grupomm.mailing.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.grupomm.mailing.dao.UsuarioDAO;
import br.com.grupomm.mailing.model.entity.Permissao;
import br.com.grupomm.mailing.model.entity.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioMB {

	private Usuario usuario = new Usuario();
	private Usuario usuarioEditado = new Usuario();
	private Integer idPermissao = new Integer(0);
	private Integer idPermissao2 = new Integer(0);
	private String usuarioBusca = new String();
	private UsuarioDAO user = new UsuarioDAO();

	public Usuario getUsuario() {
		return usuario;
	}

	public  List<Permissao> getPermissoes() {
		return user.getPermissoes();
	}

	public void gravar() {
		this.usuario.setPermissao(user.getPermissaoByID(idPermissao));
		user.adiciona(this.usuario);
		this.usuario = new Usuario();
	}

	public void excluir() {
		user.excluir(this.buscaUsuario().getId());
		this.usuario = new Usuario();
	}

	public void editar() {

        if(idPermissao2!=null){
		this.usuarioEditado.setPermissao(user.getPermissaoByID(idPermissao2));
        }
        if(usuarioEditado.getSenha().equals("")){
        	usuarioEditado.setSenha(buscaUsuario().getSenha());
        }
		user.editar(usuarioEditado);
		this.usuarioEditado = new Usuario();
		System.out.println(idPermissao2);
		System.out.println("senha"+buscaUsuario().getSenha());
		
	}

	public Usuario buscaUsuario(){

		return user.listaBusca(this.getUsuarioBusca());
	}

	public Integer getIdPermissao() {
		return idPermissao;
	}

	public void setIdPermissao(Integer idPermissao) {
		this.idPermissao = idPermissao;
	}

	public Integer getIdPermissao2() {
		return idPermissao2;
	}

	public void setIdPermissao2(Integer idPermissao2) {
		this.idPermissao2 = idPermissao2;
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

	public Usuario getUsuarioEditado() {
		return usuarioEditado;
	}

	public void setUsuarioEditado(Usuario usuarioEditado) {
		this.usuarioEditado = usuarioEditado;
	}
}