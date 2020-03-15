package com.EchoEchoApplication;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class EchoEchoSetup_teatDown 
{
	WebDriver driver = null;
	@BeforeTest
	public void setUp()
	{
		String url = "http://www.echoecho.com/htmlforms10.htm";
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
