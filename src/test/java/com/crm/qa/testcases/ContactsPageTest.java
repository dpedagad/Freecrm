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

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testutil;
	
	
	
	public ContactsPageTest(){
		super();
	}

	@Parameters("browserName")
	@BeforeMethod
	public void setUp(String browserName) throws InterruptedException{
		Initialization(browserName);
		loginPage = new LoginPage();
		homePage = loginPage.Login_Verification(prop.getProperty("username"), prop.getProperty("password"));
		driver.switchTo().frame("mainpanel");
		contactsPage = homePage.clickOnContacts();		
	}
	
	@Test(priority=1)
	public void VerifyContactsLabelTest() {
		Assert.assertTrue(contactsPage.VerifyContactsLabel(), "Contacts label is not displayed");
	}
	
	@Test(priority=2)
	public void SelectNewContact() {
		contactsPage.SelectNewContact();
		loginPage.Logout();
	}
	

	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}
	
}
