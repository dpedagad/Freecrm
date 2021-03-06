package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	TestUtil testutil;
	ContactsPage contactsPage;
	public HomePageTest() {
		super();
	}
	
	@Parameters("browserName")
	@BeforeMethod
	public void setUp(String browserName) throws InterruptedException{
		Initialization(browserName);		
		loginPage = new LoginPage();
		homePage = loginPage.Login_Verification(prop.getProperty("username"), prop.getProperty("password"));
		testutil = new TestUtil();
		contactsPage = new ContactsPage();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Title didn't match");
	}
	
	@Test(dependsOnMethods ={"verifyHomePageTitleTest"},priority=2)
	public void verifyUsernameTest() {
		testutil.switchToFrame("mainpanel");
		Assert.assertTrue(homePage.verifyUsername(), "Username is incorrect");
	}
	
	@Test(dependsOnMethods ={"verifyHomePageTitleTest"}, priority=3)
	public void verifyContactslinkTest() {
		testutil.switchToFrame("mainpanel");
		contactsPage =	homePage.clickOnContacts();		
		loginPage.Logout();
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}
}
