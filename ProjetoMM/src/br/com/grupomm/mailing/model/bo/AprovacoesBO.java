package br.com.grupomm.mailing.model.bo;

import org.apache.commons.mail.EmailException;

import br.com.grupomm.mailing.dao.AprovacaoDAO;
import br.com.grupomm.mailing.message.GrowlView;
import br.com.grupomm.mailing.model.entity.Solicitacao;
import br.com.grupomm.mailing.model.enuns.StatusSolicitacao;
import br.com.grupomm.mailing.util.Util;

public class AprovacoesBO {

	public void gravarAprovacao(Solicitacao solicitacao, String moString){
		AprovacaoDAO aprovacaoDAO = new AprovacaoDAO();
		EnviaEmail enviaEmail = new EnviaEmail();

		if(solicitacao.getStatus().equals(StatusSolicitacao.Reprovado)){

			String msgUsr="<html>\n "
					+ "<body>\n  "
					+ "<h1>Solicitação reprovada por "+Util.getUserName()+"</h1>\n "
					+ "<br/>\n"
					+ " Numero: "+solicitacao.getId()+""
					+ "<p>descricao: "+solicitacao.getDescricao()+"</p>"
					+ "<p>motivo: "+moString+"</p>"
					+ "<br/> \n<a>www.meiomensagem.com.br/</a>\n"
					+ " </body> \n "
					+ "</html> \n";
			try {
				enviaEmail.enviarEmailSolicitante(solicitacao.getUsuario().getEmail(),msgUsr, solicitacao);
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
				enviaEmail.enviarEmailSolicitante(solicitacao.getUsuario().getEmail(),msgUsr, solicitacao);
			} catch (EmailException e) {
				e.printStackTrace();
			}
		}

		try {

			aprovacaoDAO.alterAprovacao(solicitacao, moString);

		} catch (Exception e) {
			GrowlView.erro("Erro","Tente Novamente!");
		}
	}
}
