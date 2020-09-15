package com.kang.test.web;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;


/**
 * <pre>
 * 1. 프로젝트명 :
 * 2. 패키지명 : com.kang.test.web
 * 3. 작성일 : 2020. 9. 15 
 * 4. 작성자 : kang
 * 5. 설명 :
 * </pre>
 */
@Component("sampleXls")
public class SampleXlsView extends AbstractXlsView {

	@Override 
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook
			, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-Disposition", "attachment;filename=\"sample.xls\"");
		
		CellStyle numberCellStyle = workbook.createCellStyle();
		DataFormat numberDataFormat = workbook.createDataFormat();
		numberCellStyle.setDataFormat(numberDataFormat.getFormat("#,##0"));
		Sheet sheet = workbook.createSheet("sample_sheet");
		
		Row row0 = sheet.createRow(0);
		Cell cell0 = row0.createCell(0);
		cell0.setCellValue("날짜");
		Cell cell1 = row0.createCell(1);
		cell1.setCellValue("이름");
		Cell cell2 = row0.createCell(2);
		cell2.setCellValue("연봉");
		
		Row row1 = sheet.createRow(1);
		cell0 = row1.createCell(0);
		cell0.setCellValue("2019-01-01");
		cell1 = row1.createCell(1);
		cell1.setCellValue("홍길동");
		cell2 = row1.createCell(2);
		cell2.setCellType(CellType.NUMERIC);
		cell2.setCellValue(1000000);
		cell2.setCellStyle(numberCellStyle);		

			 
	} 

}