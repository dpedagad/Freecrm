package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	Contacts contactsPage;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		Initialization();		
		loginpage = new LoginPage();
		homepage = loginpage.Login_Verification(prop.getProperty("username"), prop.getProperty("password"));
		testutil = new TestUtil();
		contactsPage = new Contacts();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Title didn't match");
	}
	
	@Test(priority=2)
	public void verifyUsernameTest() {
		testutil.switchToFrame("mainpanel");
		Assert.assertTrue(homepage.verifyUsername(), "Username is incorrect");
	}
	
	@Test(priority=3)
	public void verifyContactslinkTest() {
		testutil.switchToFrame("mainpanel");
		contactsPage =	homepage.clickOnContacts();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
