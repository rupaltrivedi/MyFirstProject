package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell column;
	public static FileInputStream file;
	

	public static int getRowCount() throws IOException {

		file = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/TestData/TestData.xlsx");
		workbook = new XSSFWorkbook(file);
		workbook.getSheet("Sheet1");
		int rowCount= sheet.getLastRowNum();
		workbook.close();
		file.close();
		return rowCount;


	}

	public static int getColumnCount() throws IOException {

		file = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/TestData/TestData.xlsx");
		workbook = new XSSFWorkbook(file);
		sheet =workbook.getSheet("Sheet1");
		int colCount= sheet.getRow(0).getLastCellNum();
		workbook.close();
		file.close();
		return colCount;


	}

	public void getCellValue() throws IOException {

		file = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/TestData/TestData.xlsx");
		workbook = new XSSFWorkbook(file);
		sheet= workbook.getSheet("Sheet1");
		
		
				
			
			
			
		

	}
}
