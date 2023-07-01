package com.qa.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.util.TestUtil;

public class dataprovidertesttest {
public static String getsheetpath="C:\\eclipse-programs\\Freecrmtest\\src\\main\\java\\com\\qa\\testdata\\freecrmtestdata.xlsx";
	
	static Workbook wb;
	static Sheet sh;
	
	
	public static Object[][]getTestData(String sheetname){
		
		FileInputStream file=null;
		try {
			file=new FileInputStream(TestUtil.getsheetpath);
		} catch (FileNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		wb=WorkbookFactory.create(file);
		} catch (InvalidFormatException | IOException e) {
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
		
		
		/*
		 * sheet = book.getSheet(sheetName); Object[][] data = new
		 * Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; //
		 * System.out.println(sheet.getLastRowNum() + "--------" + //
		 * sheet.getRow(0).getLastCellNum()); for (int i = 0; i < sheet.getLastRowNum();
		 * i++) { for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
		 * data[i][k] = sheet.getRow(i + 1).getCell(k).toString(); //
		 * System.out.println(data[i][k]); } }
		 */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return data;
		
	}

	public static void main(String[] args) {
		getTestData("contacts");

	}

}
