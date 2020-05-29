package com.qa.testNGScripts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataDrivenTest {
	

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
	
	
	// DataProvider Method
	// this method is responsible to read the data from excel sheet and provide the data to Test method 
	
	// this DataProvider method is going to return an Object[][] type of data
	
	
	@DataProvider(name="testdata")
	public Object[][] readExcel() throws BiffException, IOException
	{
		// go to the location of your file
		
		File f= new File("C:\\Users\\vishal mittal\\Desktop\\input.xls");
		
		// go fetch the workbook from the above location
		
		Workbook w= Workbook.getWorkbook(f);
		
		// go to sheet which has my testdata
		
		Sheet s= w.getSheet("Sheet1");
		
		// fetch the total number of rows which have data from the excel sheet
		
		int rows=s.getRows();
		
		// fetch the total number of columns which have data from the excel sheet
		
		int col= s.getColumns();
		
		// In order to capture the values from each row and column create an array
		
		String inputData [][]= new String [rows][col];
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<col;j++)
			{
				Cell c=s.getCell(j,i);
				inputData[i][j]=c.getContents();
			}
			
		}
		return inputData;
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
