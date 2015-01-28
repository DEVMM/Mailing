package br.com.grupomm.mailing.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;

import br.com.grupomm.mailing.controller.AnuariosControl;
import br.com.grupomm.mailing.controller.Util;
import br.com.grupomm.mailing.dao.IdUsuarioLogado;
import br.com.grupomm.mailing.dao.LoginDAO;
import br.com.grupomm.mailing.enuns.AreaAnuarios;
import br.com.grupomm.mailing.enuns.Estados;
import br.com.grupomm.mailing.enuns.NivelAnuarios;
import br.com.grupomm.mailing.enuns.Porte;
import br.com.grupomm.mailing.enuns.RamoAtividadeAnuarios;

@ManagedBean
@ViewScoped
public class Anuarios {

	List<Estados> estados = (List<Estados>) Arrays.asList(Estados.values());
	List<NivelAnuarios> nivelAnuarios = (List<NivelAnuarios>) Arrays.asList(NivelAnuarios.values());
	List<RamoAtividadeAnuarios> ramoAtividadeAnuarios = (List<RamoAtividadeAnuarios>) Arrays.asList(RamoAtividadeAnuarios.values());
	List<AreaAnuarios> areaAnuarios = (List<AreaAnuarios>) Arrays.asList(AreaAnuarios.values());
	List<Porte> porte = (List<Porte>) Arrays.asList(Porte.values());

	private List<String> valida = new ArrayList<String>();
	String vUsuario;
	HttpSession session = Util.getSession();
	String usr = session.getAttribute("nome").toString();
	String permissao = LoginDAO.permissao(usr);

	int idUsuario = new IdUsuarioLogado().UsuarioLogado(usr);

	public String gerarRelatorio(){
		AnuariosControl anuariosControl = new AnuariosControl();
		return anuariosControl.gerarRelatorio(valida, idUsuario);
	}
   

	
	public void valida(ValueChangeEvent event){
		String[] check = (String[]) event.getNewValue();
		for(int i =0; i< check.length; i++){
			valida.add(check[i]);
		}
	}


	//getts and setts
	public List<Estados> getEstados() {
		return estados;
	}


	public void setEstados(List<Estados> estados) {
		this.estados = estados;
	}


	public List<NivelAnuarios> getNivelAnuarios() {
		return nivelAnuarios;
	}


	public void setNivelAnuarios(List<NivelAnuarios> nivelAnuarios) {
		this.nivelAnuarios = nivelAnuarios;
	}


	public List<RamoAtividadeAnuarios> getRamoAtividadeAnuarios() {
		return ramoAtividadeAnuarios;
	}


	public void setRamoAtividadeAnuarios(
			List<RamoAtividadeAnuarios> ramoAtividadeAnuarios) {
		this.ramoAtividadeAnuarios = ramoAtividadeAnuarios;
	}


	public List<AreaAnuarios> getAreaAnuarios() {
		return areaAnuarios;
	}


	public void setAreaAnuarios(List<AreaAnuarios> areaAnuarios) {
		this.areaAnuarios = areaAnuarios;
	}


	public List<Porte> getPorte() {
		return porte;
	}


	public void setPorte(List<Porte> porte) {
		this.porte = porte;
	}


	public List<String> getValida() {
		return valida;
	}


	public String getPermissao() {
		return permissao;
	}


	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}
	public String getvUsuario() {
		return vUsuario;
	}

	public void setvUsuario(String vUsuario) {
		this.vUsuario = vUsuario;
	}



	public void setValida(List<String> valida) {
		this.valida = valida;
	}
}
