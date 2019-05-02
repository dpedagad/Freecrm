package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement ContactsLink;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement NewContact;
	
	@FindBy(xpath="//td[contains(text(), 'Contacts')]")
	WebElement ContactsLabel;
	
	@FindBy(xpath="//strong[text() = 'Title']")
	WebElement Title;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public Boolean VerifyContactsLabel() {
		return ContactsLabel.isDisplayed();
	}
	
	public Boolean SelectNewContact() {
		Actions action = new Actions(driver);
		action.moveToElement(ContactsLink);
		action.moveToElement(NewContact).click().build().perform();
		
		return Title.isDisplayed();
	}

}
