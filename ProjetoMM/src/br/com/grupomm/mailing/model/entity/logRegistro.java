package br.com.grupomm.mailing.model.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class logRegistro implements Serializable{
	
	private static final long serialVersionUID = -5558689463757464464L;
	@Id @GeneratedValue
	Integer id;
	 @Temporal(TemporalType.DATE)
	 Calendar dt;
	String motivoRejeicao;
	@ManyToOne
	Usuario usuario;
	@ManyToOne
	Solicitacao solicitacao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Calendar getDt() {
		return dt;
	}
	public void setDt(Calendar dt) {
		this.dt = dt;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Solicitacao getSolicitacao() {
		return solicitacao;
	}
	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}
	public String getMotivoRejeicao() {
		return motivoRejeicao;
	}
	public void setMotivoRejeicao(String motivoRejeicao) {
		this.motivoRejeicao = motivoRejeicao;
	}	
}
