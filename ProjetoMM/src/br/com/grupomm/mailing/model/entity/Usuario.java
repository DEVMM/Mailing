package br.com.grupomm.mailing.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import br.com.grupomm.mailing.model.enuns.Status;

@Entity
@Table(name="Usuario", uniqueConstraints={@UniqueConstraint(columnNames={"nome"})})  
public class Usuario implements Serializable  {

	private static final long serialVersionUID = -1482972456930062666L;

	@Id @GeneratedValue
	Integer id;
	String login;
	String senha;
	String nome;
	String email;
	@Enumerated(EnumType.STRING)
	Status status;
	
	@ManyToOne
	Permissao permissao;
	
	@ManyToOne
	Departamento departamento;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Permissao getPermissao() {
		return permissao;
	}
	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
