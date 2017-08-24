package com.mapsynq.testclass;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mapsynq.pageclasses.Direction;
import com.mapsynq.pageclasses.Live;
import com.mapsynq.utilityclasses.AlertHandle;
import com.mapsynq.utilityclasses.CheckBrokenLink;
import com.mapsynq.utilityclasses.CheckDomProperties;
import com.mapsynq.utilityclasses.CustomizeReport;
import com.mapsynq.utilityclasses.GetJsonTestData;

@Listeners(CustomizeReport.class)

public class TestMapsynq
{
	Direction direction;
	CheckDomProperties chckdomprop;
	GetJsonTestData getjsontestdata;
	Live live;
	AlertHandle alrthandle;
	CheckBrokenLink chkbrkenlnk;

	private String URL = System.getProperty("url");
	private String BROWSER = System.getProperty("browser");
	static WebDriver driver;
	static String CHROME_PATH = "drivers/chrome/chromedriver";
	static String FIREFOX_PATH = "drivers/firefox/geckodriver";

	// static String validsource="CHANGI AIRPORT";
	// static String validdestination="BOTANIC GARDENS";

	public static WebDriver getDriver()
	{
		// TODO Auto-generated method stub
		return driver;
	}

	@Test(priority = 0, description = "Open a browser with http://www.mapsynq.com/ url")
	public void LaunchURL()
	{
		if (BROWSER.equalsIgnoreCase("Firefox"))
		{
			/*
			 * FirefoxProfile geoDisabled = new FirefoxProfile();
			 * geoDisabled.setPreference("geo.enabled", false);
			 * geoDisabled.setPreference("geo.provider.use_corelocation",
			 * false); geoDisabled.setPreference("geo.prompt.testing", false);
			 * geoDisabled.setPreference("geo.prompt.testing.allow", false);
			 * DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			 * capabilities.setCapability(FirefoxDriver.PROFILE, geoDisabled);
			 */
			System.setProperty("webdriver.gecko.driver", FIREFOX_PATH);

			driver = new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("Safari"))
		{
			driver = new SafariDriver();
		}
		else if (BROWSER.equalsIgnoreCase("Chrome"))
		{
			/*
			 * ChromeOptions options = new ChromeOptions();
			 * options.addArguments("start-maximized");
			 * options.addArguments("test-type"); options.addArguments(
			 * "enable-strict-powerful-feature-restrictions");
			 * options.addArguments("disable-geolocation"); //cap = null;
			 * DesiredCapabilities cap = null;
			 * cap.setCapability(ChromeOptions.CAPABILITY, options); cap =
			 * cap.merge(DesiredCapabilities.chrome());
			 */
			System.setProperty("webdriver.chrome.driver", CHROME_PATH);
			driver = new ChromeDriver();
		}

		driver.get(URL);
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		live = new Live(driver);
		Assert.assertEquals(live.getPageTitle(), "mapSYNQ - Live Traffic Information Platform");

	}

	@Test(priority = 1, description = "Click Directions Tab ")
	public void clickDirectiontab()
	{
		direction = new Direction(driver);
		chckdomprop = new CheckDomProperties(driver);
		alrthandle = new AlertHandle(driver);
		getjsontestdata = new GetJsonTestData(driver);
		live.clickDirectionLink();
		Assert.assertEquals(chckdomprop.checkInnerText(direction.getClearRouteElement()), "Clear Route");
	}

	@Test(priority = 2, description = "Click Clear Route link under Directions Page")
	public void testClearRoute()

	{
		direction.clickRouteClear();
	}

	@Test(priority = 3, description = "Click Get Directions button with blank A and B fields under Directions Page")
	public void testBlankSourceDesinationTraficAwareRoute() throws FileNotFoundException, JSONException, InterruptedException

	{
		direction.clickRouteClear();
		direction.clickDirectionButton();
		alrthandle.acceptAlert();

	}

	@Test(priority = 4, description = "Click Get Directions button with valid data in A and B fields under Directions Page")
	public void testTraficAwareRoute() throws FileNotFoundException, JSONException, InterruptedException

	{
		direction.clickRouteClear();
		// direction.setSource(getjsontestdata.getData("validsource"));
		// direction.setDestination(getjsontestdata.getData("validdestination"));
		direction.setSourceDestination(getjsontestdata.getData("validsource"), getjsontestdata.getData("validdestination"));
		direction.clickDirectionButton();

		Assert.assertEquals(chckdomprop.checkInnerText(direction.getTraficRoute()), "Click here to see traffic aware route");

	}

	@Test(priority = 5, description = "Uncheck Trafic Aware and Checked Toll Aware,then Click Get Directions button with valid data in A and B fields under Directions Page")
	public void TestTollAwareRoute() throws InterruptedException

	{
		direction.clickTraficCheckbox();
		direction.clickTollAwareCheckbox();
		direction.clickDirectionButton();
		Assert.assertEquals(chckdomprop.checkInnerText(direction.getTollAwareRoute()), "Click here to see toll aware route");

	}

	@Test(priority = 6, description = "Uncheck Toll Aware and Checked Fatest,then Click Get Directions button with valid data in A and B fields under Directions Page")
	public void TestFatestRoute()

	{
		direction.clickTollAwareCheckbox();
		direction.clickFatestCheckbox();
		direction.clickDirectionButton();
		Assert.assertEquals(chckdomprop.checkInnerText(direction.getFatestRoute()), "Click here to see fastest route");

	}

	@Test(priority = 7, description = "Uncheck Fatest and Checked Shortest,then Click Get Directions button with valid data in A and B fields under Directions Page")
	public void TestShortestRoute()

	{
		direction.clickFatestCheckbox();
		direction.clickShortestCheckbox();
		direction.clickDirectionButton();
		Assert.assertEquals(chckdomprop.checkInnerText(direction.getShortestRoute()), "Click here to see shortest route");
	}

	@Test(priority = 8, description = "Click Live Tab")
	public void ClickLiveTab()

	{
		direction.clickLiveTab();
		Assert.assertEquals(chckdomprop.checkPlaceHolder(live.getPlaceHolder()), "Search incident location");
		// Thread.sleep(10000);

	}

	@Test(priority = 9, description = "Check Singapore Live Traffic News")
	public void CheckSingaporeLiveTrafficNews()

	{
		for (WebElement el : live.getSingaporeLiveTrafficNews())
		{
			Reporter.log(el.getText(), true);
		}

	}

	@Test(priority = 10, description = "Click Camera Tab Under Live Page")
	public void ClickCameraTab()

	{

		live.clickCamerasTab();
		Assert.assertEquals(chckdomprop.checkPlaceHolder(live.getPlaceHolderforCamera()), "Search camera location");
	}

	@Test(priority = 11, description = "Check Singapore Live Traffic Cameras")
	public void SingaporeLiveTrafficCameras()

	{

		for (WebElement el1 : live.getSingaporeLiveTrafficCameras())
		{
			Reporter.log(el1.getText(), true);
		}
	}

	@Test(priority = 12, description = "Check Malaysia Live Traffic Cameras")
	public void MalaysiaLiveTrafficCameras()

	{

		for (WebElement el1 : live.getMalaysiaLiveTrafficCameras())
		{
			Reporter.log(el1.getText(), true);
		}
	}

	@Test(priority = 13, description = "Check Srilanka Live Traffic Cameras")
	public void SrilankaLiveTrafficCameras()

	{
		for (WebElement el1 : live.getSrilankaLiveTrafficCameras())
		{
			Reporter.log(el1.getText(), true);
		}
	}

	@Test(priority = 14, description = "Test Count of links and images")
	public void TestCountTotalLink()

	{
		chkbrkenlnk = new CheckBrokenLink(driver);
		Reporter.log(chkbrkenlnk.countLinks(), true);

	}

	@Test(priority = 15, description = "Test Count of invalid links and images")
	public void TestCountInvalidLink()

	{
		Reporter.log(chkbrkenlnk.countInvalidLinks(), true);
	}

	@Test(priority = 16, description = "Click Tolls Tab")
	public void ClickTollsLink()

	{
		live.clickTollsTab();
		Assert.assertEquals(chckdomprop.checkPlaceHolder(live.getPlaceHolderforTolls()), "Search gantry location");
	}

	@Test(priority = 17, description = "Check Singapore Tolls")
	public void CheckSingaporeTolls()

	{

		live.getSingaporeTolls();
	}

	@Test(priority = 18, description = "Check Malaysia Tolls")
	public void CheckMalaysiaTolls()
	{

		live.getMalaysiaTolls();
	}

	@Test(priority = 19, description = "Check Thiland Tolls")
	public void CheckThialndTolls()

	{
		live.getThilandTolls();

	}

	@Test(priority = 20, description = "Click First Singapore Toll Link")
	public void ClickFirstSignaporeTollLink()

	{
		live.clickFirstLinkOfSingaporeToll();

	}

	@Test(priority = 21, description = "Switch To Price List Dropdown")
	public void SwitchToPriceListDropdown() throws InterruptedException

	{

		live.SwitchToTollPriceFrame();
	}

	@Test(priority = 22, description = "Get Time and Toll Rates Large Vehicle (Weekdays) of Singapore First Toll link ")
	public void GetPriceAndRatesLargeVehicleWeekdays()

	{
		live.getTimeAndRatesLargeVechileWeekdays();
	}

	@Test(priority = 23, description = "Get Time and Toll Rates Car (Saturday) of Singapore First Toll link")
	public void GetPriceAndRatesCarSaturday()

	{

		live.getTimeAndRatesCarSaturday();

	}

	@Test(priority = 24, description = "Get Time and Toll Rates MotorCycle (Weekdays) of Singapore First Toll link")
	public void GetPriceAndRatesMotorCycleWeekdays()

	{
		live.getTimeAndRatesMotorCycleWeekdays();
	}

	@Test(priority = 25, description = "Get Time and Toll Rates MotorCycle (Saturday) of Singapore First Toll link")
	public void GetPriceAndRatesMotorCycleSaturday()

	{
		live.getTimeAndRatesMotorCycleSaturday();
	}

	@Test(priority = 26, description = "Get Time and Toll Rates Car (Weekdays) of Singapore First Toll link")
	public void GetPriceAndRatesCarWeekdays()

	{
		live.getTimeAndRatesCarWeekdays();
	}

	@Test(priority = 27, description = "Get Time and Toll Rates Large Vehicle (Saturday) of Singapore First Toll link")
	public void GetPriceAndRatesLargeVehicleSaturday()

	{
		live.getTimeAndRatesLargeVehicleSaturday();
	}

	@Test(priority = 28, description = "Get Time and Toll Rates Heavy Vehicle (Weekdays) of Singapore First Toll link")
	public void GetPriceAndRatesHeavyVehicleWeekdays()

	{
		live.getTimeAndRatesHeavyVehicleWeekdays();
	}

	@Test(priority = 29, description = "Get Time and Toll Rates Heavy Vehicle (Saturday) of Singapore First Toll link")
	public void GetPriceAndRatesHeavyVehicleSaturday()

	{
		live.getTimeAndRatesHeavyVehicleSaturday();
	}

	@Test(priority = 30, description = "Get Time and Toll Rates Very Heavh Vehicle (Weekdays) of Singapore First Toll link")
	public void GetPriceAndRatesVeryHeavhVehicleWeekdays()

	{
		live.getTimeAndRatesVeryHeavhVehicleWeekdays();
	}

	@Test(priority = 31, description = "Get Time and Toll Rates Very Heavh Vehicle (Saturday) of Singapore First Toll link")
	public void GetPriceAndRatesVeryHeavhVehicleSaturday()

	{
		live.getTimeAndRatesVeryHeavhVehicleSaturday();
	}
}
