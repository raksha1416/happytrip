
package com.skillassure.happytrip.tests; 

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.skillassure.happytrip.base.Baseclass;
import com.skillassure.happytrip.base.pages.AdminLogin;

import Resources.ListenerTest;

 
/**
 * @author Admin
 *
 */
@Listeners(ListenerTest.class)
public class Testcase_10 extends Baseclass
{
   
   
    static XSSFCell cell;
 

 
  
 @Test(dataProvider ="Login")
 public void ReadData(String userName, String Password) throws IOException
 {
	 AdminLogin admin = new AdminLogin(driver);
     admin.sendUsername(userName);
     admin.sendPassword(Password);
         cell.setCellType(Cell.CELL_TYPE_STRING);
         // importing expected data
         cell =mySheet.getRow(10).getCell(3);
         String expected=cell.getStringCellValue();
          
                 
        // click on signin
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.xpath("//*[@id='MainTabs']/li[5]/a")).click();
		String actual=driver.findElement(By.id("distance")).getAttribute("value");
		int actual1=Integer.parseInt(actual);
		Assert.assertEquals(actual1, expected);
		System.out.println("actual is\n"+actual1);
		System.out.println("expeted is\n"+expected);
		
		
		
	}
 @DataProvider(name="Login")

	public static Object[][] testData() throws IOException, InterruptedException {
	 File myFile = new File("./src/test/resources/excel/TestData.xlsx"); 
	 FileInputStream fis = new FileInputStream(myFile);
	 myWorkBook= new XSSFWorkbook (fis);
	 mySheet = myWorkBook.getSheetAt(0);
	 cell=mySheet.getRow(10).getCell(1);
  cell.setCellType(Cell.CELL_TYPE_STRING);
  Thread.sleep(2000);
  String username=cell.getStringCellValue();
  System.out.println(username);
  cell =mySheet.getRow(10).getCell(2);
  cell.setCellType(Cell.CELL_TYPE_STRING);
  String password=cell.getStringCellValue();
  System.out.println(password);
	return new Object[][] { {username,password}};

	}
	
	
	
	

}
