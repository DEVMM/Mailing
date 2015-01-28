
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
    			   + "1,'Ve�culo Comunica��o',"
    			   + " 2,'Ag�ncia',"
    			   + "3,'Fornecedor da Comunica��o',"
    			   + " 4,'Com�rcio / Ind�stria / Servi�o')"
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

