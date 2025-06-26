package pageOmodel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExecutePom
{
    WebDriver driver;

    @BeforeMethod
    public void setUpApp()
    {
        WebDriverManager.chromedriver().setup(); //declaring webdrivermanager
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
    }

    @Test
    public void executeClass()
    {
        //creating object of DemoPom class
        DemoPom dp = new DemoPom(driver);
        dp.enterUsername("standard_user");
        dp.enterPassword("secret_sauce");
        dp.clickButton();
    }
    @AfterMethod
    public void closePage()
    {
      //  driver.quit();
    }
}
