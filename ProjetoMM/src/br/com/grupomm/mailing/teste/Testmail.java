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


     public void enviarEmail(Usuario usuario, List<Usuario> emails, Solicitacao solicitacao,String msg ) throws EmailException{
		
		HtmlEmail email = new HtmlEmail();
		email.setHostName("mail.grupomm.com.br");
		email.setAuthenticator(new DefaultAuthenticator("mailingsystem@grupomm.com.br", "123@456@mm"));
		//email.setSSLOnConnect(true);
		email.setTLS(true);
		email.setSmtpPort(587);
		email.setFrom("mailingsystem@grupomm.com.br");
		email.setSubject("solicitacao xyz");
		email.setHtmlMsg("<html>\n" +
				"<body>\n" +
				""+msg+""
				+ "<br/><br/>\n" +
				"Numero: xyz<br/>\n" +
				"descricao:"+solicitacao.getDescricao()+"<br/>\n" +
				"<a>http://localhost:8181/ProjetoMM/index.xhtml</a>\n" +
				"</body>\n" +
				"</html>");

		email.setTextMsg("solicitacao xyz");
		email.addTo(usuario.getEmail());

		List<InternetAddress> bbcList = new ArrayList<InternetAddress>();
		for (Usuario emailUsuario : emails) {

			InternetAddress send = new InternetAddress();
			send.setAddress(emailUsuario.getEmail());
			bbcList.add(send);
		}
		email.setBcc(bbcList);
		email.send();
	}
	
}
