package br.com.grupomm.mailing.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;

import br.com.grupomm.mailing.controller.Util;
import br.com.grupomm.mailing.dao.IdUsuarioLogado;
import br.com.grupomm.mailing.dao.LoginDAO;

@ManagedBean
@ViewScoped
public class Permissao {

	private List<String> valida = new ArrayList<String>();
	String vUsuario;
	HttpSession session = Util.getSession();
	String usr = session.getAttribute("nome").toString();
	String permissao = LoginDAO.permissao(usr);

	int idUsuario = new IdUsuarioLogado().UsuarioLogado(usr);
   
	public void valida(ValueChangeEvent event){
		String[] check = (String[]) event.getNewValue();
		for(int i =0; i< check.length; i++){
			valida.add(check[i]);
		}
	}

	//getts and setts
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
