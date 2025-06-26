import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleAlert extends BrowserLaunch
{
   /* WebDriver driver;

    @BeforeMethod
    void linkDemo()
    {
        driver = new ChromeDriver();
       // driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }*/

    @Test
    void demoSimple()
    {
      /*  driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
       // driver.switchTo().alert().accept(); ==> close alert with ok button
        Alert at = driver.switchTo().alert();
        System.out.println(at.getText());
        at.accept(); */
    }

    @Test
    void demoConfirmation()
    {
        /*confirmation alert with ok and cancel button
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();

        //driver.switchTo().alert().accept(); close alert using ok button
       // driver.switchTo().alert().dismiss(); // close alert using cancel

        Alert ca = driver.switchTo().alert();
       // System.out.println(ca.getText());
        ca.dismiss();
        ca.getText();*/
    }

    @Test
    void promptAlert()
    {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
       // driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert pa = driver.switchTo().alert();
        pa.sendKeys("Welcome");
        pa.accept();
       // pa.dismiss();
    }

  /*  @AfterMethod
    void exit()
    {

    }*/

}
