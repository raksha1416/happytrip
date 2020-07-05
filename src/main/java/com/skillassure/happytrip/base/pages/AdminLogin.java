package com.skillassure.happytrip.base.pages;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.skillassure.happytrip.base.Baseclass;
public class AdminLogin extends Baseclass {





//Initiate the driver

public AdminLogin(WebDriver driver) {

Baseclass.driver = driver;

AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,30);

PageFactory.initElements(factory, this);

}

// Using FindBy for locating elements

@FindBy(how= How.ID, using = "username")

WebElement userName;

@FindBy(how = How.ID, using="password")

WebElement password;

@FindBy(how = How.ID, using="signInButton")

WebElement signIn;

public void sendUsername(String UserName)

{

userName.click();
userName.clear();
userName.sendKeys(UserName);


}

public void sendPassword(String Password)

{

password.click();
password.clear();
password.sendKeys(Password);



}

public void SignIN()

{

signIn.click();

}

}