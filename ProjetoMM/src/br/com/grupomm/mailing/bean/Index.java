package br.com.grupomm.mailing.bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

import br.com.grupomm.mailing.controller.IndexControl;
import br.com.grupomm.mailing.controller.Util;
import br.com.grupomm.mailing.dao.IndexDAO;
import br.com.grupomm.mailing.entity.Solicitacao;

@ManagedBean
@ViewScoped
public class Index {

	HttpSession session = Util.getSession();
	String usr = session.getAttribute("nome").toString();
	int ids;
	String tipoSolicitacao;
	IndexDAO indexDAO = new IndexDAO();
	List<Solicitacao> provacoesList = new IndexDAO().listaAprovados(usr);

	public void gerarRelatorio() throws IOException {

		IndexControl indexControl = new IndexControl();

		if(this.getTipoSolicitacao().equalsIgnoreCase("Anuarios")){
			indexControl.excelAnuarios(this.getIds()); 
		}
		if(this.getTipoSolicitacao().equalsIgnoreCase("MM-online")){
			 indexControl.excelMM(this.getIds());  
		}
		
	System.out.println("foi 2");
	
	}

	public String removerSolicitacao(){
	     IndexDAO indexDAO = new IndexDAO();
	     indexDAO.removerSolicitacao(this.getIds());
	     return "index";
	}
	
	//getts and setts
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
