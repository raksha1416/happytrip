package com.skillassure.happytrip.tests;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.skillassure.happytrip.base.Baseclass;
import com.skillassure.happytrip.base.pages.AdminLogin;
import com.skillassure.happytrip.utils.Extent_Report;

import Resources.ListenerTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Listeners(ListenerTest.class)
public class Testcase1 extends Baseclass
{
	
  
    
    static XSSFCell cell;
    ExtentReports extent;
    ExtentTest logger;
    
    
 @Test(dataProvider ="Login")
 
 public void ReadData(String userName, String Password) throws IOException
 {
	 
	    
	
	 Logger log= LogManager.getLogger(Testcase1.class.getName());
	    TakesScreenshot scrShot =((TakesScreenshot)driver);
	 	// Import data for username
        
         AdminLogin admin = new AdminLogin(driver);
         admin.sendUsername(userName);
         admin.sendPassword(Password);
                  
        
     	// Import the 3rd field
         
         cell =mySheet.getRow(1).getCell(3);
 		String expected=cell.getStringCellValue();
                 
        // click on signin
 		admin.SignIN();
		String actual=driver.findElement(By.xpath("//*[@id='global']/li[1]")).getText();
		
		AssertJUnit.assertEquals(actual, expected);
		System.out.println(expected);
		System.out.println(actual);
		// log4j2 loging
		if(actual.equals(expected))
		{
		
		log.debug("Condition Successfull");
		
		
		
		}
		

		else
		{
			log.error("Condition Failed");
			
		}
		
		
 }
 
 
 



@DataProvider(name="Login")

	public static Object[][] testData() throws IOException, InterruptedException {
	 File myFile = new File("./src/test/resources/excel/TestData.xlsx"); 
	 FileInputStream fis = new FileInputStream(myFile);
	 myWorkBook= new XSSFWorkbook (fis);
	 mySheet = myWorkBook.getSheetAt(0);
	 cell=mySheet.getRow(1).getCell(1);
     cell.setCellType(Cell.CELL_TYPE_STRING);
     Thread.sleep(2000);
     String username=cell.getStringCellValue();
     System.out.println(username);
     cell =mySheet.getRow(1).getCell(2);
     cell.setCellType(Cell.CELL_TYPE_STRING);
     String password=cell.getStringCellValue();
     System.out.println(password);
	return new Object[][] { {username,password}};

	}
}
	
	


