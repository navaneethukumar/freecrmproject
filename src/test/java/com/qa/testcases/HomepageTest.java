package com.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.pages.Homepage;
import com.qa.crm.pages.Loginpage;
import com.qa.testbase.Base;
import com.qa.util.TestUtil;

public class HomepageTest extends Base {
	Homepage homepage;
	Loginpage login;
	TestUtil TestUtil;
	String sheetName="contacts";
	public HomepageTest() {
		super();
		
	}
	/*
	 * @DataProvider (name = "name_of_dataprovider") public Object[][] dpMethod() {
	 * return new Object [][] { values} }
	 */
	
	/*
	 * @DataProvider (name = "getcdata") public Object[][] getcdata(){ Object
	 * data[][]=TestUtil.getTestData("contacts");
	 * System.out.println("dats ius "+data); return data; }
	 */
	


	@BeforeMethod
	public void setp() throws InterruptedException {
		init();
		login=new Loginpage();
		login.login(prop.getProperty("username"),prop.getProperty("password"));
		
		
	}

//@Test(dataProvider="getcdata")
@Test
			public void gettitlecomtats() throws InterruptedException {
	homepage=new Homepage();
	homepage.savecontact("firstname","lastname");
	System.out.println("done saving the contact");
		String title=homepage.getcontactslinktitle();
		System.out.println("contact title is "+title);
	}

	

}
