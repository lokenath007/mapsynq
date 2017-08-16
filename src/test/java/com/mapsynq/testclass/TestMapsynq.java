package com.mapsynq.testclass;


import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import com.mapsynq.pageclasses.Direction;
import com.mapsynq.pageclasses.Live;
import com.mapsynq.utilityclasses.CheckDomProperties;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class TestMapsynq
{
	Direction direction;
	CheckDomProperties chckdomprop;
	Live live ;

	private String URL=System.getProperty("url");
	private String BROWSER=System.getProperty("browser");
	static WebDriver driver;
	static String CHROME_PATH="drivers/chrome/chromedriver";
	static String FIREFOX_PATH="drivers/firefox/geckodriver";

	static String validsource="CHANGI AIRPORT";
	static String validdestination="BOTANIC GARDENS";

	
	public static WebDriver getDriver()
	{
		// TODO Auto-generated method stub
		return driver;
	}
	@Test(priority=0)
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		live = new Live(driver);
		Assert.assertEquals(live.getPageTitle(), "mapSYNQ - Live Traffic Information Platform");

	}

	@Test(priority=1)
	public void clickDirectiontab()
	{	direction=new Direction(driver);
		chckdomprop=new CheckDomProperties(driver);
		live.clickDirectionLink();
		
		Assert.assertEquals(chckdomprop.checkInnerText(direction.getClearRouteElement()),"Clear Route");
	}

	@Test(priority=2)
	public void testClearRoute()

	{
		
		direction.clickRouteClear();
	}

	@Test(priority=3)
	public void testTraficAwareRoute() 

	{
		
		direction.setSourceDestination(validsource, validdestination);
		direction.clickDirectionButton();
		
		Assert.assertEquals(chckdomprop.checkInnerText(direction.getTraficRoute()), "Click here to see traffic aware route");

	}

	@Test(priority=4)
	public void TestTollAwareRoute() throws InterruptedException 

	{
		direction.clickTraficCheckbox();
		direction.clickTollAwareCheckbox();
		direction.clickDirectionButton();
		AssertJUnit.assertEquals(chckdomprop.checkInnerText(direction.getTollAwareRoute()), "Click here to see toll aware route");

	}

	@Test(priority=5)
	public void TestFatestRoute() 

	{
		direction.clickTollAwareCheckbox();
		direction.clickFatestCheckbox();
		direction.clickDirectionButton();
		Assert.assertEquals(chckdomprop.checkInnerText(direction.getFatestRoute()), "Click here to see fastest route");

	}

	@Test(priority=6)
	public void TestShortestRoute()  

	{
		direction.clickFatestCheckbox();
		direction.clickShortestCheckbox();
		direction.clickDirectionButton();
		Assert.assertEquals(chckdomprop.checkInnerText(direction.getShortestRoute()), "Click here to see shortest route");


	}

	@Test(priority=7)
	public void closeBrowser()
	{
		driver.quit();
	}
	


}
