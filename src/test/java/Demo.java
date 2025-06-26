import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo {
    WebDriver driver;

    @BeforeMethod
   public void setup()
    {
         driver = new ChromeDriver();
         driver.get("https://www.saucedemo.com/v1/");

    }
    @Test
    public void login()
    {
        driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

        driver.findElement(By.xpath("//button[text()=\"Open Menu\"]")).click();
        driver.findElement(By.xpath("//a[@id=\"logout_sidebar_link\"]")).click();

    }

    @AfterMethod
    public void exit()
    {
        driver.quit();
    }
}

