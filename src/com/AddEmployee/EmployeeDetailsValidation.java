package com.AddEmployee;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EmployeeDetailsValidation extends OHRMSetup_teatDown
{
	@Test(priority=1)
	public void logIn()
	{
		
		String Expected_LoginPanelText="LOGIN Panel";
		WebElement LogINPanelHeading=driver.findElement(By.id("logInPanelHeading"));
		String Actual_LoginPanelText=LogINPanelHeading.getText();
		if(Actual_LoginPanelText.equals(Expected_LoginPanelText))
		{
		 System.out.println("Browser Successfully Launched OrangeHRM Application");
		}
	}
	@Test(priority=2)
	public void readLoginCredentailsFromExcel() throws IOException
	{
		FileInputStream file=new FileInputStream(".\\src\\com\\ExcelFiles\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int row_count=sheet.getLastRowNum();
		for(int i=0;i<1;i++)
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
			String Expected_HomePageWelcomeText="Admin";
			WebElement HomePageWelcomeText=driver.findElement(By.id("welcome"));
			String Actual_HomePageWelcomeText=HomePageWelcomeText.getText();
			try
			{
			if(Actual_HomePageWelcomeText.contains(Expected_HomePageWelcomeText))
			{
				System.out.println("User Successfully loggedIn to OrangeHRM application Home page");
				///html/body/div[1]/div[2]/ul/li[2]/a/b
				WebElement PIMElement=driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/a/b"));
				Actions act= new Actions(driver);
				act.moveToElement(PIMElement).perform();
				WebElement AddEmployeeElement=driver.findElement(By.id("menu_pim_addEmployee"));
				AddEmployeeElement.click();
				
			}
			else
			{
				System.out.println("Login Failed - FAIL");
			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
				
		}		
		
	}
}
