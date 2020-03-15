package com.testNg;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewToursLinksScreenshots 
{
	WebDriver driver = null;
	@BeforeTest
	public void setUp()
	{
		String url = "http://newtours.demoaut.com/";
		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@Test
	public void Screenshot() throws IOException
	{
		List<WebElement> LoginPageLinks=driver.findElements(By.tagName("a"));
		int TotalLinksInLoginPage=LoginPageLinks.size();
		System.out.println("The Total Number of links in the NewTours Application Loginpage are : "+TotalLinksInLoginPage);
		
		
		for (int i =0;i<TotalLinksInLoginPage;i++)
		{
			String LinkName=LoginPageLinks.get(i).getText();
			LoginPageLinks.get(i).click();
			File Link_ScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Link_ScreenShot, new File("./LinksScreenshots/"+LinkName+".png"));
			driver.navigate().back();
			LoginPageLinks=driver.findElements(By.tagName("a"));
			
		}
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
		
}
