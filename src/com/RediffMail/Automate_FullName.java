package com.RediffMail;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Automate_FullName extends RediffsetUp_teatDown
{
	@Test
	public void createAccount() throws IOException
	{
		//Identifying the properties file
		FileInputStream file = new FileInputStream("./Rediff.properties");
		//Creating properties class 
		Properties p = new Properties();
		p.load(file);//loading the properties file
		//Identifying the table
		WebElement TableElement=driver.findElement(By.id(p.getProperty("tableid")));
		//Identifying the Full name element
		WebElement FullName_Element=TableElement.findElement(By.tagName(p.getProperty("FullName")));
		//Identifying the Full name input/text field
		WebElement FullName_InputFiled=FullName_Element.findElement(By.xpath(p.getProperty("FullName_TextBox")));
		//Identifying the Test data excel file 
		FileInputStream file1 = new FileInputStream("./src/com/ExcelFiles/Rediff testdata.xlsx");
		//Identifying the workbook of the file
		XSSFWorkbook workbook = new XSSFWorkbook(file1);
		//Identifying the Sheet 
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		//Identifying the Row 
		Row row=sheet.getRow(1);
		//Identifying the row of a cell
		Cell cell=row.getCell(0);
		//Getting the cell value into a variable
		String fullname=cell.getStringCellValue();
		//Passing the variable as an input using sendkeys method
		FullName_InputFiled.sendKeys(fullname);
		
		
	}

}
