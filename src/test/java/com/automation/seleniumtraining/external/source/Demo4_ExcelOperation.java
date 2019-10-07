package com.automation.seleniumtraining.external.source;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo4_ExcelOperation {

	public static void main(String[] args) {
		try{
		 
		 FileInputStream file = new FileInputStream("country.xlsx");
		 Workbook wb = new XSSFWorkbook(file);//new HSSFWorkbook();
		 Sheet sheet1 = wb.getSheetAt(0);
		    for (Row row : sheet1) {
		        for (Cell cell : row) {
		            CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
		            System.out.print(cellRef.formatAsString());// for 0,0 cell it prints A1
		            System.out.print(" - ");
		            // Alternatively, get the value and format it yourself
		            switch (cell.getCellType()) {
		                case Cell.CELL_TYPE_STRING:
		                    System.out.println(cell.getRichStringCellValue().getString());
		                    break;
		                case Cell.CELL_TYPE_NUMERIC:
		                    if (DateUtil.isCellDateFormatted(cell)) {
		                        System.out.println(cell.getDateCellValue());
		                    } else {
		                        System.out.println(cell.getNumericCellValue());
		                    }
		                    break;
		                case Cell.CELL_TYPE_BOOLEAN:
		                    System.out.println(cell.getBooleanCellValue());
		                    break;
		                case Cell.CELL_TYPE_FORMULA:
		                    System.out.println(cell.getCellFormula());
		                    break;
		                case Cell.CELL_TYPE_BLANK:
		                    System.out.println();
		                    break;
		                default:
		                    System.out.println();
		            }
		        }
		    }
		    file.close();
		    wb.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
