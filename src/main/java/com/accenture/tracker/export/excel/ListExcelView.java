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
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setFillForegroundColor(new HSSFColor.AQUA().getIndex());
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setFont(font);

		HSSFRow excelHeader = excelSheet.createRow(0);
		HSSFCell cell1 = excelHeader.createCell(0);
		cell1.setCellStyle(cellStyle);
		cell1.setCellValue("Lead Time");

		HSSFCell cell2 = excelHeader.createCell(1);
		cell2.setCellStyle(cellStyle);
		cell2.setCellValue("Requirements");

		HSSFCell cell3 = excelHeader.createCell(2);
		cell3.setCellStyle(cellStyle);
		cell3.setCellValue("Resp. Operations");

		HSSFCell cell4 = excelHeader.createCell(3);
		cell4.setCellStyle(cellStyle);
		cell4.setCellValue("Projects");

		HSSFCell cell5 = excelHeader.createCell(4);
		cell5.setCellStyle(cellStyle);
		cell5.setCellValue("Start Date");

		HSSFCell cell6 = excelHeader.createCell(5);
		cell6.setCellStyle(cellStyle);
		cell6.setCellValue("End Date");

		HSSFCell cell7 = excelHeader.createCell(6);
		cell7.setCellStyle(cellStyle);
		cell7.setCellValue("Progress");

		HSSFCell cell8 = excelHeader.createCell(7);
		cell8.setCellStyle(cellStyle);
		cell8.setCellValue("Status");

		HSSFCell cell9 = excelHeader.createCell(8);
		cell9.setCellStyle(cellStyle);
		cell9.setCellValue("Priority");

		HSSFCell cell10 = excelHeader.createCell(9);
		cell10.setCellStyle(cellStyle);
		cell10.setCellValue("Docs");

		HSSFCell cell11 = excelHeader.createCell(10);
		cell11.setCellStyle(cellStyle);
		cell11.setCellValue("%");

		HSSFCell cell12 = excelHeader.createCell(11);
		cell12.setCellStyle(cellStyle);
		cell12.setCellValue("Stage");
	}

	public void setExcelRows(HSSFSheet excelSheet, List<DataObject> list) {
		int record = 1;
		HSSFWorkbook wb = excelSheet.getWorkbook();
		for (DataObject dataObject : list) {
			HSSFRow excelRow = excelSheet.createRow(record++);

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

			HSSFCell cell11 = excelRow.createCell(11);
			HSSFCellStyle cellStyle = wb.createCellStyle();
			if (dataObject.getKtStatus().contains("green")) {
				cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
				cellStyle.setFillForegroundColor(new HSSFColor.GREEN()
						.getIndex());
			} else if (dataObject.getKtStatus().contains("amber")) {
				cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
				cellStyle.setFillForegroundColor(new HSSFColor.ORANGE()
						.getIndex());
			} else if (dataObject.getKtStatus().contains("red")) {
				cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
				cellStyle
						.setFillForegroundColor(new HSSFColor.RED().getIndex());
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
