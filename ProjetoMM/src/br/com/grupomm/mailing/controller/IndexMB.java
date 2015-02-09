package br.com.grupomm.mailing.controller;

import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.grupomm.mailing.dao.IndexDAO;
import br.com.grupomm.mailing.model.entity.Solicitacao;

@ManagedBean
@ViewScoped
public class IndexMB {

	int ids;
	String tipoSolicitacao;
	IndexDAO indexDAO = new IndexDAO();
	List<Solicitacao> provacoesList = indexDAO.listaAprovados();

	public void gerarRelatorio() throws IOException {

		GerarRelatorios indexControl = new GerarRelatorios();

		if(this.getTipoSolicitacao().equalsIgnoreCase("Anuarios")){
			indexControl.excelAnuarios(this.getIds()); 
		}
		if(this.getTipoSolicitacao().equalsIgnoreCase("MM-online")){
			 indexControl.excelMM(this.getIds());  
		}
	}

	public String removerSolicitacao(){
	     IndexDAO indexDAO = new IndexDAO();
	     indexDAO.removerSolicitacao(this.getIds());
	     return "index";
	}
	public IndexDAO getIndexDAO() {
		return indexDAO;
	}

	public void setIndexDAO(IndexDAO indexDAO) {
		this.indexDAO = indexDAO;
	}
	public List<Solicitacao> getProvacoesList() {
		return provacoesList;
	}

	public void setProvacoesList(List<Solicitacao> provacoesList) {
		this.provacoesList = provacoesList;
	}

	public void listaAprovados(){
	}

	public int getIds() {
		return ids;
	}

	public void setIds(int ids) {
		this.ids = ids;
	}
	public String getTipoSolicitacao() {
		return tipoSolicitacao;
	}

	public void setTipoSolicitacao(String tipoSolicitacao) {
		this.tipoSolicitacao = tipoSolicitacao;
	}	

}
