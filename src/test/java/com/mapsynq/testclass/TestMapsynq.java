package com.mapsynq.testclass;


import org.testng.annotations.Test;
import org.testng.Assert;
import com.mapsynq.pageclasses.Direction;
import com.mapsynq.pageclasses.Live;
//import com.mapsynq.pageclasses.Live;
import com.mapsynq.utilityclasses.AlertHandle;
import com.mapsynq.utilityclasses.CheckDomProperties;
import com.mapsynq.utilityclasses.GetJsonTestData;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class TestMapsynq
{
	Direction direction;
	CheckDomProperties chckdomprop;
	GetJsonTestData getjsontestdata;
	Live live ;
	AlertHandle alrthandle;

	private String URL=System.getProperty("url");
	private String BROWSER=System.getProperty("browser");
	static WebDriver driver;
	static String CHROME_PATH="drivers/chrome/chromedriver";
	static String FIREFOX_PATH="drivers/firefox/geckodriver";

	//static String validsource="CHANGI AIRPORT";
	//static String validdestination="BOTANIC GARDENS";


	public static WebDriver getDriver()
	{
		// TODO Auto-generated method stub
		return driver;
	}
	@Test(priority=0,description = "Open a browser with http://www.mapsynq.com/ url")
	public void LaunchURL()
	{
		if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			/*FirefoxProfile geoDisabled = new FirefoxProfile();
			geoDisabled.setPreference("geo.enabled", false);
			geoDisabled.setPreference("geo.provider.use_corelocation", false);
			geoDisabled.setPreference("geo.prompt.testing", false);
			geoDisabled.setPreference("geo.prompt.testing.allow", false);
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability(FirefoxDriver.PROFILE, geoDisabled);*/
			System.setProperty("webdriver.gecko.driver", FIREFOX_PATH);

			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Safari"))
		{
			driver=new SafariDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			/*ChromeOptions options = new ChromeOptions();
    		options.addArguments("start-maximized");
    		options.addArguments("test-type");
    		options.addArguments("enable-strict-powerful-feature-restrictions");
    		options.addArguments("disable-geolocation");
    		//cap = null;
    		DesiredCapabilities cap =
			null;
			cap.setCapability(ChromeOptions.CAPABILITY, options);
    		cap = cap.merge(DesiredCapabilities.chrome());*/
			System.setProperty("webdriver.chrome.driver", CHROME_PATH);
			driver=new ChromeDriver();
		}


		driver.get(URL);
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		live = new Live(driver);
		Assert.assertEquals(live.getPageTitle(), "mapSYNQ - Live Traffic Information Platform");

	}

	@Test(priority=1,description = "Click Directions Tab ")
	public void clickDirectiontab()
	{	
		direction=new Direction(driver);
		chckdomprop=new CheckDomProperties(driver);
		alrthandle=new AlertHandle(driver);
		getjsontestdata=new GetJsonTestData(driver);
		live.clickDirectionLink();
		Assert.assertEquals(chckdomprop.checkInnerText(direction.getClearRouteElement()),"Clear Route");
	}

	@Test(priority=2,description = "Click Clear Route link under Directions Page")
	public void testClearRoute()

	{
		direction.clickRouteClear();
	}


	@Test(priority=3,description = "Click Get Directions button with blank A and B fields under Directions Page")
	public void testBlankSourceDesinationTraficAwareRoute() throws FileNotFoundException, JSONException, InterruptedException

	{
		direction.clickRouteClear();
		direction.clickDirectionButton();
		alrthandle.acceptAlert();

	}

	@Test(priority=4,description = "Click Get Directions button with valid data in A and B fields under Directions Page")
	public void testTraficAwareRoute() throws FileNotFoundException, JSONException, InterruptedException 

	{
		direction.clickRouteClear();
		//direction.setSource(getjsontestdata.getData("validsource"));
		//direction.setDestination(getjsontestdata.getData("validdestination"));
		direction.setSourceDestination(getjsontestdata.getData("validsource"), getjsontestdata.getData("validdestination"));
		direction.clickDirectionButton();

		Assert.assertEquals(chckdomprop.checkInnerText(direction.getTraficRoute()), "Click here to see traffic aware route");

	}

	@Test(priority=5,description = "Uncheck Trafic Aware and Checked Toll Aware,then Click Get Directions button with valid data in A and B fields under Directions Page")
	public void TestTollAwareRoute() throws InterruptedException 

	{
		direction.clickTraficCheckbox();
		direction.clickTollAwareCheckbox();
		direction.clickDirectionButton();
		Assert.assertEquals(chckdomprop.checkInnerText(direction.getTollAwareRoute()), "Click here to see toll aware route");

	}

	@Test(priority=6,description = "Uncheck Toll Aware and Checked Fatest,then Click Get Directions button with valid data in A and B fields under Directions Page")
	public void TestFatestRoute() 

	{
		direction.clickTollAwareCheckbox();
		direction.clickFatestCheckbox();
		direction.clickDirectionButton();
		Assert.assertEquals(chckdomprop.checkInnerText(direction.getFatestRoute()), "Click here to see fastest route");

	}

	@Test(priority=7,description = "Uncheck Fatest and Checked Shortest,then Click Get Directions button with valid data in A and B fields under Directions Page")
	public void TestShortestRoute()  

	{
		direction.clickFatestCheckbox();
		direction.clickShortestCheckbox();
		direction.clickDirectionButton();
		Assert.assertEquals(chckdomprop.checkInnerText(direction.getShortestRoute()), "Click here to see shortest route");


	}



	

	@Test(priority=8,description = "Click Live Tab")
	public void ClickLiveTab()  

	{
		direction.clickLiveTab();
		Assert.assertEquals(chckdomprop.checkPlaceHolder(live.getPlaceHolder()), "Search incident location");


	}




	@Test(priority=11)
	public void closeBrowser()
	{
		//driver.quit();
	}



}
