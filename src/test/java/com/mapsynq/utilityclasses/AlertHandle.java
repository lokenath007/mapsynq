package com.mapsynq.utilityclasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHandle
{
	private WebDriver driver;

	public AlertHandle(WebDriver driver){

		this.driver = driver;

	}

	public void acceptAlert() throws InterruptedException{


		Alert alert = driver.switchTo().alert();		

		Thread.sleep(5000);

		// Accepting alert	

		alert.accept();

	}
}
