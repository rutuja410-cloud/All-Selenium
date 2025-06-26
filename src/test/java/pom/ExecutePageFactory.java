package pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExecutePageFactory
{
    WebDriver driver;

    @BeforeMethod
    void setUpLaunch()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
    }
    @Test
    void executePageClass()
    {
        //creating object of Login page
        DemoPageFactory pgFactory = new DemoPageFactory(driver);
        pgFactory.enterUsername("standard_user");
        pgFactory.enterPassword("secret_sauce");
        pgFactory.clickButton();
    }

    @AfterMethod
    void exitPage()
    {

    }
}
