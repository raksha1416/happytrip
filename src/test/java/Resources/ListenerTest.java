package Resources;		

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;		
import org.testng.ITestListener;		
import org.testng.ITestResult;

import com.google.common.io.Files;
import com.skillassure.happytrip.base.Baseclass;
import com.skillassure.happytrip.utils.Email;
import com.skillassure.happytrip.utils.Email;		

public class ListenerTest extends Baseclass implements ITestListener						
{		
	WebDriver driver;

	String filePath = "./src/test/resources/screenshorts/";

	Baseclass base= new Baseclass();
 	
    public void onFinish(ITestContext Result) 					
    {		
                		
    }		

 	
    public void onStart(ITestContext Result)					
    {		
            		
    }		

  		
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
    {		
    		
    }		

    // When Test case get failed, this method is called.		
  
    public void onTestFailure(ITestResult Result) 					
    {		
    System.out.println("The name of the testcase failed is :"+Result.getName());
    String methodName=Result.getName().toString();

    driver = base.getDriver();

    takeScreenShot(methodName, driver);
    try {
		Email.fail();
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    }
    
    private void takeScreenShot(String methodName, WebDriver driver) {

    // TODO Auto-generated method stub

    System.out.println("ScreenShot function called");

    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

    System.out.println("Screenshot taken");

    //The below method will save the screen shot in d drive with test method name

    try {

    Files.copy(scrFile, new File(filePath+methodName+".png"));

    System.out.println("***Placed screen shot in "+filePath+" ***");

    } catch (IOException e) {

    e.printStackTrace();

    }

    }
        

    // When Test case get Skipped, this method is called.		
  		
    public void onTestSkipped(ITestResult Result)					
    {		
    System.out.println("The name of the testcase Skipped is :"+Result.getName());					
    }		

    // When Test case get Started, this method is called.		
	
    public void onTestStart(ITestResult Result)					
    {		
    System.out.println(Result.getName()+" test case started");					
    }		

    // When Test case get passed, this method is called.		
 	
    public void onTestSuccess(ITestResult Result)					
    {		
    System.out.println("The name of the testcase passed is :"+Result.getName());					
    }		

}