package br.com.grupomm.mailing.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import br.com.grupomm.mailing.dao.IndexDAO;
import br.com.grupomm.mailing.model.entity.Solicitacao;

@ManagedBean
@ViewScoped
public class IndexMB implements Serializable{

	private static final long serialVersionUID = 3648115893925054320L;
	int ids;
	String tipoSolicitacao;
	IndexDAO indexDAO = new IndexDAO();
	List<Solicitacao> provacoesList = indexDAO.listaAprovados();
    Boolean loading =false;

	@SuppressWarnings("static-access")
	public String gerarRelatorio() throws IOException {
		GerarRelatorios indexControl = new GerarRelatorios();

		if(this.getTipoSolicitacao().equalsIgnoreCase("Anuarios")){
			indexControl.excelAnuarios(this.getIds()); 
		}
		if(this.getTipoSolicitacao().equalsIgnoreCase("MM-online")){
			if(indexControl.excelMM(this.getIds()))
			{
//				RequestContext requestContext = RequestContext.getCurrentInstance();  
//				  requestContext.execute("document.getElementByClassName('loader')[0].style.display = 'none'");
//				  requestContext.execute("console.log('passou')");
				
				return "alert('lalalala')";
				  
			}
		}
		
		
		return "";
	}

	public String redirect(){
		return "index?faces-redirect=true";
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

	public Boolean getLoading() {
		return loading;
	}

	public void setLoading(Boolean loading) {
		this.loading = loading;
	}	
	
	
}
