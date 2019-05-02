package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	WebDriverWait wait;
	
	@FindBy(name="username")
	WebElement USERNAME;
	
	@FindBy(name="password")
	WebElement PASSWORD;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement LOGIN;
	
	@FindBy(xpath="//font[contains(text(), 'Sign Up')]")
	WebElement SIGNUP;	
	
	@FindBy(xpath="//td[@width='525' and  @class='logo_text']")
	WebElement CRMLOGO;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement LOGOUT;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}
	
	public String Title_Validation() {
		return driver.getTitle();
	}
	public HomePage Login_Verification(String un, String pwd) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(USERNAME));
		Thread.sleep(10000);
		USERNAME.sendKeys(un);
		PASSWORD.sendKeys(pwd);
		LOGIN.click();
		
		return new HomePage();
	}

	public Boolean Logo_Validation() {
		return CRMLOGO.isDisplayed();
	}
	
	public void Logout() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click()", LOGOUT);
		Assert.assertEquals(driver.getTitle(), "CRMPRO  - CRM software for customer relationship management, sales, and support.");
		
	}
	
	
}
