package br.com.grupomm.mailing.model.bo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.poi.hssf.util.HSSFColor.GOLD;

import br.com.grupomm.mailing.controller.Anuarios;
import br.com.grupomm.mailing.dao.AnuariosDAO;
import br.com.grupomm.mailing.message.GrowlView;
import br.com.grupomm.mailing.model.entity.Solicitacao;
import br.com.grupomm.mailing.model.enuns.AreaAnuarios;
import br.com.grupomm.mailing.model.enuns.Estados;
import br.com.grupomm.mailing.model.enuns.NivelAnuarios;
import br.com.grupomm.mailing.model.enuns.Porte;
import br.com.grupomm.mailing.model.enuns.RamoAtividadeAnuarios;
import br.com.grupomm.mailing.util.Util;

public class AnuariosBO {

	Anuarios anuarios = new Anuarios();	

	public String gerar(List<String> valida, Solicitacao solicitacao){
		List<String> ckEstados = new ArrayList<String>();
		List<Integer> ckNivel= new ArrayList<Integer>();
		List<String> ckRamoAtividade = new ArrayList<String>();
		List<Integer> ckArea = new ArrayList<Integer>();
		List<Integer> ckPorte= new ArrayList<Integer>();

		for(String v : valida){
			for(Estados s : anuarios.getEstados()){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckEstados.add(s.toString());
				}
			} 
			for(NivelAnuarios s : anuarios.getNivelAnuarios()){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckNivel.add(s.getId());
				}
			} 
			for(RamoAtividadeAnuarios s : anuarios.getRamoAtividadeAnuarios()){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckRamoAtividade.add(s.toString());
				}
			} 
			for(AreaAnuarios s : anuarios.getAreaAnuarios() ){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckArea.add(s.getId());
				}
			} 
			for(Porte s : anuarios.getPorte() ){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckPorte.add(s.getId());
				}
			}
		}	

		AnuariosDAO anuariosDAO = new AnuariosDAO();

		try {
			anuariosDAO.gerarSolicitacao(gerarSolicitacao(ckEstados, ckRamoAtividade, ckNivel, ckPorte, ckArea),solicitacao);
		} catch (Exception e) {
			GrowlView.erro("Erro", "Tente novamente");
		}


		EnviaEmail enviaEmail = new EnviaEmail();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    String dataFrom = dateFormat.format(solicitacao.getDt().getTime());
		
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
				+ "		<td><font color='#0076bc' face='Arial, Helvetica, sans-serif' style='font-size:20px;'>"+Util.getUserName()+",</font></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "		<td><font color='#646264' face='Arial, Helvetica, sans-serif' style='font-size:18px;'>"
				+ "Seu mailing foi gerado com sucesso!</font></p></td>"
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
				+ "		<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'>"+solicitacao.getDescricao()+"</font>"
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

		String msgAdm="<!doctype html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset='utf-8'>"
				+ "<title>Um novo mailing foi gerado no sistema!</title>"
				+ "</head>"
				+ "<body>"
				+ "	<table cellpadding='0' cellspacing='0' width='590'>"
				+ "    	<tr>"
				+ "        	<td width='20' bgcolor='#0076bc'>&nbsp;</td>"
				+ "        	<td valign='middle' bgcolor='#0076bc' height='55'>"
				+ "<img style='margin-top:6px;' src='http://mmimg.meioemensagem.cm.br/EMK/Logo-MailingEmail.png' height='33' width='251' alt='Grupo M&M Mailing'/></td>"
				+ "</tr>"
				+ "        <tr>"
				+ "        	<td width='20'></td>"
				+ "            <td>"
				+ "            	<table>"
				+ "               	<tr>"
				+ "                    	<td height='20'>&nbsp;</td>"
				+ "                    </tr>"
				+ "                	<tr>"
				+ "                    	<td><font color='#646264' face='Arial, Helvetica, sans-serif' style='font-size:18px;'>Um novo mailing foi gerado no sistema!</font></p></td>"
				+ "                    </tr>"
				+ "                </table>"
				+ "                <table cellpadding='12' cellspacing='5'>"
				+ "                	<tr bgcolor='#eaeaea'>"
				+ "                    	<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'>"
				+ "<strong>Solicitante</strong></font></td>"
				+ "                        <td>"
				+ "<font color='#646264' face='Arial, Helvetica, sans-serif' size='3'>"+Util.getUserName()+"</font></td>"
				+ "                    </tr>"
				+ "                    <tr bgcolor='#fbfbfb'>"
				+ "                    	<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'>"
				+ "<strong>ID da solicitação</strong></font></td>"
				+ "                        <td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'>"+solicitacao.getId()+"</font></td> "
				+ "</tr>"
				+ "                    <tr bgcolor='#eaeaea'>"
				+ "                    	<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'>"
				+ "<strong>Nome</strong></font></td>"
				+ "<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'>"+solicitacao.getDescricao()+"</font></td>"
				+ " </tr>"
				+ " <tr bgcolor='#fbfbfb'>"
				+ "  	<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'><strong>Data</strong>"
				+ "</font></td>"
				+ "<td><font color='#646264' face='Arial, Helvetica, sans-serif' size='3'>"+dataFrom+"</font></td>"
				+ "  </tr>"
				+ "   </table>"
				+ " </td>"
				+ " </tr>"
				+ "  <tr>"
				+ " 	<td width='20'>&nbsp;</td>"
				+ "        	<td><p><font color='#646264' face='Arial, Helvetica, sans-serif' size='4'>Favor verificar no sistema: <a style='color:#0076bc;' href='http://www.meioemensagem.com.br/mailing' title='Grupo M&M Mailing'>www.meioemensagem.com.br/mailing</a>"
				+ "</font></p></td>"
				+ "  </tr>"
				+ "  </table>"
				+ "</body>"
				+ "</html>";

		try {
			enviaEmail.enviarEmailSolicitante(Util.getEmail(),msgUsr, solicitacao);
			enviaEmail.enviarEmailAdm(msgAdm, solicitacao);
		} catch (EmailException e) {
			e.printStackTrace();
		}
		GrowlView.showMessage("Relatório Gerado com sucesso!", "Aguarde a aprovação");
		return "index";	
	}

	public String Valida(List<String> valida){


		List<String> ckEstados = new ArrayList<String>();
		List<Integer> ckNivel= new ArrayList<Integer>();
		List<String> ckRamoAtividade = new ArrayList<String>();
		List<Integer> ckArea = new ArrayList<Integer>();
		List<Integer> ckPorte= new ArrayList<Integer>();

		for(String v : valida){
			for(Estados s : anuarios.getEstados()){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckEstados.add(s.toString());
				}
			} 
			for(NivelAnuarios s : anuarios.getNivelAnuarios()){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckNivel.add(s.getId());
				}
			} 
			for(RamoAtividadeAnuarios s : anuarios.getRamoAtividadeAnuarios()){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckRamoAtividade.add(s.toString());
				}
			} 
			for(AreaAnuarios s : anuarios.getAreaAnuarios() ){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckArea.add(s.getId());
				}
			} 
			for(Porte s : anuarios.getPorte() ){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckPorte.add(s.getId());
				}
			}
		}	


		if(ckEstados.isEmpty() || ckArea.isEmpty() || ckNivel.isEmpty() || ckPorte.isEmpty() || ckRamoAtividade.isEmpty()){
			System.out.println("e vazio");
			GrowlView.showMessage("Falha Ao enviar", "Selecione ao menos um item de cada categoria");
			return null;
		}

		Integer qtd = Integer.valueOf(this.count(ckEstados, ckRamoAtividade, ckNivel, ckPorte, ckArea).toString());

		if(qtd == 0){
			GrowlView.showMessage("Resultado em branco ", "A busca não encontrou resultados");

			return "";
		}
		else{
			return qtd.toString();
		}

	}

	public String gerarSolicitacao(List<String> estados,List<String> idTipoEmpresa, List<Integer> idCargo, List<Integer> idPorte, List<Integer> idArea ){

		String pEstados = estados.toString().replace("[", "'").replace(",", "','").replace("]", "'").replace(" ", "");
		String pIdTipoEmpresa = idTipoEmpresa.toString().replace("[", "'").replace(",", "','").replace("]", "'").replace(" ", "");
		String pIdCargo = idCargo.toString().replace("[","").replace("]", "");
		String pIdPorte = idPorte.toString().replace("[","").replace("]", "");
		String pIdArea  = idArea.toString().replace("[","").replace("]", "");

		String query = "SELECT "
				+ "EMP.CNPJ, EMP.RAZAOSOCIAL, ETE.NOMEFANTASIA, ETE.EMAIL AS EMAIL_EMPRESA,ETE.TELEFONE "
				+ "AS TELEFONE_EMPRESA ,ETE.IDTIPOEMPRESA, PE.NOME AS PORTE_EMPRESA, "
				+ "CP.TIPOLOGRADOURO, CP.LOGRADOURO, ETE.NUMERO,CP.CEP,CP.BAIRRO, CID.LOCALIDADE AS CIDADE, CID.UF, "
				+ "E.NOMEEXECUTIVO, E.EMAIL AS EMAIL_EXECUTIVO, E.TELEFONE AS TELEFONE_EXECUTIVO, "
				+ "AA.NOME AS AREA_EXECUTIVO, CAR.NOME AS CARGO_EXECUTIVO "
				+ "FROM EMPRESA EMP "
				+ "INNER JOIN EMPRESATIPOEMPRESA ETE ON ETE.CNPJ = EMP.CNPJ "
				+ "INNER JOIN PORTEEMPRESA PE ON PE.IDPORTEEMPRESA = ETE.IDPORTEEMPRESA "
				+ "INNER JOIN CEP CP ON CP.IDCEP = ETE.IDENDERECO "
				+ "INNER JOIN CIDADE CID ON CID.IDCIDADE = CP.IDCIDADE "
				+ "INNER JOIN EXECUTIVOEMPRESA EE ON EE.IDEMPRESA = ETE.IDEMPRESA "
				+ "INNER JOIN EXECUTIVO E ON E.IDEXECUTIVO = EE.IDEXECUTIVO "
				+ "INNER JOIN AREA AA ON AA.IDAREA = EE.IDAREA "
				+ "INNER JOIN CARGO CAR ON CAR.IDCARGO = EE.IDCARGO "
				+ "WHERE CID.UF IN ("+pEstados+") "
				+ "AND ETE.ATIVO=1 "
				+ "AND ETE.IDTIPOEMPRESA IN ("+pIdTipoEmpresa+") "
				+ "AND CAR.IDCARGO IN ("+pIdCargo+") "
				+ "AND PE.IDPORTEEMPRESA IN ("+pIdPorte+") "
				+ "AND AA.IDAREA IN("+pIdArea+")";

		System.out.println("chamado o gerarSolicitação");
		return query;
	}
	public Object count(List<String> estados,List<String> idTipoEmpresa, List<Integer> idCargo, List<Integer> idPorte, List<Integer> idArea ){


		String pEstados = estados.toString().replace("[", "'").replace(",", "','").replace("]", "'").replace(" ", "");
		String pIdTipoEmpresa = idTipoEmpresa.toString().replace("[", "'").replace(",", "','").replace("]", "'").replace(" ", "");
		String pIdCargo = idCargo.toString().replace("[","").replace("]", "");
		String pIdPorte = idPorte.toString().replace("[","").replace("]", "");
		String pIdArea  = idArea.toString().replace("[","").replace("]", "");

		String query = "SELECT Count(*)" 
				+ "FROM EMPRESA EMP "
				+ "INNER JOIN EMPRESATIPOEMPRESA ETE ON ETE.CNPJ = EMP.CNPJ "
				+ "INNER JOIN PORTEEMPRESA PE ON PE.IDPORTEEMPRESA = ETE.IDPORTEEMPRESA "
				+ "INNER JOIN CEP CP ON CP.IDCEP = ETE.IDENDERECO "
				+ "INNER JOIN CIDADE CID ON CID.IDCIDADE = CP.IDCIDADE "
				+ "INNER JOIN EXECUTIVOEMPRESA EE ON EE.IDEMPRESA = ETE.IDEMPRESA "
				+ "INNER JOIN EXECUTIVO E ON E.IDEXECUTIVO = EE.IDEXECUTIVO "
				+ "INNER JOIN AREA AA ON AA.IDAREA = EE.IDAREA "
				+ "INNER JOIN CARGO CAR ON CAR.IDCARGO = EE.IDCARGO "
				+ "WHERE CID.UF IN ("+pEstados+") "
				+ "AND ETE.ATIVO=1 "
				+ "AND ETE.IDTIPOEMPRESA IN ("+pIdTipoEmpresa+") "
				+ "AND CAR.IDCARGO IN ("+pIdCargo+") "
				+ "AND PE.IDPORTEEMPRESA IN ("+pIdPorte+") "
				+ "AND AA.IDAREA IN("+pIdArea+")";

		AnuariosDAO anuarios = new AnuariosDAO();

		try {
			return anuarios.count(query);
		} catch (Exception e) {
			GrowlView.erro("Erro","Tente Novamente!");
			return 0;
		}

	}
}
