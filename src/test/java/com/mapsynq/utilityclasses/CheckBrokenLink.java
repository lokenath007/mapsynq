package com.mapsynq.utilityclasses;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBrokenLink
{
	private int invalidLinksCount;
	private int totallink = 0;
	private WebDriver driver;

	public CheckBrokenLink(
			WebDriver driver)
	{

		this.driver = driver;

	}

	public String countLinks()
	{
		try
		{

			List<WebElement> anchorTagsList = driver.findElements(By.tagName("a"));
			anchorTagsList.addAll(driver.findElements(By.tagName("img")));
			totallink = anchorTagsList.size();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return Integer.toString(totallink);

	}

	public String countInvalidLinks()
	{

		try
		{
			invalidLinksCount = 0;
			List<WebElement> anchorTagsList = driver.findElements(By.tagName("a"));
			for (WebElement anchorTagElement : anchorTagsList)
			{
				if (anchorTagElement != null)
				{
					String url = anchorTagElement.getAttribute("href");
					if (url != null && !url.contains("javascript"))
					{
						// System.out.print(url);
						verifyURLStatus(url);
					}
					else
					{
						invalidLinksCount++;
					}
				}
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return Integer.toString(invalidLinksCount);
	}

	public void verifyURLStatus(String URL)
	{

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(URL);
		try
		{
			HttpResponse response = client.execute(request);
			// verifying response code and The HttpStatus should be 200 if not,
			// increment invalid link count
			//// We can also check for 404 status code like
			// response.getStatusLine().getStatusCode() == 404
			if (response.getStatusLine().getStatusCode() != 200)
				invalidLinksCount++;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
