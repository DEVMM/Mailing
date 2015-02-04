package br.com.grupomm.mailing.model.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
public class Solicitacao {
	 
	@Id @GeneratedValue
	   Integer id;
	   String status;
	   @Type(type="text")
	   String query;
	   int quantidade;
	   @Temporal(TemporalType.DATE)
	   Calendar dt;
	   @ManyToOne
	   Usuario usuario;
	   String tipoSolicitacao;
	   
	   public int getQuantidade() {
		return quantidade;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public int aguardando() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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
}
