import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class NevigationCommand extends BrowserLaunch
{
    @Test
    void backForward() throws MalformedURLException {
       // driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

     /*   URL myUrl = new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.navigate().to(myUrl);*/

        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // url printing on your console ==> getCurrentUrl();

        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());

        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());

        driver.navigate().refresh();

        //driver.get(); ==> accept url in string format only
       // driver.navigate().to(); ==> accept url in the String & url class object format

    }
}
