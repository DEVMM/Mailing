package br.com.grupomm.mailing.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Permissao implements Serializable {

	private static final long serialVersionUID = -2874388727134926782L;
	@Id @GeneratedValue
	Integer id;
	String nomePermissao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomePermissao() {
		return nomePermissao;
	}
	public void setNomePermissao(String nomePermissao) {
		this.nomePermissao = nomePermissao;
	}
}
