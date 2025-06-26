package pageOmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomPageFactory
{
    WebDriver driver;
    //Constructor
    PomPageFactory(WebDriver d)
    {
        driver = d;
        //this method will create web element

        PageFactory.initElements(driver, this);
    }

    //identify the web elements
    //identify the username
    @FindBy(id="user-name") WebElement username;

    //identify Password
    @FindBy(id="password") WebElement password;

    //identify login button
    @FindBy(id="login-button") WebElement loginButton;

    //Create s repository to all Webelements

    public void enterUsername(String uname)
    {
        username.sendKeys(uname);
    }

    public void enterPassword(String pwd)
    {
        password.sendKeys(pwd);
    }

    public void clickButton()
    {
        loginButton.click();
    }


}
