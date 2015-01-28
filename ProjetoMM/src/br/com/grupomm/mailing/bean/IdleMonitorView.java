package br.com.grupomm.mailing.bean;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
@ManagedBean
public class IdleMonitorView {
     
    public void onIdle() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, 
                                        "Nenhuma atividade.", "O que você está fazendo por aí?"));
    }
 
    public void onActive() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                                        "Bem vindo de volta", "Bem, Foi uma longa saidinha!"));
    }
}