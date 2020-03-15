package com.WebTables;

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
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CaputringFirstColumnData_Excel extends SetUp_tearDown
{
	int totalRow_count;
	String CityName=null;
	@Test(priority=1)
	public void getRowCount()
	{
		List<WebElement>tableRow=driver.findElements(By.tagName("tr"));
		totalRow_count=tableRow.size();//To get the all the rows
		System.out.println(totalRow_count);
		
	}
	
	
	@Test(priority=2)
	public void exportCityNamesToExcel() throws IOException
	{
		//html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]/a
		//html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[1]/a
		
		for(int i=1;i<totalRow_count;i++)//To goto all the rows
		{
			WebElement City=driver.findElement(By.xpath("html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr["+i+"]/td[1]/a"));
			CityName=City.getText();
			System.out.println(CityName);
			
			FileInputStream file=new FileInputStream(".\\src\\com\\ExcelFiles\\TimeandDate_CityNames.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			Row row=sheet.createRow(i-1);
			Cell cell=row.createCell(0);
			cell.setCellValue(CityName);
			
			FileOutputStream fileoutput=new FileOutputStream(".\\src\\com\\ExcelFiles\\TimeandDate_CityNames.xlsx");
			workbook.write(fileoutput);
						
		}
		
	}
		
}
