package com.ideyatech.gforce.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ideyatech.core.util.Utility;

public class ProjectRoutines {

	public static void loginRoutine(WebDriver driver )
	{
		By login_Username_Field = By.name("username");
		By login_Password_Field = By.name("password");
		By login_login_Button = By.cssSelector("button.btn.btn-primary");
		String login_username = "gab";
		String login_password = "123qwe123";
		
		driver.get(ProjectConfiguration.url);
		
		Utility.typeThis(driver, login_Username_Field, login_username);
		Utility.typeThis(driver, login_Password_Field, login_password);
		Utility.clickThis(driver, login_login_Button);

	}
}
