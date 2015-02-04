package br.com.grupomm.mailing.teste;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import br.com.grupomm.mailing.dao.IndexDAO;
import br.com.grupomm.mailing.model.entity.Mapeamento;
import br.com.grupomm.mailing.model.enuns.Estados;


@ManagedBean
@ViewScoped
public class CreateCell  {


	public  void  teste2() throws IOException{

		FileOutputStream fileOut = new FileOutputStream("poi-test.xls");
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("sheet title");
		int rowIndex = 0;

		List<Mapeamento> solicitacao = IndexDAO.selectSolicitacao(1);

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

		
		workbook.write(fileOut);

		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		externalContext.responseReset(); 
		externalContext.setResponseContentType("application/vnd.ms-excel");
		externalContext.setResponseHeader("Content-Disposition", "attachment;filename=export.xls");
		workbook.write(externalContext.getResponseOutputStream());
		context.responseComplete();

	}
}