package br.com.grupomm.mailing.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.grupomm.mailing.model.enuns.TipoPermissao;

@Entity
public class Permissao implements Serializable {

	private static final long serialVersionUID = -2874388727134926782L;
	@Id @GeneratedValue
	private Integer id;
	@Enumerated(EnumType.STRING)
	private TipoPermissao nomePermissao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public TipoPermissao getNomePermissao() {
		return nomePermissao;
	}
	public void setNomePermissao(TipoPermissao nomePermissao) {
		this.nomePermissao = nomePermissao;
	}
}
