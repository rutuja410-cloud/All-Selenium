package ddf;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CheckFetchData
{
    WebDriver driver;

    @BeforeMethod
    public void browserLaunch()
    {
        driver = new ChromeDriver();
       // driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
    }

    @Test
    public void demoCheck() throws IOException {
        // create an object of File class to open file
        File excel = new File("C:\\Demo Program\\ExcelFileTest.xlsx");

        //workbook==> sheet==> column==> row==> cell
        // for excel
        // create a object of FileInputStream(excel)
        FileInputStream objFile = new FileInputStream(excel);

        //create an object of XSSFWorkBook to handle the file
        XSSFWorkbook wb = new XSSFWorkbook(objFile);

        //for sheet
         XSSFSheet sheet = wb.getSheetAt(0);
        //XSSFSheet s = wb.getSheet("ReadData");

        //for row
        //get total row count in sheet
        int rowCount = sheet.getLastRowNum()+1;

        //for cell
        // get total cell count in rows
        int totalCell = sheet.getRow(0).getLastCellNum();

        // create outer for loop for row
        for(int currentRow=0; currentRow < rowCount; currentRow++)
        {
            //create a inner for loop for cells
            for(int currentCell=0; currentCell<totalCell; currentCell++)
            {
                //Print the cell data means username
                // method of printing /fetch username and password
                //sheet.getRow(currentRow).getCell(currentCell).toString();
                System.out.print(sheet.getRow(currentRow).getCell(currentCell).toString());

                System.out.print("\t");

                //numeric value ==> getNumericCellValue
                //Boolean ==> getBooleanCellValue

            }
            System.out.println("\n");
        }
        wb.close();
    }

    @AfterMethod
    public void close()
    {
        driver.quit();
    }
}
