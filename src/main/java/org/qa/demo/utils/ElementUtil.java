package org.qa.demo.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qa.demo.exceptions.ElementException;

public class ElementUtil {
	
	private WebDriver driver;
	
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public void doSendKeys(By locator, String value) {
		nullBlankCheck(value);
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();		
	}
	
	public List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
	public int getElementsCount(By locator){
		return getElements(locator).size();
	}
	
	public boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public String doElementGetAtrribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}
	
	//Select based drop down Utils
	
	public void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	private void nullBlankCheck(String value) {
		if(value==null || value.length()==0) {
			throw new ElementException(value + "...value text cannot be null or blank");
	}
}
		
	public void doSelectByValue(By locator, String value) {
		nullBlankCheck(value);
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public void doSelectByVisibleText(By locator, String visibleText) {
		nullBlankCheck(visibleText);
		Select select = new Select(getElement(locator));
		try {
		select.selectByVisibleText(visibleText);
	}catch(NoSuchElementException e) {
		System.out.println("Visible text is not present in the dropdown");
		e.printStackTrace();
		throw new ElementException("text not present");
	}
	
}
	
	public List<WebElement> getDropDownOptionsList(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions();
	}
	
	public int getDropDownValuesCount(By locator) {
		return getDropDownOptionsList(locator).size();
	}
	
	//wait utils
	
	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}

	public WebElement waitForElementVisible(By locator, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}
	
}