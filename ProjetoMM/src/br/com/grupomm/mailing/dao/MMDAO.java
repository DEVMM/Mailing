
package br.com.grupomm.mailing.dao;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.grupomm.mailing.database.JPAUtil;
import br.com.grupomm.mailing.entity.Solicitacao;
import br.com.grupomm.mailing.entity.Usuario;

public class MMDAO {


      public void TesteMap(Integer usuarioL, List<String> estados,List<Integer> idNivel, List<Integer> ckRamoAtividade, List<Integer> idPorte, List<Integer> idArea, List<String> ckSexo ){
    	   	  
    	  String pEstados = estados.toString().replace("[", "'").replace(",", "','").replace("]", "'").replace(" ", "");
    	  String pIdNivel = idNivel.toString().replace("[","").replace("]", "");
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
    			   + "1,'Veículo Comunicação',"
    			   + " 2,'Agência',"
    			   + "3,'Fornecedor da Comunicação',"
    			   + " 4,'Comércio / Indústria / Serviço')"
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
   	  
    	   EntityManager  manager = new JPAUtil().getMMonline();
    	   
    	   List q = manager.createNativeQuery(query).getResultList();
    	   
    	   Solicitacao solicitacao = new Solicitacao();
           Usuario usuario = new Usuario();
    	  usuario.setId(usuarioL);
    	   
    	   
    	   solicitacao.setDt(Calendar.getInstance());
    	   solicitacao.setQuery(query);
    	   solicitacao.setQuantidade(q.size());
    	   solicitacao.setStatus("Aguardando");
    	   solicitacao.setTipoSolicitacao("MM-online");
    	  
    	   solicitacao.setUsuario(usuario);
    	   EntityManager mysql = new JPAUtil().getMySql();
    	   mysql.getTransaction().begin();
    	   mysql.persist(solicitacao);
    	   mysql.getTransaction().commit();
    	  
    	   manager.close();
    	   mysql.close();

       }
}

