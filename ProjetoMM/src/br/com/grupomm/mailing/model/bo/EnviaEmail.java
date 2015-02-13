package br.com.grupomm.mailing.model.bo;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.InternetAddress;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import br.com.grupomm.mailing.dao.UsuarioDAO;
import br.com.grupomm.mailing.model.entity.Solicitacao;
import br.com.grupomm.mailing.model.entity.Usuario;
import br.com.grupomm.mailing.util.Util;

public class EnviaEmail {

	public void enviarEmailSolicitante(String solicitante,String msg, Solicitacao solicitacao) throws EmailException{

		HtmlEmail email = new HtmlEmail();
		email.setHostName("mail.grupomm.com.br");
		email.setAuthenticator(new DefaultAuthenticator("mailingsystem@grupomm.com.br", "123@456@mm"));
		email.setTLS(true);
		email.setSmtpPort(587);
		email.setFrom("mailingsystem@grupomm.com.br");
		email.setSubject("Solicitação "+ solicitacao.getId());
		email.setHtmlMsg(msg);
		email.addTo(solicitante);
		email.send();
	}
	public void enviarEmailAdm(String msg, Solicitacao solicitacao) throws EmailException{

		HtmlEmail email = new HtmlEmail();
		email.setHostName("mail.grupomm.com.br");
		email.setAuthenticator(new DefaultAuthenticator("mailingsystem@grupomm.com.br", "123@456@mm"));
		email.setTLS(true);
		email.setSmtpPort(587);
		email.setFrom("mailingsystem@grupomm.com.br");
		email.setSubject("Solicitação"+solicitacao.getId());
		email.setHtmlMsg(msg);

		email.setTextMsg("teste adm");
		List<Usuario> emails = new UsuarioDAO().usuarioADM();

		List<InternetAddress> bbcList = new ArrayList<InternetAddress>();

		for (Usuario emailadms : emails) {
			InternetAddress send = new InternetAddress();
			send.setAddress(emailadms.getEmail());
			bbcList.add(send);
		}
		email.setBcc(bbcList);
		email.send();
	}
}
