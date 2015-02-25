package br.com.grupomm.mailing.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.poi.hssf.util.HSSFColor.GOLD;

import br.com.grupomm.mailing.dao.IndexDAO;
import br.com.grupomm.mailing.message.GrowlView;
import br.com.grupomm.mailing.model.bo.AprovacoesBO;
import br.com.grupomm.mailing.model.entity.Solicitacao;
import br.com.grupomm.mailing.util.BuscaComposite;

@ManagedBean
@ViewScoped
public class IndexMB implements Serializable{

	private BuscaComposite busca = new BuscaComposite();

	private static final long serialVersionUID = 3648115893925054320L;
	Solicitacao solicitacao;
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

	public List<Solicitacao> alterStatus(){

		this.provacoesList.clear();   
		indexDAO.alterStatus(this.getSolicitacao());
		this.setProvacoesList(indexDAO.buscaAvancadaDAO(busca));	
		return provacoesList;
	}
	public List<Solicitacao> busca(){

		System.out.println(this.getBusca().getNrSolicitacao());
		System.out.println(this.getBusca().getDescricao());
		System.out.println(this.getBusca().getDataFrom());
		System.out.println(this.getBusca().getDataFor());
		System.out.println(this.getBusca().getTipo());
		System.out.println(this.getBusca().getStatus());	

		IndexDAO indexDAO = new IndexDAO();

		if (busca.getDataFrom() != null && busca.getDataFor() != null){
			if (busca.getDataFrom().after(busca.getDataFor())){
				
				GrowlView.showMessage("Aviso", "A data inicial é maior que a data final");
			}

		}

		else if((busca.getDataFrom() != null && busca.getDataFor() ==null) 
				|| (busca.getDataFrom() == null && busca.getDataFor() !=null) )
		{
			GrowlView.showMessage( "Aviso", "Preencha as duas datas");
		}
		this.provacoesList.clear();
		this.setProvacoesList(indexDAO.buscaAvancadaDAO(busca));	
		return provacoesList;
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

	public BuscaComposite getBusca() {
		return busca;
	}

	public void setBusca(BuscaComposite busca) {
		this.busca = busca;
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}	
}
