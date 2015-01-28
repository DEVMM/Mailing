package br.com.grupomm.mailing.teste;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import br.com.grupomm.mailing.dao.IndexDAO;
import br.com.grupomm.mailing.entity.Mapeamento;
import br.com.grupomm.mailing.entity.Solicitacao;
import br.com.grupomm.mailing.enuns.Estados;
@ManagedBean
@ViewScoped
public class teste {
	
	public static void main(String[] args) throws IOException{
		Workbook wb = new HSSFWorkbook();
	    CreationHelper createHelper = wb.getCreationHelper();
	    Sheet sheet = wb.createSheet("new sheet");

	    
	    // Create a cell and put a value in it.
	  List<Mapeamento> solicitacao = IndexDAO.selectSolicitacao(2);
	  
	    Row row1 = sheet.createRow((short) 0);
	    row1.createCell(0).setCellValue("CNPJ");
	    row1.createCell(1).setCellValue("AREA_EXECUTIVO");
	    row1.createCell(2).setCellValue("BAIRRO");
	    row1.createCell(2).setCellValue("CARGO_EXECUTIVO");
	   
	   
	    int i = 1;
	    for (Mapeamento p : solicitacao) {
	         Row row2 = sheet.createRow(i++);
	         row2.createCell(0).setCellValue(p.getCNPJ());
	         row2.createCell(1).setCellValue(p.getAREA_EXECUTIVO());
	         row2.createCell(2).setCellValue(p.getBAIRRO());
	         row2.createCell(2).setCellValue(p.getCARGO_EXECUTIVO());
	     }
	   
	    FileOutputStream fileOut = new FileOutputStream("c://teste//workbook.xls");
	    wb.write(fileOut);
	    fileOut.close();
}
}