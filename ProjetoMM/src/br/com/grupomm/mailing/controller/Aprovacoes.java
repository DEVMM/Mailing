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
    
	private int id;
	private String status; 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	

	List<Solicitacao> solicitacaoList = new AprovacaoDAO().listaSolicitacao();

	public List<Solicitacao> getSolicitacaoList() {
		return solicitacaoList;
	}

    public String aprovar(){
    	AprovacoesBO aprovacaoDAO = new AprovacoesBO();
    	aprovacaoDAO.gravarAprovacao(this.getId(), this.getStatus());
    	
    	return "/aprovacoes.xhtml";
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
