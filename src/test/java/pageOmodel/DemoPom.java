package pageOmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoPom
{
    WebDriver driver;

    //contructor
    DemoPom(WebDriver d)
    {
      driver=d;
    }

    // identity the webelement
    //Create a method of operation to be performed
    // Locate the element

    By userName = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");

    // repository with creating methods

    public void enterUsername(String uname)
    {
        driver.findElement(userName).sendKeys(uname);
    }

    public void enterPassword(String pwd)
    {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickButton()
    {
        driver.findElement(loginBtn).click();
    }

}
