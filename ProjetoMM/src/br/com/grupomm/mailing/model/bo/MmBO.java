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
						+ "  4,'Estudante Estagiário', 5,'Funcionário Público',"
						+ " 6,'Gerente Operações / Chefe de Seção', "
						+ "7,'Presidente Superintendente / CEO',"
						+ " 8,'Sócio Proprietário',"
						+ "  9,'Supervisor Coordenador',"
						+ " 10,'Vice-Presidente',"
						+ "  11,'Criação (Diretor de Arte / Redator)')"
						+ " as Nivel_HIERARQUICO"
						+ " ,DECODE(CB.AREA_ATUACAO,"
						+ " 1,'Administrativo / Financeiro',"
						+ "  2,'Arquivo Biblioteca',"
						+ " 3,'Atendimento / Planejamento / Pesquisa / Desenvolvimento',"
						+ "  4,'Circulação / Logística / Distribuição',"
						+ " 5,'Comercial / Vendas',"
						+ "  6,'Criação / Design / Arte / Estúdio',"
						+ " 7,'Editorial / Redação / Programação / Jornalismo',"
						+ " 8,'Governo',"
						+ " 9,'Industrial / Produção / Suprimentos / Compras',"
						+ " 10,'Internacional / Exportação / Importação',"
						+ "  11,'Jurídico / Auditoria',"
						+ " 12,'Marketing / Comunicação / Produto / Publicidade / Telemkt', 13,'Mídia',"
						+ " 14,'Presidência / Diretoria Geral / Superintendência',  15,'Produção Gráfica',"
						+ "16,'Promoção / Merchandising / Eventos / Relações Públicas',"
						+ "17,'Recursos Humanos / Pessoal / Treinamento',18,'RTV',"
						+ "19,'Sistemas / Tecnologia / Informática / CPD')"
						+ " AS Area_de_ATUACAO"
						+ ",DECODE(CB.IDRAMOATIVIDADE_USUARIO,"
						+ "4,'Veículo Comunicação',"
						+ " 1,'Agência',"
						+ "3,'Fornecedor da Comunicação',"
						+ " 5,'Comércio / Indústria / Serviço')"
						+ " AS RAMO_DE_ATIVIDADE"
						+ " , DECODE (CB.PORTE,"
						+ " 1,'1 A 9 Funcionários',"
						+ " 2,'10 a 49 Funcionários', "
						+ "3,'50 a 99 Funcionários', "
						+ "4,'Mais de 100 Funcionários')"
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
	

		System.out.println("chamado o gerarSolicitação");
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
