package org.qa.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qa.demo.utils.ElementUtil;

public class LoginPage {
	
	//1. Private By Locators to locate the elements
	//2. public page class constructor
	//3. public page Actions/Methods
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By emailId = By.id("input-email");
	private By passwd = By.id("input-password");
	private By loginBtn = By.xpath("//input[@type='submit']");
	private By forgotPasswdLink = By.linkText("Forgotten Password");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getLoginPageTitle() {
		String title = driver.getTitle();
		System.out.println("title of the page is: " + title);
		return title;
		
	}
	
	public String getLoginPageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println("Url of the page is: " + url);
		return url;
		
	}
	
	public boolean isForgottenPasswordLinkExists() {
		//return driver.findElement(forgotPasswdLink).isDisplayed();
		return eleUtil.isElementDisplayed(forgotPasswdLink);
	}
	
	public String doLogin(String username, String password) {
		//driver.findElement(emailId).sendKeys(username);
		eleUtil.getElement(emailId).sendKeys(username);
	    eleUtil.doSendKeys(passwd, password);
		eleUtil.doClick(loginBtn);
		//driver.findElement(passwd).sendKeys(password);
		//driver.findElement(loginBtn).click();
		return driver.getTitle();
	}
	

}
