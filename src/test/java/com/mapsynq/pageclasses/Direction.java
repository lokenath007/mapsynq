package com.mapsynq.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Direction
{
	By fromSource = By.id("poi_from");
	By toDestination= By.id("poi_to");
	By getDirections=By.id("get_direction");
	By chkBoxTrafic= By.id("also_traffic");
	By chkBoxTollAware= By.id("also_erp");
	By chkBoxFatest= By.id("also_fastest");
	By chkBoxShortest= By.id("also_shortest");
	By btnclear=By.id("btnClear");
	
	
	private String traficRouteShowElement="document.getElementById('divTrafficRouteShow')";
	private String traficFatestShowElement="document.getElementById('divFastestRouteShow')";
	private String traficShortestShowElement="document.getElementById('divShortestRouteShow')";
	private String traficTollAwreShowElement="document.getElementById('divErpRouteShow')";
	private String clearRouteElement="document.getElementById('btnClear')";
	
	
	private WebDriver driver;

	public Direction(WebDriver driver){

		this.driver = driver;

	}

	

	public void setSourceDestination(String source,String destination)	
	{
		driver.findElement(fromSource).sendKeys(source);
		WebDriverWait autocompleteWait1=new WebDriverWait(driver,10);
		autocompleteWait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'Autocomplete_')]/div[2]")));
		driver.findElement(By.xpath("//div[contains(@id,'Autocomplete_')]/div[2]")).click();

		driver.findElement(toDestination).sendKeys(destination);
		WebDriverWait autocompleteWait2=new WebDriverWait(driver,10);
		autocompleteWait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'Autocomplete_')]//div[2][contains(@title,'"+destination+"')]")));
		driver.findElement(By.xpath("//div[contains(@id,'Autocomplete_')]//div[2][contains(@title,'"+destination+"')]")).click();
		driver.findElement(By.xpath("//*[@id='get_direction']")).click();
	}

	public void clickDirectionButton()
	{
		driver.findElement(getDirections).click();
	}

	public void getDirectionFromSourceToDestination(String source,String destination)
	{
		this.setSourceDestination(source, destination);
		this.clickDirectionButton();
	}
	
	public void clickTraficCheckbox()
	{
		driver.findElement(chkBoxTrafic).click();
	}

	public void clickTollAwareCheckbox()
	{
		driver.findElement(chkBoxTollAware).click();
	}
	public void clickFatestCheckbox()
	{
		driver.findElement(chkBoxFatest).click();
	}
	public void clickShortestCheckbox()
	{
		driver.findElement(chkBoxShortest).click();
	}
	
	public String getTraficRoute()
	{
		return traficRouteShowElement;
		
	}
	
	public String getFatestRoute()
	{
		return traficFatestShowElement;
		
	}
	
	public String getShortestRoute()
	{
		return traficShortestShowElement;
		
	}
	public String getTollAwareRoute()
	{
		return traficTollAwreShowElement;
		
	}
	
	
	
	
	public String getClearRouteElement()
	{
		return clearRouteElement;
		
	}
	public void clickRouteClear()
	{
		WebDriverWait clearroutewait=new WebDriverWait(driver,10);
		clearroutewait.until(ExpectedConditions.elementToBeClickable(btnclear));
		driver.findElement(btnclear).click();
	}
	
	
	
}
