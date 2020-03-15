package com.Export_DropdownValues_To_Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class CountriesExportToExcel {

	public static void main(String[] args) throws IOException 
	{
		String url = "http://newtours.demoaut.com/";
		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		WebElement registration=driver.findElement(By.linkText("REGISTER"));
		
		String Expected_RegisterURL_Address=registration.getAttribute("href");
		registration.click();
		String Actual_RegisterURL_Address=driver.getCurrentUrl();
		System.out.println(Actual_RegisterURL_Address);
		if(Actual_RegisterURL_Address.equals(Expected_RegisterURL_Address))
		{
			WebElement country=driver.findElement(By.name("country"));
			List<WebElement>CountryNames=country.findElements(By.tagName("option"));
			int Total_Counties_count=CountryNames.size();
			int rowcount=0;
			for(int i=0;i<Total_Counties_count;i++)
			{
			String CountryName=CountryNames.get(i).getText();
			
			FileInputStream file=new FileInputStream(".\\src\\com\\ExcelFiles\\ExportCountriesNames.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			Row row=sheet.createRow(rowcount);
			Cell cell=row.createCell(0);
			cell.setCellValue(CountryName);
			FileOutputStream fileoutput=new FileOutputStream(".\\src\\com\\ExcelFiles\\ExportCountriesNames.xlsx");
			workbook.write(fileoutput);
			rowcount++;	
			}
		}
		driver.quit();
	}
}
