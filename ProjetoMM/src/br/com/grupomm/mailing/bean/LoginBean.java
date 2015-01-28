package br.com.grupomm.mailing.bean;
 
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.grupomm.mailing.controller.Util;
import br.com.grupomm.mailing.dao.LoginDAO;
 
@ManagedBean(name ="loginBean")
@SessionScoped

public class LoginBean implements Serializable {
 
    private static final long serialVersionUID = 1L;
    private String senha;
    private String message, nome;
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public String getSenha() {
        return senha;
    }
 
    public void setSenha(String senha) {
        this.senha = senha;
    }
 
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
 
    public String loginProject() {
        boolean result = LoginDAO.login(nome, senha);
        if (result) {
        	
            // get Http Session and store username
            HttpSession session = Util.getSession();
            session.setAttribute("nome", nome);
            session.setAttribute("usuarioLogado", nome);
            String usr = session.getAttribute("nome").toString();
        	String permissao = LoginDAO.permissao(usr);
            
            
            if(permissao.equals("Aprovador")){
            	return "aprovacoes";
            }else{
            	return "index";
            }
        } 
        else {
 
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Login inválido!",
                    "Por favor, tente de novo"));

            return "login";
        }
    }
 
    public String logout() {
      HttpSession session = Util.getSession();
      session.invalidate();
      return "login";
   }
}