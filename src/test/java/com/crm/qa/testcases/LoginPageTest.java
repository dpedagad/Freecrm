package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.AssertJUnit;
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
	
	LoginPage loginPage;
	HomePage homePage;
	
	SoftAssert softAssert = new SoftAssert();
	
	public LoginPageTest() {
		super();
	}
	@Parameters("browserName")
	@BeforeMethod
	public void setUp(String browserName) {
		Initialization(browserName);
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
		String title = loginPage.Title_Validation();
		softAssert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		
	}
	
//	@Test(priority=2)
//	public void LogoImgTest() { 
//		//driver.switchTo().frame("leftpanel");
//		boolean flag = loginpage.Logo_Validation();
//		Assert.assertTrue(flag);
//	}
	
	@Test(priority=3)
	public void LoginTest() throws InterruptedException {
		homePage = loginPage.Login_Verification(prop.getProperty("username"), prop.getProperty("password"));
		loginPage.Logout();
	}	
	@AfterMethod
	public void tearDown() {			
		driver.quit();
	}
	
}
