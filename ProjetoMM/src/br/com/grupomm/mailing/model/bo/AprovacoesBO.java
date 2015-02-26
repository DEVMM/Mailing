package br.com.grupomm.mailing.model.bo;

import java.text.SimpleDateFormat;

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

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    String dataFrom = dateFormat.format(solicitacao.getDt().getTime());
		
	    if(solicitacao.getStatus().equals(StatusSolicitacao.Reprovado)){

			String msgUsr="<!DOCTYPE html>"
					+ "	<html>"
					+ "		<head>"
					+ "		<meta charset='utf-8'>"
					+ "		<title>Mailing gerado com sucesso!</title>"
					+ "		</head>"
					+ "		<body>"
					+ "		<table cellpadding='0' cellspacing='0' width='590'>"
					+ "		<tr>"
					+ "		<td width='20' bgcolor='#0076bc'>&nbsp;</td>"
					+ "		<td valign='middle' bgcolor='#0076bc' height='55'>"
					+ "<img style='margin-top:6px;' src='http://mmimg.meioemensagem.com.br/EMK/Logo-MailingEmail.png' height='33' width='251' alt='Grupo M&M Mailing'/></td>"
					+ "		</tr>"
					+ "		<tr>"
					+ "		<td width='20'></td>"
					+ "		<td>"
					+ "		<table>"
					+ "		<tr>"
					+ "		<td height='20'>&nbsp;</td>"
					+ "		</tr>"
					+ "		<tr>"
					+ "		<td><font color='#0076bc' face='Arial, Helvetica, sans-serif' style='font-size:20px;'>"+solicitacao.getUsuario().getNome()+",</font></td>"
					+ "		</tr>"
					+ "		<tr>"
					+ "		<td><font color='#646264' face='Arial, Helvetica, sans-serif' style='font-size:18px;'>"
					+ "Seu mailing foi Reprovado por: "+Util.getEmail()+" </font></p></td>"
					+ "		</tr>"
					+ "				</table>"
					+ "		<table cellpadding='12' cellspacing='5'>"
					+ "		<tr bgcolor='#eaeaea'>"
					+ "		<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'>"
					+ "<strong>Status</strong></font></td>"
					+ "		<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'>Aguardando aprovação"
					+ "</font></td>"
					+ "		</tr>"
					+ "		<tr bgcolor='#fbfbfb'>"
					+ "		<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'><strong>ID da solicitação</strong></font></td>"
					+ "		<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'>"+solicitacao.getId()+"</font></td>"
					+ "		</tr>"
					+ "		<tr bgcolor='#eaeaea'>"
					+ "		<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'>"
					+ "<strong>Nome</strong></font></td>"
					+ "		<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'>Milene - nome de base teste</font>"
					+ "</td>"
					+ "		</tr>"
					+ "		<tr bgcolor='#fbfbfb'>"
					+ "		<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'>"
					+ "<strong>Data</strong></font></td>"
					+ "		<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'>"+dataFrom+"</font></td>"
					+ "		</tr>"
					+ "		</table>"
					+ "		</td>"
					+ "		</tr>"
					+ "		<tr>"
					+ "		<td width='20'>&nbsp;</td>"
					+ "		<td><p><font color='#646264' face='Arial, Helvetica, sans-serif' size='4'>Para mais informações acesse: <a style='color:#0076bc;' href='http://www.meioemensagem.com.br/mailing' title='Grupo M&M Mailing'>www.meioemensagem.com.br/mailing</a>"
					+ "</font></p></td>"
					+ "		</tr>"
					+ "		</table>"
					+ "		</body>"
					+ "		</html>";
			try {
				enviaEmail.enviarEmailSolicitante(solicitacao.getUsuario().getEmail(),msgUsr, solicitacao);
			} catch (EmailException e) {
				e.printStackTrace();
			}
		}

		else{
			String msgUsr="<!DOCTYPE html>"
					+ "	<html>"
					+ "		<head>"
					+ "		<meta charset='utf-8'>"
					+ "		<title>Mailing gerado com sucesso!</title>"
					+ "		</head>"
					+ "		<body>"
					+ "		<table cellpadding='0' cellspacing='0' width='590'>"
					+ "		<tr>"
					+ "		<td width='20' bgcolor='#0076bc'>&nbsp;</td>"
					+ "		<td valign='middle' bgcolor='#0076bc' height='55'>"
					+ "<img style='margin-top:6px;' src='http://mmimg.meioemensagem.com.br/EMK/Logo-MailingEmail.png' height='33' width='251' alt='Grupo M&M Mailing'/></td>"
					+ "		</tr>"
					+ "		<tr>"
					+ "		<td width='20'></td>"
					+ "		<td>"
					+ "		<table>"
					+ "		<tr>"
					+ "		<td height='20'>&nbsp;</td>"
					+ "		</tr>"
					+ "		<tr>"
					+ "		<td><font color='#0076bc' face='Arial, Helvetica, sans-serif' style='font-size:20px;'>"+solicitacao.getUsuario().getNome()+",</font></td>"
					+ "		</tr>"
					+ "		<tr>"
					+ "		<td><font color='#646264' face='Arial, Helvetica, sans-serif' style='font-size:18px;'>"
					+ "Seu mailing foi aprovado!</font></p></td>"
					+ "		</tr>"
					+ "				</table>"
					+ "		<table cellpadding='12' cellspacing='5'>"
					+ "		<tr bgcolor='#eaeaea'>"
					+ "		<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'>"
					+ "<strong>Status</strong></font></td>"
					+ "		<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'>Aguardando aprovação"
					+ "</font></td>"
					+ "		</tr>"
					+ "		<tr bgcolor='#fbfbfb'>"
					+ "		<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'><strong>ID da solicitação</strong></font></td>"
					+ "		<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'>"+solicitacao.getId()+"</font></td>"
					+ "		</tr>"
					+ "		<tr bgcolor='#eaeaea'>"
					+ "		<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'>"
					+ "<strong>Nome</strong></font></td>"
					+ "		<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'>Milene - nome de base teste</font>"
					+ "</td>"
					+ "		</tr>"
					+ "		<tr bgcolor='#fbfbfb'>"
					+ "		<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'>"
					+ "<strong>Data</strong></font></td>"
					+ "		<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'>"+dataFrom+"</font></td>"
					+ "		</tr>"
					+ "		</table>"
					+ "		</td>"
					+ "		</tr>"
					+ "		<tr>"
					+ "		<td width='20'>&nbsp;</td>"
					+ "		<td><p><font color='#646264' face='Arial, Helvetica, sans-serif' size='4'>Para mais informações acesse: <a style='color:#0076bc;' href='http://www.meioemensagem.com.br/mailing' title='Grupo M&M Mailing'>www.meioemensagem.com.br/mailing</a>"
					+ "</font></p></td>"
					+ "		</tr>"
					+ "		</table>"
					+ "		</body>"
					+ "		</html>";
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
