package com.accenture.tracker.export.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.accenture.tracker.json.DataObject;

public class ListExcelView extends AbstractExcelView {

	public void setExcelHeader(HSSFSheet excelSheet) {
		HSSFRow excelHeader = excelSheet.createRow(0);
		excelHeader.createCell(0).setCellValue("Lead Time");
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
	}

	public void setExcelRows(HSSFSheet excelSheet, List<DataObject> list) {
		int record = 1;
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
