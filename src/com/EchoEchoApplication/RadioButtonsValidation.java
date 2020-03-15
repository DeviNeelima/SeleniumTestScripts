package com.EchoEchoApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;



public class RadioButtonsValidation extends EchoEchoSetup_teatDown
{
	@Test
	public void Radiobutton_Testing() throws IOException
	{
		// Identifying the properties file
		FileInputStream file = new FileInputStream("./Echoecho.properties");
		
		//Creating properties class in order to load the element properties
		Properties p = new Properties();
		
		// loading the properties file
		p.load(file);
		
		//Identifying the radio buttons block
		WebElement RadioButtonBlock=driver.findElement(By.xpath(p.getProperty("RadioButtons")));
		
		//Identifying the common properties in the radio button 
		List<WebElement>Radiobuttons_commonProperty=RadioButtonBlock.findElements(By.tagName(p.getProperty("Radiobuttons_commonProperty")));
		
		int Radiobuttons_count=Radiobuttons_commonProperty.size();
		System.out.println(Radiobuttons_count);
		
		
		for(int i=0;i<Radiobuttons_count;i++)//to click all the radio buttons
		{
			Radiobuttons_commonProperty.get(i).click();
			
			
			for(int j=0;j<Radiobuttons_count;j++)//to get the radio button value and status when the ith radio button is selected
			{
				String radiobuttonName=Radiobuttons_commonProperty.get(j).getAttribute("value");
				System.out.print(radiobuttonName+" "+Radiobuttons_commonProperty.get(j).isSelected()+" ");
			}
			
			
			System.out.println(" ");
		}
		
	}

}
