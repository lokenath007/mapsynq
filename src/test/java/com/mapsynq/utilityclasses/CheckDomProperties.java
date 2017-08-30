package com.mapsynq.utilityclasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CheckDomProperties
{
	private WebDriver driver;

	public CheckDomProperties(
			WebDriver driver)
	{

		this.driver = driver;

	}

	public String checkInnerText(String element)
	{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String varinnertext = js.executeScript("return " + element + ".innerHTML;").toString();
		return varinnertext;

	}

	public String checkPlaceHolder(String element)
	{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String varinnertext = js.executeScript("return " + element + ".placeholder;").toString();
		return varinnertext;

	}

}
