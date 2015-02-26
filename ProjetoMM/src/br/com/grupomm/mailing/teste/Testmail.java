package br.com.grupomm.mailing.teste;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.InternetAddress;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import br.com.grupomm.mailing.model.entity.Solicitacao;
import br.com.grupomm.mailing.model.entity.Usuario;

public class Testmail {


     @SuppressWarnings("deprecation")
	public void enviarEmail(/*Usuario usuario, List<Usuario> emails, Solicitacao solicitacao,String msg*/ ) throws EmailException{
		
    	 HtmlEmail email = new HtmlEmail();
 		email.setHostName("mail.exchange.locaweb.com.br");
 		email.setAuthenticator(new DefaultAuthenticator("mailingsystem@grupomm.com.br", "123@456@mm"));
 		email.setTLS(true);
 		email.setSmtpPort(587);
 		email.setFrom("mailingsystem@grupomm.com.br");
 		email.setSubject("Solicitação ");
 		email.setHtmlMsg("lalalal");
 		email.addTo("wfreitas@grupomm.com.br");
 		email.send();
	}
	public static void main(String[] args) {
		Testmail teste = new Testmail();
		try {
			teste.enviarEmail();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
