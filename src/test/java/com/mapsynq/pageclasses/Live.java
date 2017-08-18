package com.mapsynq.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Live
{
	By directionlink=By.xpath("//*[@id='info_panel']/div[1]/div/a[1]");
	By incidentLink=By.id("rdIncidents");
	By camerasLink=By.id("rdCameras");
	By tollsLink=By.id("rdErp");
	private WebDriver driver;
	
	private String txtplaceholder="document.getElementById('txtSearchIncidentsingapore')";


	public Live(WebDriver driver){

		this.driver = driver;

	}
	
	public String getPlaceHolder()
	{
		return txtplaceholder;

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
	
	
	public void clickIncidentTab()
	{
		WebDriverWait directionlinkwt=new WebDriverWait(driver,10);
		directionlinkwt.until(ExpectedConditions.elementToBeClickable(incidentLink));
		driver.findElement(incidentLink).click();
		
	}
	
	public void clickCamerasTab()
	{
		WebDriverWait directionlinkwt=new WebDriverWait(driver,10);
		directionlinkwt.until(ExpectedConditions.elementToBeClickable(camerasLink));
		driver.findElement(camerasLink).click();
		
	}
	
	public void clickTollsTab()
	{
		WebDriverWait directionlinkwt=new WebDriverWait(driver,10);
		directionlinkwt.until(ExpectedConditions.elementToBeClickable(tollsLink));
		driver.findElement(tollsLink).click();
		
	}
}
