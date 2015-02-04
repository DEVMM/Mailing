package br.com.grupomm.mailing.teste;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.grupomm.mailing.dao.IndexDAO;
import br.com.grupomm.mailing.model.entity.Mapeamento;

@ManagedBean
@ViewScoped
public class TestExportExcel {

	
	public void exportExcel(int ids){          
	    FacesContext fc = FacesContext.getCurrentInstance();
	    ExternalContext ec = fc.getExternalContext();       
	    String filename = "Mailing.xlsx";

	    XSSFWorkbook workbook = new XSSFWorkbook(); 
	    XSSFSheet sheet = workbook.createSheet("Mailing Anuarios");  
	    List<Mapeamento> solicitacao = IndexDAO.selectSolicitacao(ids);
	    

		Row row1 = sheet.createRow((short) 0);
		row1.createCell(0).setCellValue("CNPJ");
		row1.createCell(1).setCellValue("AREA_EXECUTIVO");
		row1.createCell(2).setCellValue("BAIRRO");
		row1.createCell(3).setCellValue("CEP");
		row1.createCell(4).setCellValue("CIDADE");
		row1.createCell(5).setCellValue("EMAIL_EMPRESA");
		row1.createCell(6).setCellValue("EMAIL_EXECUTIVO");
		row1.createCell(7).setCellValue("IDTIPOEMPRESA");
		row1.createCell(8).setCellValue("LOGRADOURO");
		row1.createCell(9).setCellValue("NOMEFANTASIA");
		row1.createCell(10).setCellValue("NUMERO");
		row1.createCell(11).setCellValue("PORTE_EMPRESA");
		row1.createCell(12).setCellValue("RAZAOSOCIAL");
		row1.createCell(13).setCellValue("TELEFONE_EMPRESA");
		row1.createCell(14).setCellValue("TELEFONE_EXECUTIVO");
		row1.createCell(15).setCellValue("TIPOLOGRADOURO");
		row1.createCell(16).setCellValue("UF");  

		int i = 1;
	     for(Mapeamento p : solicitacao){
	         int cellnum = 0;
	         Row row2 = sheet.createRow(i++);

	        row2.createCell(0).setCellValue(p.getCNPJ());
	 		row2.createCell(1).setCellValue(p.getAREA_EXECUTIVO());
	 		row2.createCell(2).setCellValue(p.getBAIRRO());
	 		row2.createCell(3).setCellValue(p.getCEP());
	 		row2.createCell(4).setCellValue(p.getCIDADE());
	 		row2.createCell(5).setCellValue(p.getEMAIL_EMPRESA());
	 		row2.createCell(6).setCellValue(p.getEMAIL_EXECUTIVO());
	 		row2.createCell(7).setCellValue(p.getIDTIPOEMPRESA());
	 		row2.createCell(8).setCellValue(p.getLOGRADOURO());
	 		row2.createCell(9).setCellValue(p.getNOMEFANTASIA());
	 		row2.createCell(10).setCellValue(p.getNUMERO());
	 		row2.createCell(11).setCellValue(p.getPORTE_EMPRESA());
	 		row2.createCell(12).setCellValue(p.getRAZAOSOCIAL());
	 		row2.createCell(13).setCellValue(p.getTELEFONE_EMPRESA());
	 		row2.createCell(14).setCellValue(p.getEMAIL_EXECUTIVO());
	 		row2.createCell(15).setCellValue(p.getTIPOLOGRADOURO());
	 		row2.createCell(16).setCellValue(p.getUF());   
	     }
	   try{
	      ec.responseReset();         
	      ec.setResponseContentType("text/xlsx");
	      ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");     

	      //to align column vertically
	      sheet.autoSizeColumn(0);
	      sheet.autoSizeColumn(1);
	      sheet.autoSizeColumn(3); 

	      workbook.write(ec.getResponseOutputStream()); 

	      fc.responseComplete();                    
	   } 
	  catch (Exception e){
	            e.printStackTrace();
	  }
	  }
}
