package org.qa.demo.tests;


import org.testng.Assert;
import org.qa.demo.base.BaseTest;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseTest {
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {		
   String actTitle=loginPage.getLoginPageTitle();
   Assert.assertEquals(actTitle, "Account Login");
  }
	
	@Test(priority=2)
	public void loginPageURLTest() {
		String actUrl = loginPage.getLoginPageUrl();
		Assert.assertTrue(actUrl.contains("route=account/login"));
	}
	
	@Test(priority=3)
	public void forgotPasswdLinkTest() {
		Assert.assertTrue(loginPage.isForgottenPasswordLinkExists());
	}
	
	@Test(priority=4)
	public void loginTest() {
	String accPageTitle = loginPage.doLogin("dec2023@opencart.con", "Selenium@12345");
	System.out.println(accPageTitle);
	Assert.assertEquals("accPageTitle", "My Account");	
	}

}
