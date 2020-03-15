package com.ReadExcelData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class OHRMLoginForm_Read_Write_Excel_SingleTestData {

	public static void main(String[] args) throws IOException 
	{
		String url = "https://127.0.0.1/orangehrm-4.2/symfony/web/index.php/auth/login";
		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		FileInputStream file=new FileInputStream(".\\src\\com\\ExcelFiles\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		Row row=sheet.getRow(0);
		Cell cell=row.getCell(0);
		String username=cell.getStringCellValue();
		WebElement uname=driver.findElement(By.id("txtUsername"));
		uname.sendKeys(username);
		Cell cell1=row.getCell(1);
		String password =cell1.getStringCellValue();
		WebElement password1=driver.findElement(By.id("txtPassword"));
		password1.sendKeys(password);
		WebElement LoginButton=driver.findElement(By.id("btnLogin"));
		LoginButton.click();
		try
		{
		WebElement InvalidLoginText=driver.findElement(By.id("spanMessage"));
		if(InvalidLoginText.isDisplayed())
		{
			System.out.println("User Failed to logIn to OrangeHRM application");
			Cell cell2=row.createCell(2);
			cell2.setCellValue(false);
			FileOutputStream fileoutput=new FileOutputStream(".\\src\\com\\ExcelFiles\\TestData.xlsx");
			workbook.write(fileoutput);
		}
		}
		catch(Exception e)
		{
			System.out.println("User Successfully loggedIn to OrangeHRM application Home page");
			Cell cell2=row.createCell(2);
			cell2.setCellValue(true);
			FileOutputStream fileoutput=new FileOutputStream(".\\src\\com\\ExcelFiles\\TestData.xlsx");
			workbook.write(fileoutput);
		}
		
		driver.quit();

	}

}
