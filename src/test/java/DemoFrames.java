import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DemoFrames extends BrowserLaunch
{
    @Test
    public void Frame1()
    {
        //frame1
        driver.get("https://ui.vision/demo/webtest/frames/");
        WebElement fm1 = driver.findElement(By.xpath("//frame[@src=\"frame_1.html\"]"));
        driver.switchTo().frame(fm1);
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Selenium");

        driver.switchTo().defaultContent();

        //frame2
        WebElement fm2 = driver.findElement(By.xpath("//frame[@src=\"frame_2.html\"]"));
        driver.switchTo().frame(fm2);
        driver.findElement(By.xpath("//input[@name=\"mytext2\"]")).sendKeys("Welcome 2nd frame");

        driver.switchTo().defaultContent();
        //frame3
        WebElement fm3 = driver.findElement(By.xpath("//frame[@src=\"frame_3.html\"]"));
        driver.switchTo().frame(fm3);
        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Thank you..!");

        //inner iframe -part of 3rd iframe
        driver.switchTo().frame(0); //switching to frame using index

        WebElement redioButton = driver.findElement(By.xpath("//span[text()=\"I am a human\"]"));

        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",redioButton);
        System.out.println(redioButton.getText());





    }
}
