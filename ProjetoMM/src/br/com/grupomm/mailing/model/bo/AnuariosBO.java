package br.com.grupomm.mailing.model.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.grupomm.mailing.controller.Anuarios;
import br.com.grupomm.mailing.dao.AnuariosDAO;
import br.com.grupomm.mailing.message.GrowlView;
import br.com.grupomm.mailing.model.enuns.AreaAnuarios;
import br.com.grupomm.mailing.model.enuns.Estados;
import br.com.grupomm.mailing.model.enuns.NivelAnuarios;
import br.com.grupomm.mailing.model.enuns.Porte;
import br.com.grupomm.mailing.model.enuns.RamoAtividadeAnuarios;

public class AnuariosBO {
	
	Anuarios anuarios = new Anuarios();

	public String gerarRelatorio(List<String> valida){

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
			GrowlView.msgValidaCheckBox();
			return "";
		}
		else{
			GrowlView.msgValidaCheckBox();
			gerarSolicitacao(ckEstados, ckRamoAtividade, ckNivel, ckPorte, ckArea);
			GrowlView.msgRelatorio();
			return "index";
		}	
	}
    public void gerarSolicitacao(List<String> estados,List<String> idTipoEmpresa, List<Integer> idCargo, List<Integer> idPorte, List<Integer> idArea ){
    	
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
   	
    AnuariosDAO anuariosDAO = new AnuariosDAO();
   	anuariosDAO.TesteMap(query);
    	
    }
}
