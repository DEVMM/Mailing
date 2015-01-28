
package br.com.grupomm.mailing.dao;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.grupomm.mailing.database.JPAUtil;
import br.com.grupomm.mailing.entity.Solicitacao;
import br.com.grupomm.mailing.entity.Usuario;

public class AnuariosDAO {


      public void TesteMap(Integer usuarioL, List<String> estados,List<String> idTipoEmpresa, List<Integer> idCargo, List<Integer> idPorte, List<Integer> idArea ){
    	   	  
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
    	   		+ "FROM MM.EMPRESA EMP "
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
    	   
    	  
    	   EntityManager  manager = new JPAUtil().getEntituManager();
    	   List q = manager.createNativeQuery(query).getResultList();
    	   
    	   Solicitacao solicitacao = new Solicitacao();
           Usuario usuario = new Usuario();
    	  usuario.setId(usuarioL);
    	   
    	   
    	   solicitacao.setDt(Calendar.getInstance());
    	   solicitacao.setQuery(query);
    	   solicitacao.setQuantidade(q.size());
    	   solicitacao.setStatus("Aguardando");
    	   solicitacao.setTipoSolicitacao("Anuarios");
    	  
    	   solicitacao.setUsuario(usuario);
    	   EntityManager mysql = new JPAUtil().getMySql();
    	   mysql.getTransaction().begin();
    	   mysql.persist(solicitacao);
    	   mysql.getTransaction().commit();
    	  
    	 
    	   manager.close();
    	   mysql.close();

       }
}

