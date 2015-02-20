package br.com.grupomm.mailing.model.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import br.com.grupomm.mailing.model.enuns.StatusSolicitacao;

@Entity
public class Solicitacao implements Serializable{

	private static final long serialVersionUID = -1340155712400685744L;
	@Id @GeneratedValue
	private Integer id;
	@Enumerated(EnumType.STRING)   
	private StatusSolicitacao status;
	@Type(type="text")
	private String query;
	private String quantidade;
	private String descricao;
	@Temporal(TemporalType.DATE)
	private Calendar dt;
	@ManyToOne
	private Usuario usuario;
	private String tipoSolicitacao;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public StatusSolicitacao getStatus() {
		return status;
	}
	public void setStatus(StatusSolicitacao status) {
		this.status = status;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String aguardando() {
		return quantidade;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Calendar getDt() {
		return dt;
	}
	public void setDt(Calendar dt) {
		this.dt = dt;
	}
	public String getTipoSolicitacao() {
		return tipoSolicitacao;
	}
	public void setTipoSolicitacao(String tipoSolicitacao) {
		this.tipoSolicitacao = tipoSolicitacao;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
