package br.com.grupomm.mailing.message;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "growlView")
public class GrowlView {

	public static void showMessage(String assunto, String descricao) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, assunto, descricao);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	public static void Info(String assunto, String descricao){
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_WARN,
						assunto,
						descricao));
	}
	public static void erro(String assunto, String descricao){
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
						assunto,
						descricao));
	}

}