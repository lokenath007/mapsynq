package com.mapsynq.utilityclasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

public class GetJsonTestData
{
	private WebDriver driver;

	public GetJsonTestData(
			WebDriver driver)
	{
		this.driver = driver;
	}

	public String getData(String testdata) throws FileNotFoundException, JSONException
	{

		String jsonData = "";
		BufferedReader br = null;
		try
		{
			String line;
			br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/test/resources/testdata.txt"));
			while ((line = br.readLine()) != null)
			{
				jsonData += line + "\n";
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (br != null)
					br.close();
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
		// System.out.println("File Content: \n" + jsonData);
		JSONObject obj = new JSONObject(jsonData);
		// System.out.println("Source: " + obj.getString("validsource"));
		// System.out.println("Destination: " +
		// obj.getString("validdestination"));
		return obj.getString(testdata);

	}
}
