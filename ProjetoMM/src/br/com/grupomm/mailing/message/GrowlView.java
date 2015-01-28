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


}