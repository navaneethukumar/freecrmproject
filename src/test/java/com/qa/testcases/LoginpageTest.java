package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.crm.pages.Homepage;
import com.qa.crm.pages.Loginpage;
import com.qa.testbase.Base;

public class LoginpageTest extends Base {
	Loginpage loginpge;
	Homepage homepage;
	public LoginpageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		init();
		loginpge=new Loginpage();
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	@Test(priority=1)
	public void clicklogin() {
		homepage=loginpge.login(prop.getProperty("username"),prop.getProperty("password"));
		
		}
	@Test(priority=2)
	public void verifytitle() {
		String title=loginpge.getpagetitle();
		System.out.println("title is "+title);
	}
//	@Test(priority=3)
	/*public void verifylogo() {
		boolean flag=loginpge.logoverify();
		assertTrue(flag);
	}*/
	
	

}
