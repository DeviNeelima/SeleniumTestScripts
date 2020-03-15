package com.ReadExcelData;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Read_Excel_SingleTestData {

	
	public static void main(String[] args) throws IOException 
	{
		FileInputStream file=new FileInputStream(".\\src\\com\\ExcelFiles\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		Row row=sheet.getRow(0);
		Cell cell=row.getCell(0);
		String testdata=cell.getStringCellValue();
		System.out.println(testdata);
		

	}

}
