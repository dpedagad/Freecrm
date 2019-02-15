package com.crm.qa.util;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	
	public void switchToFrame(String frame) {
		driver.switchTo().frame(frame);
		
	}
	

}
