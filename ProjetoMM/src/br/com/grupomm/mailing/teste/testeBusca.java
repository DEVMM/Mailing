package br.com.grupomm.mailing.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.grupomm.mailing.dao.IndexDAO;
import br.com.grupomm.mailing.dao.UsuarioDAO;
import br.com.grupomm.mailing.model.entity.Solicitacao;
import br.com.grupomm.mailing.util.JPAUtil;

public class testeBusca {

	
	public static void main(String[] args) {
		
		EntityManager  manager = new JPAUtil().getEntituManager();
		
		
		
		
		
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
    	   		+ "WHERE "
    	   		+ "ETE.ATIVO=1 ";
		
	 Object countryCount = manager.createNativeQuery(query).getSingleResult();
//	 if(countryCount.equals(0)){
//		 System.out.println(countryCount);
//	 }
//	 else{
//		 System.out.println(countryCount); 
//	 }
	 
	 String teste = countryCount.toString();
	 System.out.println(teste);
	 
	}
}
