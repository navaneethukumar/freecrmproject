package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.Base;

public class Loginpage extends Base {
	
	@FindBy(name="email")
	WebElement usename;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement loginbtn;
	
	@FindBy(xpath="//div[@class='header item']")
	WebElement logo;
	
	
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}
	
public String getpagetitle() {
	return driver.getTitle();
}
public boolean logoverify() {
return logo.isDisplayed();	
}
public Homepage login(String un,String pwd) {
	usename.sendKeys(un);
	password.sendKeys(pwd);
	loginbtn.click();
	return new Homepage();
}

	

}
