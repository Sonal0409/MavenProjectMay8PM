package com.qa.parallelTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MercuryLogin {
	
	public static WebDriver driver;
	
	@Parameters({"Username","Password"})
	@Test
	public void signup(String Username, String Password) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishal mittal\\Downloads\\chromedriver_win32 (10)\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// implicit wait(5) : the tool will wait for atleast 5 seconds for each element before 
		// throwing no such element found exception
		//Syntax: driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		
		driver.findElement(By.name("userName")).sendKeys(Username);
	
		driver.findElement(By.name("password")).sendKeys(Password);
		
		WebElement e= driver.findElement(By.name("login"));
		// explicit wait : time (10 sec) and condition(element visibility)
		
		
		WebDriverWait w= new WebDriverWait(driver, 10);
		
		  w.until(ExpectedConditions.visibilityOf(e));
		
			e.click();
		driver.close();
	}
	

}
