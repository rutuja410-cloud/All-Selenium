import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowHandle extends BrowserLaunch
{
    @Test
    void multipleWindow()
    {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

        Set<String> multiHandle = driver.getWindowHandles();

        List<String> list = new ArrayList(multiHandle); // reference variable

        String parentId = list.get(0);
        String childId = list.get(1);

        //switch to child window
        driver.switchTo().window(childId);
        System.out.println(driver.getTitle());

        //Switch to parent window
        driver.switchTo().window(parentId);
        System.out.println(driver.getTitle());
    }
}
