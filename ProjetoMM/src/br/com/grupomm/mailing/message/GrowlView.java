package br.com.grupomm.mailing.message;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "growlView")
public class GrowlView {

	public void showMessage() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aprovação", "Realizada com sucesso");

		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	
	public void data() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "A data inicial é maior que a data final");

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
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário", "Adicionado com sucesso");

		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}

	public void naoAprovada() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aprovação", "Não realizada");

		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}

	public static void msgRelatorio() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Relatório Gerado com sucesso!", "Aguarde a aprovação");

		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	public static void  msgValidaCheckBox(){
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Falha Ao enviar", "Selecione ao menos um item de cada categoria");

		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	public static void usarioExcluido() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário", "Inativo");

		RequestContext.getCurrentInstance().showMessageInDialog(message);
		
	
	}
	
	public static String usarioAtivo() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário", "Ativado");

		RequestContext.getCurrentInstance().showMessageInDialog(message);
		
		return "gerenciamento";
	}

	public static void usarioAtualizado() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário", "Atualizado com sucesso");

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
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado em branco ", "A busca não encontrou resultados");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		
	}
}