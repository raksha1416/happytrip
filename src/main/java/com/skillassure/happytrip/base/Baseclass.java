package com.skillassure.happytrip.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Baseclass {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static File    myfile;
	public static XSSFWorkbook myWorkBook;
	 public static XSSFSheet mySheet;
	@BeforeMethod
	 public void TestSetup() throws IOException
	 {
	     // Set the path of the Chrome driver.
	     System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver.exe");
	     driver =new ChromeDriver();
	      
	     // Enter url.
	     driver.get("http://43.254.161.195:8085/happytripcrclean1/");
	     driver.navigate().to("http://43.254.161.195:8085/happytripcrclean1/loginAdmin.html;jsessionid=6DEE1F6CEC383E1D72AD8A7EC0473A4B");
	     driver.manage().window().maximize();
	      
	     wait = new WebDriverWait(driver,30);
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     
	    
	 }
	
	@AfterMethod
	public static void teardown(){
		driver.close();
	}
	

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}

	public void onStart(ITestContext iTestContext) {
		// TODO Auto-generated method stub
		
	}


}
