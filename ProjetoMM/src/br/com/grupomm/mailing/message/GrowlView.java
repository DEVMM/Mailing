package br.com.grupomm.mailing.message;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "growlView")
public class GrowlView {

	public void showMessage() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aprova��o", "Realizada com sucesso");

		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	
	public void data() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "A data inicial � maior que a data final");

		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	
	public void dataAlerta() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Preencha as 2 datas");

		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}

	public void buscaAlerta() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Preencha pelo menos um campo");

		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}

	public void msgAdiciona() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "Adicionado com sucesso");

		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}

	public void naoAprovada() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aprova��o", "N�o realizada");

		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}

	public static void msgRelatorio() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Relat�rio Gerado com sucesso!", "Aguarde a aprova��o");

		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	public static void  msgValidaCheckBox(){
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Falha Ao enviar", "Selecione ao menos um item de cada categoria");

		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	public static void usarioExcluido() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "Inativo");

		RequestContext.getCurrentInstance().showMessageInDialog(message);
		
	
	}
	
	public static String usarioAtivo() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "Ativado");

		RequestContext.getCurrentInstance().showMessageInDialog(message);
		
		return "gerenciamento";
	}

	public static void usarioAtualizado() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "Atualizado com sucesso");

		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	public static void erro(Exception e) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", e.toString());
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	public static void validaLogin() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", "Usuario ja cadastrado");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}

	public static void nulo() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado em branco ", "A busca n�o encontrou resultados");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		
	}
}