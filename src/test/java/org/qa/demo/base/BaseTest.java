package org.qa.demo.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.qa.demo.factory.DriverFactory;
import org.qa.demo.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	DriverFactory df;
	WebDriver driver;
	Properties prop;
	protected LoginPage loginPage;
	
	@BeforeTest
	public void setUp() {
		
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		//driver = df.initDriver("chrome");
		loginPage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		
	}

}
