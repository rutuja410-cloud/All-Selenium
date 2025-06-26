package ddf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class DataDrivenFramework
{
    WebDriver driver;
    @BeforeMethod
    void launchApp()
    {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    @Test
    void loginApp() throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream("Documents\\ExcelFile.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheet("MenuOHM");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");

        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        Thread.sleep(3000);

        List<WebElement> menu = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li/a/span"));

        for(int i=0; i<menu.size();i++)
        {
            XSSFRow rw = sh.createRow(i);
            XSSFCell res = rw.createCell(2);

            System.out.println(menu.get(i).getText());
            res.setCellValue(menu.get(i).getText());

        }
        FileOutputStream fos = new FileOutputStream("Documents\\ExcelFile.xlsx");
        wb.write(fos);

    }

    @AfterMethod
    void closeApp() {

    }

}
