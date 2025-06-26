package pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest
{
    WebDriver driver;

    @BeforeMethod
    void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
    }
    @Test
    void executeClass()
    {
        //creating object of Login page
        LoginPage loginPg = new LoginPage(driver);
        loginPg.enterUsername("standard_user");
        loginPg.enterPassword("secret_sauce");
        loginPg.clickButton();
    }
    @AfterMethod
    void closePage()
    {

    }
}
