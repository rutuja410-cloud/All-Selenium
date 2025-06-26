package ddf;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FetchData
{
    WebDriver driver;

    @BeforeMethod
    public void launchPage()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void practiceDemo() throws IOException, InterruptedException
    {
        File excel = new File("C:\\Demo Program\\ExcelFileTest.xlsx");

        //Excel--> workbook--> sheet--> row--> cell
        //for excel
        //create an object of fileInputStream to read from file
        FileInputStream objFile = new FileInputStream(excel);

        //create object of XSSFWorkbook to handle file
        //workbook
        XSSFWorkbook wb = new XSSFWorkbook(objFile);

        //create object of XSSFSheet to handle workbook
        //for sheet
        XSSFSheet sheet = wb.getSheetAt(0);

        // for row
        //get total row count
        int rowCount = sheet.getLastRowNum()+1;

        //for cell
        //get total cell count in row
        int totalCell = sheet.getRow(0).getLastCellNum();

        //create for outer loop for cell
        for(int currentRow = 1; currentRow <= rowCount; currentRow++)
        {
            driver.get("http://saucedemo.com/v1/");

            // String userName = sheet.getRow(currentRow).getCell(0).toString();
            driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(sheet.getRow(currentRow).getCell(0).toString());
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys(sheet.getRow(currentRow).getCell(1).toString());
            driver.findElement(By.xpath("//input[@id='login-button']")).click();
            Thread.sleep(3000);
            driver.quit();
            //getNumericCellValue ==> read the numeric value
            // getBooleanCellValue ==> read the boolean value

        }
        wb.close();
    }

    @AfterMethod
    public void close()
    {

    }


}
