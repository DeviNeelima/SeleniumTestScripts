package com.WebTables;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SetUp_tearDown 
{

	WebDriver driver = null;
	@BeforeTest
	public void setUp()
	{
		String url = "https://127.0.0.1/orangehrm-4.2/symfony/web/index.php/auth/login";
		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	

}
