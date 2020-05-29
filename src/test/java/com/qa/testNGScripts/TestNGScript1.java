package com.qa.testNGScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGScript1 {
	
	public static WebDriver driver;

	@BeforeClass
	public void configuration()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishal mittal\\Downloads\\chromedriver_win32 (10)\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");		
	}
	
	@BeforeMethod
	public void timeout() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(5000);
	}
	
	@Test(priority='1')
	public void login()
	{
		
		driver.findElement(By.name("userName")).sendKeys("username");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("login")).click();
	}
	
@Test(priority='2')
	public void itenryCustomer()
	{
		driver.findElement(By.linkText("ITINERARY")).click();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	
	
	
	
	
	
	

}
