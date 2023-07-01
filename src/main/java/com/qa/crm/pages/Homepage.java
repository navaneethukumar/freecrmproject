package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.Base;
import com.qa.util.TestUtil;

public class Homepage extends Base {
	contactspage contacts=new contactspage();
	TestUtil util=new TestUtil();

	@FindBy(xpath = "//div[@class='header item']")
	WebElement logo;
	@FindBy(xpath = "//span[@class='user-display']")
	WebElement myname;

	@FindBy(xpath = "//i[@class='users icon']")
	WebElement mouseovercontacts;
	@FindBy(xpath = "//span[normalize-space()='Contacts']")
	WebElement contactslink;
	
	@FindBy(xpath = "//button[normalize-space()='Create']")
	WebElement create;
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstname;
	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastname;
	@FindBy(xpath = "//i[@class='save icon']")
	WebElement savebtn;
	

	

	
	
	
	
	
	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	public contactspage savecontact(String fname,String lname) throws InterruptedException {
		  util.Switchtoalert(mouseovercontacts);
		  contactslink.click();
		  Thread.sleep(2000);
		  create.click();
		  Thread.sleep(2000);
		  firstname.sendKeys(fname);
		  Thread.sleep(2000);
		  lastname.sendKeys(lname);
		  Thread.sleep(5000);
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].click()", savebtn);
	//	  savebtn.click();
		  System.out.println("clicked save");
		  return new contactspage();
	}
	public contactspage gotocontactspage() {
		  util.Switchtoalert(mouseovercontacts);
		  contactslink.click();
		  return new contactspage();
	}
	public String getcontactslinktitle() {
		return driver.getTitle();
	}
	public String getcontactsurl() {
		return driver.getCurrentUrl();
	}
	
	

}
