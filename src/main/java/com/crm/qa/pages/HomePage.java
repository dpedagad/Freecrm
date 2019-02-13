package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(), 'Deepak P')]")
	WebElement userNameLabel;	
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement ContactsLink;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement DealsLink;
	
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement TasksLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public Boolean verifyUsername() {
		return userNameLabel.isDisplayed();
	}
	
	public Contacts clickOnContacts() {
		ContactsLink.click();
		return new Contacts();
	}
}
