package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUpload
{
    WebDriver driver;

    @BeforeMethod
    void lanch()
    {
        driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com/upload");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    @Test
     void uploadDemo() throws InterruptedException {

        WebElement element = driver.findElement(By.xpath("//input[@id='fileInput']"));
        element.sendKeys("C:\\Users\\Admin\\Downloads\\SeleniumAutomation_Script.pdf");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }

    @AfterMethod
    void close()
    {

    }
}
