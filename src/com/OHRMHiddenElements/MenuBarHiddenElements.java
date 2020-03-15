package com.OHRMHiddenElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MenuBarHiddenElements 
{

	public static void main(String[] args) 
	{
		String url = "https://www.apsrtconline.in/oprs-web/";
		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		WebElement HeaderBlock=driver.findElement(By.className("menu-wrap"));
		List<WebElement> HomePageMenuItemsLinks=HeaderBlock.findElements(By.tagName("a"));
		int TotalMenuItemsLinks_count=HomePageMenuItemsLinks.size();
		System.out.println("The Total Links in the header are :"+TotalMenuItemsLinks_count);
		for(int i=0;i<TotalMenuItemsLinks_count;i++)
		{
				String MenuItemsName=HomePageMenuItemsLinks.get(i).getText();
				System.out.println(i+"- "+MenuItemsName);		

		}
		driver.quit();
	}
}
