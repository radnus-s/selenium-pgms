package com.automation.seleniumtraining.external.source;

import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo3_ExcelOperation {

	public static void main(String[] args) {
		try{
		 Workbook wb = new XSSFWorkbook();//new HSSFWorkbook();
		 Sheet sheet1 = wb.createSheet("Details");
		 CreationHelper createHelper = wb.getCreationHelper();
		// Aqua background
		    CellStyle style = wb.createCellStyle();
		    style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
		    //style.setFillPattern((short)2);
		  
		 // Create a row and put some cells in it. Rows are 0 based.
		    Row row = sheet1.createRow(0);
		    // Create a cell and put a value in it.
		    Cell cell = row.createCell(0);
		    cell.setCellValue(1);
		    cell.setCellStyle(style);
		    
		    row.createCell(1).setCellValue(1.2);
		    row.createCell(2).setCellValue(
		         createHelper.createRichTextString("This is a string"));
		    
		    CellStyle cellStyle = wb.createCellStyle();
		    cellStyle.setDataFormat(
		        createHelper.createDataFormat().getFormat("m/d/yy"));
		    
		   
		    Cell cell3 = row.createCell(3);
		    cell3.setCellValue(new Date());
		    cell3.setCellStyle(cellStyle);
		   
		    FileOutputStream fileOut = new FileOutputStream("sample.xlsx");
			   
		 wb.write(fileOut);
		 wb.close();
		 fileOut.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
