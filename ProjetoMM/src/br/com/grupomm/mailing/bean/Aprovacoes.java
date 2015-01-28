package br.com.grupomm.mailing.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.grupomm.mailing.dao.AprovacaoDAO;
import br.com.grupomm.mailing.entity.Solicitacao;

@ManagedBean
@ViewScoped
public class Aprovacoes {
    
	int id;
	String status; 
	
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
    	AprovacaoDAO aprovacaoDAO = new AprovacaoDAO();
    	aprovacaoDAO.alterAprovacao(this.getId(), this.getStatus());
    	
    	return "/aprovacoes.xhtml";
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

  
}
