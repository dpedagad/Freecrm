package com.crm.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	
	//Test cases should be independant with eachother
	//Before each test case launch the browser and login
	//@Test -- Execute the test case
	//After each test case close the browser
	//This is to decrease the load on the browser 
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		Initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
		String title = loginpage.Title_Validation();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	public void LogoImgTest() { 
		boolean flag = loginpage.Logo_Validation();
		assertTrue(flag);
	}
	
	@Test(priority=3)
	public void LoginTest() throws InterruptedException {
		homepage = loginpage.Login_Verification(prop.getProperty("username"), prop.getProperty("password"));
		
	}	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
