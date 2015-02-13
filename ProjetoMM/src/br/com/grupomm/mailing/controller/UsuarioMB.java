package br.com.grupomm.mailing.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.grupomm.mailing.dao.UsuarioDAO;
import br.com.grupomm.mailing.model.entity.Departamento;
import br.com.grupomm.mailing.model.entity.Permissao;
import br.com.grupomm.mailing.model.entity.Solicitacao;
import br.com.grupomm.mailing.model.entity.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioMB {

	private Usuario usuario = new Usuario();
	private String solicitacao = new String();
	private Usuario usuarioEditado = new Usuario();
	private Integer idPermissao = new Integer(0);
	private Integer idDepartamento = new Integer(0);
	private Integer idDepartamento2 = new Integer(0);
	private Integer idPermissao2 = new Integer(0);
	private int usuarioBusca;
	private UsuarioDAO user = new UsuarioDAO();

	public Usuario getUsuario() {
		return usuario;
	}

	public  List<Permissao> getPermissoes() {
		return user.getPermissoes();
	}
	public  List<Departamento> getDepartamento() {
		return user.getDepartamento();
	}
	
	public String gravar() throws Exception{
	    
		String s = this.usuario.getSenha();
		MessageDigest m=MessageDigest.getInstance("MD5");
		m.update(s.getBytes(),0,s.length());
		String usuarioCrip=new BigInteger(1,m.digest()).toString(16);
		usuario.setSenha(usuarioCrip.toString());
		
		user.adiciona(this.usuario, this.idPermissao, this.idDepartamento, this.solicitacao);
		this.usuario = new Usuario();
		
		return "gerenciamento";
	}

	public String inativar() {
		user.inativarUsuario(this.usuarioBusca);
		this.usuario = new Usuario();
	 return "gerenciamento";
	}

	public String editar() throws Exception {

		if(idPermissao2!=null){
			//this.usuarioEditado.setPermissao(user.getPermissaoByID(idPermissao2));
			Permissao permissao = new Permissao();
			permissao.setId(idPermissao2);
			usuarioEditado.setPermissao(permissao);
		}
		if(idDepartamento2!=null){
			Departamento departamento = new Departamento();
			departamento.setId(idDepartamento2);
			usuarioEditado.setDepartamento(departamento);
		}
		
		if(usuarioEditado.getSenha().equals("")){
			usuarioEditado.setSenha(buscaUsuario().getSenha());
		}
		if(usuarioEditado.getSenha()!=""){
			
			String s = this.usuarioEditado.getSenha();
			MessageDigest m=MessageDigest.getInstance("MD5");
			m.update(s.getBytes(),0,s.length());
			String usuarioCrip=new BigInteger(1,m.digest()).toString(16);
			usuarioEditado.setSenha(usuarioCrip.toString());
		}
		user.editar(usuarioEditado);
		this.usuarioEditado = new Usuario();
		System.out.println(idPermissao2);
		System.out.println("senha"+buscaUsuario().getSenha());
		
		return "gerenciamento";
	}
	
	List<Usuario> usuarioLista = new UsuarioDAO().listaUsuario();

	public List<Usuario> getSolicitacaoList() {
		return usuarioLista;
	}

	public Usuario buscaUsuario(){

		return user.listaBusca(this.usuarioBusca);
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
		this.idPermissao2 = usuarioEditado.getPermissao().getId();
		this.idDepartamento2 = usuarioEditado.getDepartamento().getId();
	}

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public Integer getIdDepartamento2() {
		return idDepartamento2;
	}

	public void setIdDepartamento2(Integer idDepartamento2) {
		this.idDepartamento2 = idDepartamento2;
	}

	public int getUsuarioBusca() {
		return usuarioBusca;
	}

	public void setUsuarioBusca(int usuarioBusca) {
		this.usuarioBusca = usuarioBusca;
	}

	public List<Usuario> getUsuarioLista() {
		return usuarioLista;
	}

	public void setUsuarioLista(List<Usuario> usuarioLista) {
		this.usuarioLista = usuarioLista;
	}
}

