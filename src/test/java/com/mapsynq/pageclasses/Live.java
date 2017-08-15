package com.mapsynq.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Live
{
	By directionlink=By.xpath("//*[@id='info_panel']/div[1]/div/a[1]");
	private WebDriver driver;

	public Live(WebDriver driver){

		this.driver = driver;

	}
	
	
	public void clickDirectionLink()
	{
		WebDriverWait directionlinkwt=new WebDriverWait(driver,10);
		directionlinkwt.until(ExpectedConditions.elementToBeClickable(directionlink));
		driver.findElement(directionlink).click();
		
	}
	
	
	public String getPageTitle()
	
	{
		return driver.getTitle();

	}
}
