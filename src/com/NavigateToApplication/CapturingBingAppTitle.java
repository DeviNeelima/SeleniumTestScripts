package com.NavigateToApplication;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CapturingBingAppTitle {

	public static void main(String[] args)  
	{
		String url = "http://laptop-o8t00ulf/login.do";
		System.setProperty("webdriver.gecko.driver", "./Driverfiles/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//System.setProperty("Webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		driver.get(url);
		String actual_BingApplicationTitle = driver.getTitle();
		System.out.println("The Title of the bing application is :"+actual_BingApplicationTitle);
		driver.close();

	}

}
