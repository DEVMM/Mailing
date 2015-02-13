package br.com.grupomm.mailing.model.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.grupomm.mailing.controller.MM;
import br.com.grupomm.mailing.dao.AnuariosDAO;
import br.com.grupomm.mailing.dao.MMDAO;
import br.com.grupomm.mailing.message.GrowlView;
import br.com.grupomm.mailing.model.entity.Solicitacao;
import br.com.grupomm.mailing.model.enuns.Area;
import br.com.grupomm.mailing.model.enuns.AreaAnuarios;
import br.com.grupomm.mailing.model.enuns.Estados;
import br.com.grupomm.mailing.model.enuns.Nivel;
import br.com.grupomm.mailing.model.enuns.NivelAnuarios;
import br.com.grupomm.mailing.model.enuns.Porte;
import br.com.grupomm.mailing.model.enuns.RamoAtividade;
import br.com.grupomm.mailing.model.enuns.RamoAtividadeAnuarios;
import br.com.grupomm.mailing.model.enuns.Sexo;

public class MmBO {
	
	MM mm = new MM();
	
	public String gerar(List<String> valida, Solicitacao quantidade){
		List<String> ckEstados = new ArrayList<String>();
		List<Integer> ckNivel= new ArrayList<Integer>();
		List<Integer> ckRamoAtividade = new ArrayList<Integer>();
		List<Integer> ckArea = new ArrayList<Integer>();
		List<Integer> ckPorte= new ArrayList<Integer>();
		List<String> ckSexo= new ArrayList<String>();

		for(String v : valida){

			for(Estados s : mm.getEstados()){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckEstados.add(s.toString());
				}
			} 
			for(Nivel s : mm.getNivel()){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckNivel.add(s.getId());
				}
			} 
			for(RamoAtividade s : mm.getRamoAtividade()){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckRamoAtividade.add(s.getId());
				}
			} 
			for(Area s : mm.getArea() ){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckArea.add(s.getId());
				}
			} 

			for(Porte s : mm.getPorte() ){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckPorte.add(s.getId());
				}
			}

			for(Sexo s : mm.getSexo() ){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckSexo.add(s.toString());
				}
			}
			

			
		}	

		MMDAO mmDAO = new MMDAO();
		mmDAO.gerarSolicitacao(gerarSolicitacao(ckEstados, ckRamoAtividade, ckNivel, ckPorte, ckArea, ckSexo),quantidade);
		GrowlView.msgRelatorio();
		return "";	
	}

	public  String gerarRelatorio(List<String> valida){

		List<String> ckEstados = new ArrayList<String>();
		List<Integer> ckNivel= new ArrayList<Integer>();
		List<Integer> ckRamoAtividade = new ArrayList<Integer>();
		List<Integer> ckArea = new ArrayList<Integer>();
		List<Integer> ckPorte= new ArrayList<Integer>();
		List<String> ckSexo= new ArrayList<String>();

		MM mm = new MM();

		for(String v : valida){

			for(Estados s : mm.getEstados()){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckEstados.add(s.toString());
				}
			} 
			for(Nivel s : mm.getNivel()){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckNivel.add(s.getId());
				}
			} 
			for(RamoAtividade s : mm.getRamoAtividade()){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckRamoAtividade.add(s.getId());
				}
			} 
			for(Area s : mm.getArea() ){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckArea.add(s.getId());
				}
			} 

			for(Porte s : mm.getPorte() ){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckPorte.add(s.getId());
				}
			}

			for(Sexo s : mm.getSexo() ){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckSexo.add(s.toString());
				}
			}
		}	

		if(ckEstados.isEmpty() || ckArea.isEmpty() || ckNivel.isEmpty() || ckPorte.isEmpty() || ckRamoAtividade.isEmpty() || ckSexo.isEmpty()){
			GrowlView.msgValidaCheckBox();
			return "";
		}
		else{
			gerarSolicitacao(ckEstados, ckNivel, ckRamoAtividade, ckPorte, ckArea, ckSexo);
			GrowlView.msgRelatorio();
			return "index";
		}	
	}
	
	public String gerarSolicitacao(List<String> estados, List<Integer> ckRamoAtividade, List<Integer>ckNivel, List<Integer> idPorte, List<Integer> idArea, List<String> ckSexo){

		String pEstados = estados.toString().replace("[", "'").replace(",", "','").replace("]", "'").replace(" ", "");
		String pIdNivel = ckNivel.toString().replace("[","").replace("]", "");
		String pRamo  = ckRamoAtividade.toString().replace("[","").replace("]", "");
		String pIdPorte = idPorte.toString().replace("[","").replace("]", "");
		String pIdArea  = idArea.toString().replace("[","").replace("]", "");  
		String pSexo = ckSexo.toString().replace("[", "'").replace(",", "','").replace("]", "'").replace(" ", "");

		String query =    
				"SELECT CB.ID_USUARIO, CB.PRI_NOME, CB.SOBRENOME, CA.EMAIL_LOGIN, CB.AREA_ATUACAO, CB.CARGO, CB.ESTADO, CB.SEXO, CB.NASCIMENTO, "
						+ " DECODE ( CB.NIVEL,"
						+ "  1,'Assistente Auxiliar',"
						+ "2,'Consultor / Assessor',"
						+ " 3,'Diretor',"
						+ "  4,'Estudante Estagi�rio', 5,'Funcion�rio P�blico',"
						+ " 6,'Gerente Opera��es / Chefe de Se��o', "
						+ "7,'Presidente Superintendente / CEO',"
						+ " 8,'S�cio Propriet�rio',"
						+ "  9,'Supervisor Coordenador',"
						+ " 10,'Vice-Presidente',"
						+ "  11,'Cria��o (Diretor de Arte / Redator)')"
						+ " as Nivel_HIERARQUICO"
						+ " ,DECODE(CB.AREA_ATUACAO,"
						+ " 1,'Administrativo / Financeiro',"
						+ "  2,'Arquivo Biblioteca',"
						+ " 3,'Atendimento / Planejamento / Pesquisa / Desenvolvimento',"
						+ "  4,'Circula��o / Log�stica / Distribui��o',"
						+ " 5,'Comercial / Vendas',"
						+ "  6,'Cria��o / Design / Arte / Est�dio',"
						+ " 7,'Editorial / Reda��o / Programa��o / Jornalismo',"
						+ " 8,'Governo',"
						+ " 9,'Industrial / Produ��o / Suprimentos / Compras',"
						+ " 10,'Internacional / Exporta��o / Importa��o',"
						+ "  11,'Jur�dico / Auditoria',"
						+ " 12,'Marketing / Comunica��o / Produto / Publicidade / Telemkt', 13,'M�dia',"
						+ " 14,'Presid�ncia / Diretoria Geral / Superintend�ncia',  15,'Produ��o Gr�fica',"
						+ "16,'Promo��o / Merchandising / Eventos / Rela��es P�blicas',"
						+ "17,'Recursos Humanos / Pessoal / Treinamento',18,'RTV',"
						+ "19,'Sistemas / Tecnologia / Inform�tica / CPD')"
						+ " AS Area_de_ATUACAO"
						+ ",DECODE(CB.IDRAMOATIVIDADE_USUARIO,"
						+ "4,'Ve�culo Comunica��o',"
						+ " 1,'Ag�ncia',"
						+ "3,'Fornecedor da Comunica��o',"
						+ " 5,'Com�rcio / Ind�stria / Servi�o')"
						+ " AS RAMO_DE_ATIVIDADE"
						+ " , DECODE (CB.PORTE,"
						+ " 1,'1 A 9 Funcion�rios',"
						+ " 2,'10 a 49 Funcion�rios', "
						+ "3,'50 a 99 Funcion�rios', "
						+ "4,'Mais de 100 Funcion�rios')"
						+ " AS PORTE_EMPRESA"
						+ " FROM CAD_MMNETWORK CA"
						+ " INNER JOIN CAD_MMNETWORK_DADOS CB"
						+ " ON CA.ID_USUARIO = CB.ID_USUARIO"
						+ " WHERE cb.estado in ("+pEstados+")"
						+ " AND CB.NIVEL IN ("+pIdNivel+")"
						+ " AND AREA_ATUACAO IN ("+pIdArea+")"
						+ " AND CB.IDRAMOATIVIDADE_USUARIO in ("+pRamo+")"
						+ " AND CB.PORTE IN ("+pIdPorte+")"
						+ " AND CA.CAD_ATIVO = 'S'"
						+ " AND CB.sexo in ("+pSexo+")"
						+ " order by cb.nivel";
	

		System.out.println("chamado o gerarSolicita��o");
		return query;
	}
	
	public String Valida(List<String> valida){

		
		
		List<String> ckEstados = new ArrayList<String>();
		  List<Integer> ckNivel= new ArrayList<Integer>();
		  List<Integer> ckRamoAtividade = new ArrayList<Integer>();
		  List<Integer> ckArea = new ArrayList<Integer>();
		  List<Integer> ckPorte= new ArrayList<Integer>();
		  List<String> ckSexo= new ArrayList<String>();

		for(String v : valida){
			for(Estados s : mm.getEstados()){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckEstados.add(s.toString());
				}
			} 
			for(Nivel s : mm.getNivel()){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckNivel.add(s.getId());
				}
			} 
			for(RamoAtividade s : mm.getRamoAtividade()){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckRamoAtividade.add(s.getId());
				}
			} 
			for(Area s : mm.getArea()){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckArea.add(s.getId());
				}
			} 
			for(Porte s : mm.getPorte() ){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckPorte.add(s.getId());
				}
			}
			for(Sexo s : mm.getSexo() ){
				String chkBox = String.valueOf(s);
				if(v.equals(chkBox)){
					ckSexo.add(s.toString());
				}
			}
		}	

		//		AnuariosDAO anuariosDAO = new AnuariosDAO();
		//		 String query =gerarSolicitacao(ckEstados, ckRamoAtividade, ckNivel, ckPorte, ckArea);

		if(ckEstados.isEmpty() || ckArea.isEmpty() || ckNivel.isEmpty() || ckPorte.isEmpty() || ckRamoAtividade.isEmpty() || ckSexo.isEmpty()){
			System.out.println("e vazio");
			GrowlView.msgValidaCheckBox();
			return null;
		}
		if(this.count(ckEstados, ckRamoAtividade, ckNivel, ckPorte, ckArea, ckSexo).toString().equals("0")){
			GrowlView.nulo();
			//System.out.println("e zerooooooooooo"+this.count(ckEstados, ckRamoAtividade, ckNivel, ckPorte, ckArea, ckSexo).toString());
			
			
			
			return null;
		}
		else{
			return this.count(ckEstados, ckRamoAtividade, ckNivel, ckPorte, ckArea, ckSexo).toString();
		}

	}
	
	public Object count(List<String> estados, List<Integer> ckRamoAtividade, List<Integer>ckNivel, List<Integer> idPorte, List<Integer> idArea, List<String> ckSexo){


		String pEstados = estados.toString().replace("[", "'").replace(",", "','").replace("]", "'").replace(" ", "");
		String pIdNivel = ckNivel.toString().replace("[","").replace("]", "");
		String pRamo  = ckRamoAtividade.toString().replace("[","").replace("]", "");
		String pIdPorte = idPorte.toString().replace("[","").replace("]", "");
		String pIdArea  = idArea.toString().replace("[","").replace("]", "");  
		String pSexo = ckSexo.toString().replace("[", "'").replace(",", "','").replace("]", "'").replace(" ", "");


		
		
		String query = "select count(*) FROM "
				+ "CAD_MMNETWORK CA "
				+ "INNER JOIN CAD_MMNETWORK_DADOS CB"
				+ " ON CA.ID_USUARIO = CB.ID_USUARIO"
				+ " WHERE cb.estado in ("+pEstados+")"
				+ "  AND CB.NIVEL IN ("+pIdNivel+")"
				+ "  AND AREA_ATUACAO IN ("+pIdArea+")"
				+ " AND CB.IDRAMOATIVIDADE_USUARIO in ("+pRamo+")"
				+ " AND CB.PORTE IN ("+pIdPorte+")"
				+ " AND CA.CAD_ATIVO = 'S' "
				+ "AND CB.sexo in ("+pSexo+")";

	
		
		MMDAO mm = new MMDAO();

		return mm.count(query);
	}
}
