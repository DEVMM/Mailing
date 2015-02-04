package br.com.grupomm.mailing.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import br.com.grupomm.mailing.model.bo.AnuariosBO;
import br.com.grupomm.mailing.model.enuns.AreaAnuarios;
import br.com.grupomm.mailing.model.enuns.Estados;
import br.com.grupomm.mailing.model.enuns.NivelAnuarios;
import br.com.grupomm.mailing.model.enuns.Porte;
import br.com.grupomm.mailing.model.enuns.RamoAtividadeAnuarios;

@ManagedBean
@ViewScoped
public class Anuarios {

	private List<String> valida = new ArrayList<String>();

	public String gerarRelatorio(){
		AnuariosBO anuariosControl = new AnuariosBO();
		return anuariosControl.gerarRelatorio(valida);
	}

	public void valida(ValueChangeEvent event){
		String[] check = (String[]) event.getNewValue();
		for(int i =0; i< check.length; i++){
			valida.add(check[i]);
		}
	}
	
	public List<Estados> getEstados(){
		return (List<Estados>) Arrays.asList(Estados.values());
	}

	public List<NivelAnuarios> getNivelAnuarios(){
		return (List<NivelAnuarios>) Arrays.asList(NivelAnuarios.values());
	}

	public List<RamoAtividadeAnuarios> getRamoAtividadeAnuarios(){
		return (List<RamoAtividadeAnuarios>) Arrays.asList(RamoAtividadeAnuarios.values());
	}

	public List<AreaAnuarios> getAreaAnuarios(){
		return (List<AreaAnuarios>) Arrays.asList(AreaAnuarios.values());
	}

	public List<Porte> getPorte(){
		return (List<Porte>) Arrays.asList(Porte.values());
	}

	public List<String> getValida() {
		return valida;
	}

	public void setValida(List<String> valida) {
		this.valida = valida;
	}
}
