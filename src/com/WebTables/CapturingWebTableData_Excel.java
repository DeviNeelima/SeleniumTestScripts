package com.WebTables;

import java.io.FileInputStream;
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

import com.NavigateToApplication.CapturingBingAppTitle;

public class CapturingWebTableData_Excel extends SetUp_tearDown
{
	int totalRow_count;
	int totalColumn_count;
	String CityName=null;
	@Test(priority=1)
    public void getTotalRowAndColumns()
	{
		List<WebElement>tableRow=driver.findElements(By.tagName("tr"));
		totalRow_count=tableRow.size();
		System.out.println(totalRow_count);
		///html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[8]
		WebElement tableRowOfColumn=driver.findElement(By.xpath("html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[1]"));
		List<WebElement> totalColumns=tableRowOfColumn.findElements(By.tagName("td"));
		totalColumn_count=totalColumns.size();
		
		System.out.println(totalColumn_count);
			
	}
	
	@Test(priority=2)
	public void exportCityNamesToExcel() throws IOException
	{
		
		for(int i=1;i<totalRow_count;i++)
		{
			for(int j=1;j<=totalColumn_count;j++)
			{
				
			WebElement City=driver.findElement(By.xpath("html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr["+i+"]/td["+j+"]"));
			CityName=City.getText();
			System.out.println(CityName);
			FileInputStream file=new FileInputStream(".\\src\\com\\ExcelFiles\\TimeandDate_CityNames.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			Row row=sheet.createRow(i-1);
			Cell cell=row.createCell(j-1);
			cell.setCellValue(CityName);
			FileOutputStream fileoutput=new FileOutputStream(".\\src\\com\\ExcelFiles\\TimeandDate_CityNames.xlsx");
			workbook.write(fileoutput);
			}			
		}
	}
		
}