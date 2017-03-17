package com.ideyatech.gforce.config;


import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.ideyatech.core.util.BrowserFactory;
import com.ideyatech.core.util.Utility;
import com.ideyatech.gforce.data.WebClassData;
import com.ideyatech.gforce.data.WebStudentData;
import com.ideyatech.gforce.data.WebTeacherData;
import com.ideyatech.gforce.pom.WebClassPOM;
import com.ideyatech.gforce.pom.WebStudentPOM;
import com.ideyatech.gforce.pom.WebTeacherPOM;

public class TestCaseBase {

	public static WebDriver driver;
	public static WebStudentPOM studentPage;
	public static WebStudentData studentData;
	public static WebTeacherPOM teacherPage;
	public static WebTeacherData teacherData;
	public static WebClassPOM classPage;
	public static WebClassData classData;
	 
	public TestCaseBase() {
		
	}

	@BeforeTest
	public void setupTest()
	{
		studentPage = new WebStudentPOM();
		studentData = new WebStudentData();
		teacherPage = new WebTeacherPOM();
		teacherData = new WebTeacherData();
		classPage = new WebClassPOM();
		classData = new WebClassData();
		
		//ExtentReports extent = new ExtentReports();
		driver = BrowserFactory.initializeDriver();
		ProjectRoutines.loginRoutine(driver);
		
	}
	
	@BeforeMethod
	public void beforeTest(Method method)
	{
		//System.out.println(UtilityConfiguration.marionetteDriverLocation);
		Utility.defaultBeforeMethod(method);
		Utility.temporaryWaitSolution();
		Utility.temporaryWaitSolution();
		Utility.goToURL(driver, ProjectConfiguration.homeURL);
	
	}
	
	@AfterMethod
	public void afterMethod(Method method, ITestResult result) throws IOException
	{
		Reporter.setCurrentTestResult(result);
		if (ITestResult.FAILURE == result.getStatus())
		{
			Utility.takeScreenshot(driver, method, "FAILED");
		}
		else
		{
			Utility.takeScreenshot(driver, method, "SUCCESS");
		}
		
		
		
		
	}
	
	@AfterTest
	public void afterTest ()
	{
		//driver.quit();
	}
	// How to destroy webdriver session
	
}
