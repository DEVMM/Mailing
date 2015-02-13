package br.com.grupomm.mailing.model.bo;

import org.apache.commons.mail.EmailException;
import br.com.grupomm.mailing.dao.AprovacaoDAO;
import br.com.grupomm.mailing.message.GrowlView;
import br.com.grupomm.mailing.model.entity.Solicitacao;
import br.com.grupomm.mailing.util.Util;

public class AprovacoesBO {

	public void gravarAprovacao(Solicitacao solicitacao, String moString){
		AprovacaoDAO aprovacaoDAO = new AprovacaoDAO();
		EnviaEmail enviaEmail = new EnviaEmail();

		if(solicitacao.getStatus().equalsIgnoreCase("Reprovado")){

			String msgUsr="<html>\n "
					+ "<body>\n  "
					+ "<h1>Solicitação Reprorvado por "+Util.getUserName()+"</h1>\n "
					+ "<br/>\n"
					+ " Numero: "+solicitacao.getId()+""
					+ "<p>descricao: "+solicitacao.getDescricao()+"</p>"
					+ "<p>motivo: "+moString+"</p>"
					+ "<br/> \n<a>www.meiomensagem.com.br/</a>\n"
					+ " </body> \n "
					+ "</html> \n";
			try {
				enviaEmail.enviarEmailSolicitante(Util.getEmail(),msgUsr, solicitacao);
			} catch (EmailException e) {
				e.printStackTrace();
			}
		}

		else{
			String msgUsr="<html>\n "
					+ "<body>\n  "
					+ "<h1>Solicitação aprovada!</h1>\n "
					+ "<br/>\n"
					+ " Numero: "+solicitacao.getId()+""
					+ "<p>descricao: "+solicitacao.getDescricao()+"</p>"
					+ "<br/> \n  <a>localhost:8181/ProjetoMM/index.xhtml/n</a>\n"
					+ " </body> \n "
					+ "</html> \n";
			try {
				enviaEmail.enviarEmailSolicitante(Util.getEmail(),msgUsr, solicitacao);
			} catch (EmailException e) {
				e.printStackTrace();
			}
		}

		try {
			
			aprovacaoDAO.alterAprovacao(solicitacao, moString);

		} catch (Exception e) {
			GrowlView.erro(e);
		}
	}
}
