package com.OHRMHomePageLinks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class OHRMLinks {

	public static void main(String[] args) 
	{
		String url = "https://127.0.0.1/orangehrm-4.2/symfony/web/index.php/auth/login";
		String username = "admin";
		String password="Livetech@123";
		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		WebElement uname=driver.findElement(By.id("txtUsername"));
		uname.sendKeys(username);
		WebElement password1=driver.findElement(By.id("txtPassword"));
		password1.sendKeys(password);
		WebElement LoginButton=driver.findElement(By.id("btnLogin"));
		LoginButton.click();
		System.out.println("LoggedIn Successfully");
		List<WebElement> HomePageLinks=driver.findElements(By.tagName("a"));
		int TotalLinksInHomePage=HomePageLinks.size();
		System.out.println("The Total Number of links in the OrangeHRM Application HomePage are : "+TotalLinksInHomePage);
		driver.quit();

	}

}
