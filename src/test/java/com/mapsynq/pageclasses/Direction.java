package com.mapsynq.pageclasses;

import javax.naming.directory.NoSuchAttributeException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Direction
{
	By fromSource = By.id("poi_from");
	By toDestination = By.id("poi_to");
	By getDirections = By.id("get_direction");
	By chkBoxTrafic = By.id("also_traffic");
	By chkBoxTollAware = By.id("also_erp");
	By chkBoxFatest = By.id("also_fastest");
	By chkBoxShortest = By.id("also_shortest");
	By btnclear = By.id("btnClear");
	By linkLive = By.xpath("//*[@id='info_panel']/div[1]/div/a[3]");

	private String traficRouteShowElement = "document.getElementById('divTrafficRouteShow')";
	private String traficFatestShowElement = "document.getElementById('divFastestRouteShow')";
	private String traficShortestShowElement = "document.getElementById('divShortestRouteShow')";
	private String traficTollAwreShowElement = "document.getElementById('divErpRouteShow')";
	private String clearRouteElement = "document.getElementById('btnClear')";

	private WebDriver driver;

	public Direction(
			WebDriver driver)
	{
		this.driver = driver;
	}

	public void setSource(String varsource)
	{
		driver.findElement(fromSource).sendKeys(varsource);
		WebDriverWait autocompleteWait1 = new WebDriverWait(driver, 10);
		autocompleteWait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'Autocomplete_')]/div[2]")));
		driver.findElement(By.xpath("//div[contains(@id,'Autocomplete_')]/div[2]")).click();

	}

	public void setDestination(String vardestination)
	{
		driver.findElement(toDestination).sendKeys(vardestination);
		WebDriverWait autocompleteWait2 = new WebDriverWait(driver, 10);
		autocompleteWait2.until(
				ExpectedConditions.elementToBeClickable(
						By.xpath("//div[contains(@id,'Autocomplete_')]//div[2][contains(@title,'" + vardestination + "')]")));
		driver.findElement(By.xpath("//div[contains(@id,'Autocomplete_')]//div[2][contains(@title,'" + vardestination + "')]")).click();

	}

	public void setSourceDestination(String source, String destination)
	{
		driver.findElement(fromSource).sendKeys(source);
		WebDriverWait autocompleteWait1 = new WebDriverWait(driver, 20);
		autocompleteWait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'Autocomplete_')]/div[2]")));
		driver.findElement(By.xpath("//div[contains(@id,'Autocomplete_')]/div[2]")).click();

		driver.findElement(toDestination).sendKeys(destination);
		WebDriverWait autocompleteWait2 = new WebDriverWait(driver, 20);
		autocompleteWait2.until(
				ExpectedConditions.elementToBeClickable(
						By.xpath("//div[contains(@id,'Autocomplete_')]//div[2][contains(@title,'" + destination + "')]")));
		driver.findElement(By.xpath("//div[contains(@id,'Autocomplete_')]//div[2][contains(@title,'" + destination + "')]")).click();

	}

	public void clickDirectionButton()
	{
		try
		{
			driver.findElement(getDirections).click();
		}
		catch (NoSuchElementException e)
		{

			e.printStackTrace();

		}
	}

	public void getDirectionFromSourceToDestination(String source, String destination) throws InterruptedException
	{
		this.setSourceDestination(source, destination);

	}

	public void clickTraficCheckbox()
	{
		try
		{
			driver.findElement(chkBoxTrafic).click();
		}
		catch (NoSuchElementException e)
		{

			e.printStackTrace();

		}
	}

	public void clickTollAwareCheckbox()
	{
		try
		{
			driver.findElement(chkBoxTollAware).click();
		}

		catch (NoSuchElementException e)
		{

			e.printStackTrace();

		}
	}

	public void clickFatestCheckbox()
	{
		try
		{
			driver.findElement(chkBoxFatest).click();
		}

		catch (NoSuchElementException e)
		{

			e.printStackTrace();

		}
	}

	public void clickShortestCheckbox()
	{
		try
		{
			driver.findElement(chkBoxShortest).click();
		}

		catch (NoSuchElementException e)
		{

			e.printStackTrace();

		}
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
		WebDriverWait clearroutewait = new WebDriverWait(driver, 10);
		clearroutewait.until(ExpectedConditions.elementToBeClickable(btnclear));
		driver.findElement(btnclear).click();
	}

	public void clickLiveTab()
	{
		WebDriverWait clearroutewait = new WebDriverWait(driver, 10);
		clearroutewait.until(ExpectedConditions.elementToBeClickable(linkLive));
		driver.findElement(linkLive).click();

	}

}
