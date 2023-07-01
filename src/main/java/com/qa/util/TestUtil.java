package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.testbase.Base;

public class TestUtil extends Base {
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICITWAIT=10;
	public static String getsheetpath="C:\\eclipse-programs\\Freecrmtest\\src\\main\\java\\com\\qa\\testdata\\freecrmtestdata.xlsx";
	
	static Workbook wb;
	static Sheet sh;
	public Object[][]getTestData(String sheetname){
		
		FileInputStream file=null;
		try {
			file=new FileInputStream(TestUtil.getsheetpath);
		} catch (FileNotFoundException e) {
			System.out.println("exception1");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		wb=WorkbookFactory.create(file);
		} catch (InvalidFormatException | IOException e) {
			System.out.println("exception2");

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sh=wb.getSheet(sheetname);
		sh.getLastRowNum();
		sh.getRow(0).getLastCellNum();
		Object[][]data=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		for(int i=0;i<sh.getLastRowNum();i++) {
			for(int k=0;k<sh.getRow(0).getLastCellNum();k++) {
				data[i][k]=sh.getRow(i+1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		
		return data;
		
	}
	
	
	
	public void switchtoframe(String name) {
		driver.switchTo().frame(name);
	}
	public void Switchtoalert(WebElement ele) {
		Actions act=new Actions(driver);
		  act.moveToElement(ele).build().perform();
	}

}
