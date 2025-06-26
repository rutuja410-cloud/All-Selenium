package ddf;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class ExecuteDDF extends BasicClass
{
    WebDriver driver;

   @Test
    void fetchData() throws IOException, InterruptedException {

       driver.get("https://www.saucedemo.com/v1/");

       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

       File excel = new File("C:\\Demo Program\\ExcelFileTest.xlsx");

       FileInputStream fs = new FileInputStream(excel);

       XSSFWorkbook wb = new XSSFWorkbook(fs);

       XSSFSheet sheet = wb.getSheetAt(0);

       int rowCount = sheet.getLastRowNum();
       int totalCell = sheet.getRow(0).getLastCellNum();

       for(int currentRow=1; currentRow<rowCount; currentRow++)
       {
           String username = sheet.getRow(currentRow).getCell(0).toString();
           String password = sheet.getRow(currentRow).getCell(1).toString();

          // driver.get("https://www.saucedemo.com/v1/");

               driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
               driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
               driver.findElement(By.xpath("//input[@id='login-button']")).click();
               Thread.sleep(2000);
           try {
               driver.findElement(By.xpath("//button[normalize-space()='Open Menu']")).click();
               driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
               Thread.sleep(2000);
           }
           catch (Exception e)
           {
               System.out.print("login may have failed for "+username);
           }
       }
      wb.close();

   }
}
