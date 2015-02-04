package br.com.grupomm.mailing.model.bo;

import br.com.grupomm.mailing.dao.AprovacaoDAO;
import br.com.grupomm.mailing.message.GrowlView;

public class AprovacoesBO {
  
	public void gravarAprovacao(Integer id, String status){
		AprovacaoDAO aprovacaoDAO = new AprovacaoDAO();
		try {
			aprovacaoDAO.alterAprovacao(id, status);
		
		} catch (Exception e) {
			GrowlView.erro(e);
		}
	}
}
