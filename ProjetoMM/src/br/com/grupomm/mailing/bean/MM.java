package br.com.grupomm.mailing.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;

import br.com.grupomm.mailing.controller.MMControl;
import br.com.grupomm.mailing.controller.Util;
import br.com.grupomm.mailing.dao.IdUsuarioLogado;
import br.com.grupomm.mailing.dao.LoginDAO;
import br.com.grupomm.mailing.enuns.Area;
import br.com.grupomm.mailing.enuns.Estados;
import br.com.grupomm.mailing.enuns.Nivel;
import br.com.grupomm.mailing.enuns.Porte;
import br.com.grupomm.mailing.enuns.RamoAtividade;
import br.com.grupomm.mailing.enuns.Sexo;

@ManagedBean
@ViewScoped
public class MM {


	List<Estados> estados = (List<Estados>) Arrays.asList(Estados.values());
	List<Sexo> sexo = (List<Sexo>) Arrays.asList(Sexo.values());
	List<RamoAtividade> ramoAtividade = (List<RamoAtividade>) Arrays.asList(RamoAtividade.values());
	List<Area> area = (List<Area>) Arrays.asList(Area.values());
	List<Nivel> nivel = (List<Nivel>) Arrays.asList(Nivel.values());
	List<Porte> porte = (List<Porte>) Arrays.asList(Porte.values());

	private List<String> valida = new ArrayList<String>();
	String vUsuario;
	HttpSession session = Util.getSession();
	String usr = session.getAttribute("nome").toString();
	String permissao = LoginDAO.permissao(usr);
	
	int idUsuario = new IdUsuarioLogado().UsuarioLogado(usr);
	
	public String gerarRelatorio(){
		MMControl mmControl = new MMControl();
		return mmControl.gerarRelatorio(valida, idUsuario);
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

	public List<Sexo> getSexo() {
		return sexo;
	}	

	public void setValida(List<String> valida) {
		this.valida = valida;
	}

	public List<RamoAtividade> getRamoAtividade() {
		return ramoAtividade;
	}

	public List<Area> getArea() {
		return area;
	}

	public List<Nivel> getNivel() {

		return nivel;
	}

	public List<Porte> getPorte() {
		return porte;
	}
	
	public String getvUsuario() {
		return vUsuario;
	}

	public void setvUsuario(String vUsuario) {
		this.vUsuario = vUsuario;
	}

}
