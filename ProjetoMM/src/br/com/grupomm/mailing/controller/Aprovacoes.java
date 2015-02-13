package br.com.grupomm.mailing.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.grupomm.mailing.dao.AprovacaoDAO;
import br.com.grupomm.mailing.model.bo.AprovacoesBO;
import br.com.grupomm.mailing.model.entity.Solicitacao;

@ManagedBean
@ViewScoped
public class Aprovacoes {

	Solicitacao solicitacao;
	String motivo;
	
	List<Solicitacao> solicitacaoList = new AprovacaoDAO().listaSolicitacao();

	public List<Solicitacao> getSolicitacaoList() {
		return solicitacaoList;
	}
 
	public String aprovar(){
		AprovacoesBO aprovacoesBO = new AprovacoesBO();
		aprovacoesBO.gravarAprovacao(this.getSolicitacao(),this.getMotivo());

		return "aprovacoes";
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}
