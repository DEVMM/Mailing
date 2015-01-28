package br.com.grupomm.mailing.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.grupomm.mailing.dao.IndexDAO;
import br.com.grupomm.mailing.entity.Mapeamento;
import br.com.grupomm.mailing.entity.MapeamentoMM;

public class IndexControl {

	public void excelAnuarios(int ids) throws IOException{          
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();       
		  OutputStream out = ec.getResponseOutputStream();
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
			row2.createCell(14).setCellValue(p.getTELEFONE_EXECUTIVO());
			row2.createCell(15).setCellValue(p.getTIPOLOGRADOURO());
			row2.createCell(16).setCellValue(p.getUF());   
		}
			
			
			ec.responseReset();         
			ec.setResponseContentType("text/xlsx");
			ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");     
			//to align column vertically
			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(3); 
              
			workbook.write(ec.getResponseOutputStream());  
			out.flush();
			out.close();
			//ec.redirect("index.xhtml");
			//fc.responseComplete();
			//ec.redirect("index.xhtml");
			FacesContext.getCurrentInstance().getExternalContext().redirect("anuarios.xhtml");
	}
   
	
	public void excelMM(int ids){          
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();       
		String filename = "Mailing.xlsx";

		XSSFWorkbook workbook = new XSSFWorkbook(); 
		XSSFSheet sheet = workbook.createSheet("Mailing Anuarios");  
		List<MapeamentoMM> solicitacao = IndexDAO.selectSolicitacaoMM(ids);


		Row row1 = sheet.createRow((short) 0);
		row1.createCell(0).setCellValue("ID_USUARIO");
		row1.createCell(1).setCellValue("PRI_NOME");
		row1.createCell(2).setCellValue("SOBRENOME");
		row1.createCell(3).setCellValue("EMAIL_LOGIN");
		row1.createCell(4).setCellValue("AREA_ATUACAO");
		row1.createCell(5).setCellValue("CARGO");
		row1.createCell(6).setCellValue("ESTADO");
		row1.createCell(7).setCellValue("SEXO");
		row1.createCell(8).setCellValue("NASCIMENTO");
		row1.createCell(9).setCellValue("NIVEL_HIERARQUICO");
		row1.createCell(10).setCellValue("AREA_DE_ATUACAO");
		row1.createCell(11).setCellValue("RAMO_DE_ATIVIDADE");
		row1.createCell(12).setCellValue("PORTE_EMPRESA");

		int i = 1;

		for(MapeamentoMM p : solicitacao){
			int cellnum = 0;

			Row row2 = sheet.createRow(i++);
			row2.createCell(0).setCellValue(p.getID_USUARIO());
			row2.createCell(1).setCellValue(p.getPRI_NOME());
			row2.createCell(2).setCellValue(p.getSOBRENOME());
			row2.createCell(3).setCellValue(p.getEMAIL_LOGIN());
			row2.createCell(4).setCellValue(p.getAREA_ATUACAO());
			row2.createCell(5).setCellValue(p.getCARGO());
			row2.createCell(6).setCellValue(p.getESTADO());
			row2.createCell(7).setCellValue(p.getSEXO());
			row2.createCell(8).setCellValue(p.getNASCIMENTO());
			row2.createCell(9).setCellValue(p.getNIVEL_HIERARQUICO());
			row2.createCell(10).setCellValue(p.getAREA_DE_ATUACAO());
			row2.createCell(11).setCellValue(p.getRAMO_DE_ATIVIDADE());
			row2.createCell(12).setCellValue(p.getPORTE_EMPRESA()); 
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
