package com.OrangeHRMLoginValidation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class OHRMInValidLogin {

	public static void main(String[] args) throws InterruptedException 
	{
		String url = "https://127.0.0.1/orangehrm-4.2/symfony/web/index.php/auth/login";
		String username = "admin";
		String password="Livetech@1";
		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		String Expected_LoginPanelText="LOGIN Panel";
		WebElement LogINPanelHeading=driver.findElement(By.id("logInPanelHeading"));
		String Actual_LoginPanelText=LogINPanelHeading.getText();
		if(Actual_LoginPanelText.equals(Expected_LoginPanelText))
		{
		System.out.println("Browser Successfully Launched OrangeHRM Application");
		WebElement uname=driver.findElement(By.id("txtUsername"));
		uname.sendKeys(username);
		WebElement password1=driver.findElement(By.id("txtPassword"));
		password1.sendKeys(password);
		WebElement LoginButton=driver.findElement(By.id("btnLogin"));
		LoginButton.click();
		String Expected_InvalidLoginText="Invalid credentials";
		WebElement InvalidLoginText=driver.findElement(By.id("spanMessage"));
		String Actual_InvalidLoginText =InvalidLoginText.getText();
		if(Actual_InvalidLoginText.equals(Expected_InvalidLoginText))
		{
			System.out.println("User Failed to LogIN to the OrangeHRM Application");
		
		}
		}		
		driver.quit();

	}

}
