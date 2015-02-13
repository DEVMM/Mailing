package br.com.grupomm.mailing.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;

import br.com.grupomm.mailing.dao.IdUsuarioLogado;
import br.com.grupomm.mailing.dao.LoginDAO;
import br.com.grupomm.mailing.model.bo.AnuariosBO;
import br.com.grupomm.mailing.model.bo.MmBO;
import br.com.grupomm.mailing.model.entity.Solicitacao;
import br.com.grupomm.mailing.model.enuns.Area;
import br.com.grupomm.mailing.model.enuns.Estados;
import br.com.grupomm.mailing.model.enuns.Nivel;
import br.com.grupomm.mailing.model.enuns.Porte;
import br.com.grupomm.mailing.model.enuns.RamoAtividade;
import br.com.grupomm.mailing.model.enuns.Sexo;
import br.com.grupomm.mailing.util.Util;

@ManagedBean
@ViewScoped
public class MM {
	
	private List<String> valida = new ArrayList<String>();
	Solicitacao solicitacao = new Solicitacao();
	
	public String validacao(){
		MmBO mmControl = new MmBO();

		if(mmControl.Valida(valida)!=null){
			System.out.println(mmControl.Valida(valida));
			this.solicitacao.setQuantidade(mmControl.Valida(valida));
		}
		return "";
	}
	
	public String gerarRelatorio(){
		System.out.println("TEste");
		MmBO mmBO = new MmBO();
		mmBO.gerar(valida, this.getSolicitacao());
		return "index";
	}
	
	public void valida(ValueChangeEvent event){
		String[] check = (String[]) event.getNewValue();
		for(int i =0; i< check.length; i++){
			valida.add(check[i]);
		}
	}

	public void setValida(List<String> valida) {
		this.valida = valida;
	}
    public List<Estados> getEstados(){
    	return (List<Estados>) Arrays.asList(Estados.values());
    }
    public List<RamoAtividade> getRamoAtividade(){
    	return (List<RamoAtividade>) Arrays.asList(RamoAtividade.values());
    } 
    public List<Sexo> getSexo(){
    	return (List<Sexo>) Arrays.asList(Sexo.values());
    } 
    public List<Area> getArea(){
    	return (List<Area>) Arrays.asList(Area.values());
    }
    public List<Nivel> getNivel(){
    	return (List<Nivel>) Arrays.asList(Nivel.values());
    }
    public List<Porte> getPorte(){
    	return (List<Porte>) Arrays.asList(Porte.values());
    }

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}
}
