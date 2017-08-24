package com.mapsynq.pageclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
//import org.testng.annotations.Test;

public class Live
{
	By directionlink = By.xpath("//*[@id='info_panel']/div[1]/div/a[1]");
	By incidentLink = By.id("rdIncidents");
	By camerasLink = By.id("rdCameras");
	By tollsLink = By.id("rdErp");
	By incidentslink = By.id("search_incident_singapore");
	By cameraLocationSingapore = By.id("camera_location_singapore");
	By cameraLocationMalaysia = By.id("camera_location_malaysia");
	By cameraLocationSrilanka = By.id("camera_location_srilanka");
	By tollerplocationsingapore = By.id("erp_locationsingapore");
	By tollerplocationmalaysia = By.id("erp_locationmalaysia");
	By tollerplocationthiland = By.id("erp_locationthailand");
	By selectpricechart = By.id("select_price_chart");
	private WebDriver driver;
	private String txtplaceholder = "document.getElementById('txtSearchIncidentsingapore')";
	private String txtplaceholdercamera = "document.getElementById('txtSearchCamerasingapore')";
	private String txtplaceholdertoll = "document.getElementById('txtSearchERPsingapore')";
	By carSaturday = By.id("car_s");
	By motorCycleWeekdays = By.id("mc_m");
	By motorCycleSaturday = By.id("mc_s");
	By carWeekdays = By.id("car_m");
	By largeVehicleWeekdays = By.id("lgv_m");
	By largeVehicleSaturday = By.id("lgv_s");
	By heavyVehicleWeekdays = By.id("hgv_m");
	By heavyVehicleSaturday = By.id("hgv_s");
	By veryHeavhVehicleWeekdays = By.id("vhgv_m");
	By veryHeavhVehicleSaturday = By.id("vhgv_s");

	By xPathTabCarSaturday = By.xpath("id('car_s')/tbody/tr");
	By xPathTableMotorCycleWeekdays = By.xpath("id('mc_m')/tbody/tr");
	By xPathTableMotorCycleSaturday = By.xpath("id('mc_s')/tbody/tr");
	By xPathTableCarWeekdays = By.xpath("id('car_m')/tbody/tr");
	By xPathTableLargeVehicleWeekdays = By.xpath("id('lgv_m')/tbody/tr");
	By xPathTableLargeVehicleSaturday = By.xpath("id('lgv_s')/tbody/tr");
	By xPathTableHeavyVehicleWeekdays = By.xpath("id('hgv_m')/tbody/tr");
	By xPathTableHeavyVehicleSaturday = By.xpath("id('hgv_s')/tbody/tr");
	By xPathTableVeryHeavhVehicleWeekdays = By.xpath("id('vhgv_m')/tbody/tr");
	By xPathTableVeryHeavhVehicleSaturday = By.xpath("id('vhgv_s')/tbody/tr");

	private String visbleTextCarSaturday = "Car (Saturday)";
	private String visbleTextMotorcycleWeekdays = "Motorcycle (Weekdays)";
	private String visbleTextMotorcycleSaturday = "Motorcycle (Saturday)";
	private String visbleTextCarWeekdays = "Car (Weekdays)";
	private String visbleTextLargeVehicleWeekdays = "Large Vehicle (Weekdays)";
	private String visbleTextLargeVehicleSaturday = "Large Vehicle (Saturday)";
	private String visbleTextHeavyVehicleWeekdays = "Heavy Vehicle (Weekdays)";
	private String visbleTextHeavyVehicleSaturday = "Heavy Vehicle (Saturday)";
	private String visbleTextVeryHeavhVehicleWeekdays = "Very Heavh Vehicle (Weekdays)";
	private String visbleTextVeryHeavhVehicleSaturday = "Very Heavh Vehicle (Saturday)";

	public Live(
			WebDriver driver)
	{

		this.driver = driver;

	}

	public String getPlaceHolder()
	{
		return txtplaceholder;

	}

	public String getPlaceHolderforCamera()
	{
		return txtplaceholdercamera;

	}

	public String getPlaceHolderforTolls()
	{
		return txtplaceholdertoll;

	}

	public void clickDirectionLink()
	{
		WebDriverWait directionlinkwt = new WebDriverWait(driver, 10);
		directionlinkwt.until(ExpectedConditions.elementToBeClickable(directionlink));
		driver.findElement(directionlink).click();

	}

	public String getPageTitle()

	{
		return driver.getTitle();

	}

	public void clickIncidentTab()
	{
		WebDriverWait directionlinkwt = new WebDriverWait(driver, 10);
		directionlinkwt.until(ExpectedConditions.elementToBeClickable(incidentLink));
		driver.findElement(incidentLink).click();

	}

	public void clickCamerasTab()
	{
		WebDriverWait directionlinkwt = new WebDriverWait(driver, 10);
		directionlinkwt.until(ExpectedConditions.elementToBeClickable(camerasLink));
		// driver.findElement(camerasLink).click();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(camerasLink)).click().perform();
	}

	public void clickTollsTab()
	{
		WebDriverWait directionlinkwt = new WebDriverWait(driver, 10);
		directionlinkwt.until(ExpectedConditions.elementToBeClickable(tollsLink));
		// driver.findElement(tollsLink).click();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(tollsLink)).click().perform();

	}

	public List<WebElement> getSingaporeLiveTrafficNews()
	{
		WebDriverWait directionlinkwt = new WebDriverWait(driver, 10);
		directionlinkwt.until(ExpectedConditions.elementToBeClickable(tollsLink));
		return driver.findElement(incidentslink).findElements(By.className("incident_link"));

	}

	public List<WebElement> getSingaporeLiveTrafficCameras()
	{
		WebDriverWait directionlinkwt = new WebDriverWait(driver, 10);
		directionlinkwt.until(ExpectedConditions.elementToBeClickable(cameraLocationSingapore));
		return driver.findElements(cameraLocationSingapore);
	}

	public List<WebElement> getMalaysiaLiveTrafficCameras()
	{
		WebDriverWait directionlinkwt = new WebDriverWait(driver, 10);
		directionlinkwt.until(ExpectedConditions.elementToBeClickable(cameraLocationMalaysia));
		return driver.findElements(cameraLocationMalaysia);
	}

	public List<WebElement> getSrilankaLiveTrafficCameras()
	{
		WebDriverWait directionlinkwt = new WebDriverWait(driver, 10);
		directionlinkwt.until(ExpectedConditions.elementToBeClickable(cameraLocationSrilanka));
		return driver.findElements(cameraLocationSrilanka);
	}

	public void getSingaporeTolls()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		List<WebElement> labels = (List<WebElement>) js.executeScript(
				"return document.getElementById('erp_locationsingapore').getElementsByClassName('erp_list');");
		for (WebElement label : labels)
		{
			Reporter.log(label.getAttribute("innerText").trim(), true);
		}
	}

	public void clickFirstLinkOfSingaporeToll()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		List<WebElement> labels = (List<WebElement>) js.executeScript(
				"return document.getElementById('erp_locationsingapore').getElementsByClassName('erp_list');");
		labels.get(0).click();
	}

	public void getMalaysiaTolls()
	{
		// WebDriverWait directionlinkwt = new WebDriverWait(driver, 10);
		// directionlinkwt.until(ExpectedConditions.elementToBeClickable(tollerplocationsingapore));
		// return driver.findElements(tollerplocationsingapore);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		List<WebElement> labels = (List<WebElement>) js.executeScript(
				"return document.getElementById('erp_locationmalaysia').getElementsByClassName('erp_list');");

		for (WebElement label : labels)
		{
			Reporter.log(label.getAttribute("innerText").trim(), true);
		}
	}

	public void getThilandTolls()
	{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		List<WebElement> labels = (List<WebElement>) js.executeScript(
				"return document.getElementById('erp_locationthailand').getElementsByClassName('erp_list');");

		for (WebElement label : labels)
		{
			Reporter.log(label.getAttribute("innerText").trim(), true);
		}
	}

	public void getTimeAndRatesLargeVechileWeekdays()
	{
		Select myselctbox = new Select(driver.findElement(selectpricechart));
		myselctbox.selectByVisibleText(visbleTextLargeVehicleWeekdays);
		WebElement table_element = driver.findElement(largeVehicleWeekdays);
		List<WebElement> tr_collection = table_element.findElements(By.xpath("id('lgv_m')/tbody/tr"));
		int row_num, col_num;
		row_num = 1;
		Reporter.log(visbleTextLargeVehicleWeekdays, true);
		for (WebElement trElement : tr_collection)
		{
			List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
			col_num = 1;
			for (WebElement tdElement : td_collection)
			{
				// System.out.print(tdElement.getText());
				Reporter.log(tdElement.getText(), true);
				col_num++;
			}
			row_num++;
		}
	}

	public void getTimeAndRatesCarSaturday()
	{
		Select myselctbox = new Select(driver.findElement(selectpricechart));
		myselctbox.selectByVisibleText(visbleTextCarSaturday);
		WebElement table_element = driver.findElement(carSaturday);
		List<WebElement> tr_collection = table_element.findElements(By.xpath("id('car_s')/tbody/tr"));
		int row_num, col_num;
		row_num = 1;
		Reporter.log(visbleTextCarSaturday, true);
		for (WebElement trElement : tr_collection)
		{
			List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
			col_num = 1;
			for (WebElement tdElement : td_collection)
			{
				// System.out.print(tdElement.getText());
				Reporter.log(tdElement.getText(), true);
				col_num++;
			}
			row_num++;
		}
	}

	public void getTimeAndRatesMotorCycleWeekdays()
	{
		Select myselctbox = new Select(driver.findElement(selectpricechart));
		myselctbox.selectByVisibleText(visbleTextMotorcycleWeekdays);
		WebElement table_element = driver.findElement(motorCycleWeekdays);
		List<WebElement> tr_collection = table_element.findElements(xPathTableMotorCycleWeekdays);
		int row_num, col_num;
		row_num = 1;
		Reporter.log(visbleTextMotorcycleWeekdays, true);
		for (WebElement trElement : tr_collection)
		{
			List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
			col_num = 1;
			for (WebElement tdElement : td_collection)
			{
				// System.out.print(tdElement.getText());
				Reporter.log(tdElement.getText(), true);
				col_num++;
			}
			row_num++;
		}
	}

	public void getTimeAndRatesMotorCycleSaturday()
	{
		Select myselctbox = new Select(driver.findElement(selectpricechart));
		myselctbox.selectByVisibleText(visbleTextMotorcycleSaturday);
		WebElement table_element = driver.findElement(largeVehicleSaturday);
		List<WebElement> tr_collection = table_element.findElements(xPathTableMotorCycleSaturday);
		int row_num, col_num;
		row_num = 1;
		Reporter.log(visbleTextMotorcycleSaturday, true);
		for (WebElement trElement : tr_collection)
		{
			List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
			col_num = 1;
			for (WebElement tdElement : td_collection)
			{
				// System.out.print(tdElement.getText());
				Reporter.log(tdElement.getText(), true);
				col_num++;
			}
			row_num++;
		}
	}

	public void getTimeAndRatesCarWeekdays()
	{
		Select myselctbox = new Select(driver.findElement(selectpricechart));
		myselctbox.selectByVisibleText(visbleTextCarWeekdays);
		WebElement table_element = driver.findElement(carWeekdays);
		List<WebElement> tr_collection = table_element.findElements(xPathTableCarWeekdays);
		int row_num, col_num;
		row_num = 1;
		Reporter.log(visbleTextCarWeekdays, true);
		for (WebElement trElement : tr_collection)
		{
			List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
			col_num = 1;
			for (WebElement tdElement : td_collection)
			{
				// System.out.print(tdElement.getText());
				Reporter.log(tdElement.getText(), true);
				col_num++;
			}
			row_num++;
		}
	}

	public void getTimeAndRatesLargeVehicleSaturday()
	{
		Select myselctbox = new Select(driver.findElement(selectpricechart));
		myselctbox.selectByVisibleText(visbleTextLargeVehicleSaturday);
		WebElement table_element = driver.findElement(largeVehicleSaturday);
		List<WebElement> tr_collection = table_element.findElements(xPathTableLargeVehicleSaturday);
		int row_num, col_num;
		row_num = 1;
		Reporter.log(visbleTextLargeVehicleSaturday, true);
		for (WebElement trElement : tr_collection)
		{
			List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
			col_num = 1;
			for (WebElement tdElement : td_collection)
			{
				// System.out.print(tdElement.getText());
				Reporter.log(tdElement.getText(), true);
				col_num++;
			}
			row_num++;
		}
	}

	public void getTimeAndRatesHeavyVehicleWeekdays()
	{
		Select myselctbox = new Select(driver.findElement(selectpricechart));
		myselctbox.selectByVisibleText(visbleTextHeavyVehicleWeekdays);
		WebElement table_element = driver.findElement(heavyVehicleWeekdays);
		List<WebElement> tr_collection = table_element.findElements(xPathTableHeavyVehicleWeekdays);
		int row_num, col_num;
		row_num = 1;
		Reporter.log(visbleTextHeavyVehicleWeekdays, true);
		for (WebElement trElement : tr_collection)
		{
			List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
			col_num = 1;
			for (WebElement tdElement : td_collection)
			{
				// System.out.print(tdElement.getText());
				Reporter.log(tdElement.getText(), true);
				col_num++;
			}
			row_num++;
		}
	}

	public void getTimeAndRatesHeavyVehicleSaturday()
	{
		Select myselctbox = new Select(driver.findElement(selectpricechart));
		myselctbox.selectByVisibleText(visbleTextHeavyVehicleSaturday);
		WebElement table_element = driver.findElement(heavyVehicleSaturday);
		List<WebElement> tr_collection = table_element.findElements(xPathTableHeavyVehicleSaturday);
		int row_num, col_num;
		row_num = 1;
		Reporter.log(visbleTextHeavyVehicleSaturday, true);
		for (WebElement trElement : tr_collection)
		{
			List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
			col_num = 1;
			for (WebElement tdElement : td_collection)
			{
				// System.out.print(tdElement.getText());
				Reporter.log(tdElement.getText(), true);
				col_num++;
			}
			row_num++;
		}

	}

	public void getTimeAndRatesVeryHeavhVehicleWeekdays()
	{
		Select myselctbox = new Select(driver.findElement(selectpricechart));
		myselctbox.selectByVisibleText(visbleTextVeryHeavhVehicleWeekdays);
		WebElement table_element = driver.findElement(veryHeavhVehicleWeekdays);
		List<WebElement> tr_collection = table_element.findElements(xPathTableVeryHeavhVehicleWeekdays);
		int row_num, col_num;
		row_num = 1;
		Reporter.log(visbleTextVeryHeavhVehicleWeekdays, true);
		for (WebElement trElement : tr_collection)
		{
			List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
			col_num = 1;
			for (WebElement tdElement : td_collection)
			{
				// System.out.print(tdElement.getText());
				Reporter.log(tdElement.getText(), true);
				col_num++;
			}
			row_num++;
		}

	}

	public void getTimeAndRatesVeryHeavhVehicleSaturday()
	{
		Select myselctbox = new Select(driver.findElement(selectpricechart));
		myselctbox.selectByVisibleText(visbleTextVeryHeavhVehicleSaturday);
		WebElement table_element = driver.findElement(veryHeavhVehicleSaturday);
		List<WebElement> tr_collection = table_element.findElements(xPathTableVeryHeavhVehicleSaturday);
		int row_num, col_num;
		row_num = 1;
		Reporter.log(visbleTextVeryHeavhVehicleSaturday, true);
		for (WebElement trElement : tr_collection)
		{
			List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
			col_num = 1;
			for (WebElement tdElement : td_collection)
			{
				// System.out.print(tdElement.getText());
				Reporter.log(tdElement.getText(), true);
				col_num++;
			}
			row_num++;
		}

	}

	public void SwitchToTollPriceFrame()
	{
	try{
		driver.switchTo().frame("myDropdownList");
	}
	catch (NoSuchFrameException e) {
		System.out.println("Unable to locate frame with id " + e.getStackTrace());

}
}
}