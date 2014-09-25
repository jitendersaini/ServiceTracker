package com.accenture.tracker.export.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.accenture.tracker.json.DataObject;

public class ListExcelView extends AbstractExcelView {

	public void setExcelHeader(HSSFSheet excelSheet) {
		HSSFWorkbook wb = excelSheet.getWorkbook();
		HSSFCellStyle cellStyle = wb.createCellStyle();
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		cellStyle.setFont(font);
		
		HSSFRow excelHeader = excelSheet.createRow(0);		
		HSSFCell cell1 = excelHeader.createCell(0);
		cell1.setCellStyle(cellStyle);
		cell1.setCellValue("Lead Time");
		excelHeader.createCell(1).setCellValue("Requirements");
		excelHeader.createCell(2).setCellValue("Resp. Operations");
		excelHeader.createCell(3).setCellValue("Projects");
		excelHeader.createCell(4).setCellValue("Start Date");
		excelHeader.createCell(5).setCellValue("End Date");
		excelHeader.createCell(6).setCellValue("Progress");
		excelHeader.createCell(7).setCellValue("Status");
		excelHeader.createCell(8).setCellValue("Priority");
		excelHeader.createCell(9).setCellValue("Docs");
		excelHeader.createCell(10).setCellValue("%");
		excelHeader.createCell(11).setCellValue("Stage");/*
		HSSFCell cell11 = excelHeader.createCell(11);
		
		//final HSSFCellStyle cellS = (HSSFCellStyle) wb.createCellStyle();
		
	    cell11.setCellValue("Stage");*/
	}

	public void setExcelRows(HSSFSheet excelSheet, List<DataObject> list) {
		int record = 1;
		HSSFWorkbook wb = excelSheet.getWorkbook();
		//cellStyle.setFillPattern(HSSFCellStyle.BORDER_DASH_DOT);
		for (DataObject dataObject : list) {
			HSSFRow excelRow = excelSheet.createRow(record++);
			
			//cellStyle.setFillForegroundColor( new HSSFColor.RED().getIndex() );
			//cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		    //cell11.setCellStyle(cellStyle);
			
			excelRow.createCell(0).setCellValue(dataObject.getLeadTime());
			excelRow.createCell(1).setCellValue(dataObject.getRequirements());
			excelRow.createCell(2).setCellValue(
					dataObject.getResponseOperation());
			excelRow.createCell(3).setCellValue(dataObject.getProjects());
			excelRow.createCell(4).setCellValue(dataObject.getStartDate());
			excelRow.createCell(5).setCellValue(dataObject.getEndDate());
			excelRow.createCell(6).setCellValue(dataObject.getProgress());
			excelRow.createCell(7).setCellValue(dataObject.getStatus());
			excelRow.createCell(8).setCellValue(dataObject.getPriority());
			excelRow.createCell(9).setCellValue(dataObject.getDocs());
			excelRow.createCell(10).setCellValue(dataObject.getPercentage());
			//excelRow.createCell(11).setCellValue(dataObject.getKtStatus());
			System.out.println("dataObject.getKtStatus(): "+dataObject.getKtStatus());
			HSSFCell cell11 = excelRow.createCell(11);
			HSSFCellStyle cellStyle = wb.createCellStyle();
			if(dataObject.getKtStatus().contains("green")) {				
				cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
				cellStyle.setFillForegroundColor( new HSSFColor.GREEN().getIndex() );	
			} else if(dataObject.getKtStatus().contains("amber")) {				
				cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);				
				cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
				cellStyle.setFillForegroundColor( new HSSFColor.ORANGE().getIndex() );
			} else if(dataObject.getKtStatus().contains("red")) {				
				cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
				cellStyle.setFillForegroundColor( new HSSFColor.RED().getIndex() );
			}
		    cell11.setCellStyle(cellStyle);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HSSFSheet excelSheet = workbook.createSheet("KT List");
		setExcelHeader(excelSheet);

		List<DataObject> list = (List<DataObject>) model.get("dataList");
		setExcelRows(excelSheet, list);

	}
}
