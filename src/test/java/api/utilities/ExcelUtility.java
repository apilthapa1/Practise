package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtility {
	
	FileInputStream fis;
	FileOutputStream fos;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public ExcelUtility(String path) {
		this.path = path;
	}
	
	private XSSFSheet getExcelSheet(String sheetName) throws IOException{
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		return workbook.getSheet(sheetName);
	}
	
	public int getRowCount(String sheetName) throws IOException{
		sheet = getExcelSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowCount;
	}
	
	public int getCellCount(String sheetName, int rowNum) throws IOException{
		sheet = getExcelSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellCount;
	}
	
	public String getCellData(String sheetName, int rowNum, int column) throws IOException{
		sheet = getExcelSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(column);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}
		workbook.close();
		fis.close();
		return data;
	}
	
	public void setCellData(String sheetName, int rowNum, int column, String data) throws IOException{
		File excelFile = new File(path);
		if(!excelFile.exists()) {
			workbook = new XSSFWorkbook();
			fos = new FileOutputStream(path);
			workbook.write(fos);
		}
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		
		if(workbook.getSheetIndex(sheetName) == -1) {
			workbook.createSheet(sheetName);
		}
		sheet = workbook.getSheet(sheetName);
		
		if(sheet.getRow(rowNum) == null) {
			sheet.createRow(rowNum);
		}
		row = sheet.getRow(rowNum);
	}
}
