package com.ideyatech.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilityConfiguration {
	
	public final static String marionetteDriverLocation = "AddOns\\BrowserDriver\\geckoDriver.exe";
	
	public final static String chromeDriverLocation = "AddOns\\BrowserDriver\\chromeDriver.exe";
	
	public final static String screenshotFilePath = "test-output\\Test-Screenshot\\" + generateTimeNow() + "\\";
	public final static String screenshotFileType = ".png";
	
	public final static String reportFilePath = "Test-Screenshot\\" + generateTimeNow() + "\\";
	public final static int driverWait_Duration = 10;
	
	public static String generateTimeNow()
	{
	
		Date dt = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		return dateFormat.format(dt);
		
	}

}
