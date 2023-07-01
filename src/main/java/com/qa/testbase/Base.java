package com.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.TestUtil;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	
	public Base() {
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("C:\\eclipse-programs\\Freecrmtest\\src\\main\\java\\com\\qa\\config\\config.properties");
		prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void init() {
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			 System.setProperty("webdriver.chrome.driver","C:\\chrome\\chromedriver_win32\\chromedriver.exe");			driver=new ChromeDriver();
		}
		else if(browsername.equals("FF")) {
			 System.setProperty("webdriver.firefox.driver","C:\\chrome\\chromedriver_win32\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITWAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
