package pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoPOM
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
    void login()
    {
        driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("standard_user");

        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();

    }

    @AfterMethod
    void close()
    {

    }
}
