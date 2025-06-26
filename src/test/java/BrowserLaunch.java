import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserLaunch
{
    WebDriver driver;

    @BeforeMethod
    public void launchBrowser()
    {
        driver = new ChromeDriver();
    }
    @Test
    public void setUp()
    {

    }
    @AfterMethod
    public void exit()
    {
       // driver.close();
    }
}
