package com.mapsynq.utilityclasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandle
{
	private WebDriver driver;

	public AlertHandle(
			WebDriver driver)
	{

		this.driver = driver;

	}

	public void checkAlert()
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		catch (Exception e)
		{
			// exception handling
		}
	}
}
