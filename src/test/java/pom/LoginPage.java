package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
    WebDriver driver;

    LoginPage(WebDriver d)
    {
        driver = d;
    }
    //identify web element
    //create methods of operation to be performed
    //locate element
    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");

    public void enterUsername(String uname)
    {
        driver.findElement(username).sendKeys(uname);
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
