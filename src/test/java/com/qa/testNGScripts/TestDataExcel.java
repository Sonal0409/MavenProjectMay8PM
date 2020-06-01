package com.qa.testNGScripts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestDataExcel {
	
	 WebDriver driver;
		// pass the name of data provide method as parameter to thsi test method
		 
		 @BeforeClass

		 public void startbrowser()
		 {
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishal mittal\\Downloads\\chromedriver_win32 (10)\\chromedriver.exe");
		 	driver = new ChromeDriver();
		 	driver.manage().window().maximize();
		 	driver.get("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Selenium+%28software%29");
		 	
		 }
		 
		@Test(dataProvider="testdata")
		public  void wikipagedata(String name, String password, String retype, String email)
		{
			driver.findElement(By.id("wpName2")).clear();
			
			driver.findElement(By.id("wpName2")).sendKeys(name);
			
			
			driver.findElement(By.id("wpPassword2")).clear();
			driver.findElement(By.id("wpPassword2")).sendKeys(password);
			driver.findElement(By.id("wpRetype")).clear();
			driver.findElement(By.id("wpRetype")).sendKeys(retype);
			driver.findElement(By.id("wpEmail")).clear();
			driver.findElement(By.id("wpEmail")).sendKeys(email);
		}
	
	
	// DataProvider method: fetch data from excel sheet
	@DataProvider(name="testdata")
	public Object[][] readExcel() throws BiffException, IOException
	{
		//f is the object storing the location
		File f= new File("C:\\Users\\vishal mittal\\Desktop\\input.xls");
		
		Workbook w= Workbook.getWorkbook(f);
		
		Sheet s= w.getSheet("Sheet1");
		// number of rows in the sheet having data
		int rows= s.getRows();
		// number of columns in the sheet having data
		int col= s.getColumns();
		
		// create an array which is going to store all the values of rows and columns
		
		String inputdata[][] = new String[rows][col];
		
		// read the data
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<col;j++)
			{
				Cell c=s.getCell(j,i);
				
				// once you have the cell, fetch the contents
				inputdata[i][j]=c.getContents();
					
			}
			
		}
		
		return inputdata;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
