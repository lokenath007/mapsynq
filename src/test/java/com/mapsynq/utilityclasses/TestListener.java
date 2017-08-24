package com.mapsynq.utilityclasses;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.mapsynq.testclass.TestMapsynq;



public class TestListener implements ITestListener {
	WebDriver driver=null;
	String filePath = System.getProperty("user.dir")+"/Screenshots/";
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("***** Error "+result.getName()+" test has failed *****");
		String methodName=result.getName().toString().trim();
		takeScreenShot(methodName);
	}


	public void takeScreenShot(String methodName) {
		//get the driver
		driver=TestMapsynq.getDriver();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with test method name 
		try {
			FileUtils.copyFile(scrFile, new File(filePath+methodName+timestamp()+".png"));
			System.out.println("***Placed screen shot in "+filePath+" ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private String timestamp()
	{
		// TODO Auto-generated method stub
		//return null;
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}


	public void onFinish(ITestContext context) {}

	public void onTestStart(ITestResult result) {   }

	public void onTestSuccess(ITestResult result) {   }

	public void onTestSkipped(ITestResult result) {   }

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

	public void onStart(ITestContext context) {   }
} 