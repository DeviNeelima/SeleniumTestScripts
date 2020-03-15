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

public class OHRMLoginForm_Read_Write_Excel_MultipleTextData {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		String url = "https://127.0.0.1/orangehrm-4.2/symfony/web/index.php/auth/login";
		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		FileInputStream file=new FileInputStream(".\\src\\com\\ExcelFiles\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int row_count=sheet.getLastRowNum();
		System.out.println(row_count);
		for(int i=0;i<=row_count;i++)
		{
			Row row=sheet.getRow(i);
			int cell_count=row.getLastCellNum();
			System.out.println(cell_count);
			String array[][]= new String[row_count+1][cell_count];
			Cell cell= row.getCell(0);
			Cell cell1=row.getCell(1);
			array[i][0]=cell.getStringCellValue();
			array[i][1]=cell1.getStringCellValue();
			WebElement uname=driver.findElement(By.id("txtUsername"));
			uname.sendKeys(array[i][0]);
			WebElement password=driver.findElement(By.id("txtPassword"));
			password.sendKeys(array[i][1]);
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
				Thread.sleep(3000);
			    WebElement HomePageWelcomeText=driver.findElement(By.id("welcome"));
				HomePageWelcomeText.click();
				Thread.sleep(3000);
				WebElement LogoutButton=driver.findElement(By.linkText("Logout"));
				LogoutButton.click();
				System.out.println("OrangeHRM loggedOut Successfully");
			
			}
			continue;
				
			}
		driver.quit();
			
		}

	}

