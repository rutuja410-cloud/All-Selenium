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

public class DemoDriven
{
    WebDriver driver;

    @BeforeMethod
    public void launchPage()
    {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
    }

    @Test
    public void practiceDemo() throws IOException {
        //create an object of file class to open file
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
        for(int currentRow = 0; currentRow < rowCount; currentRow++)
        {
            //create inner for loop for cells
            for(int currentCell=0; currentCell<totalCell; currentCell++)
            {
                // print the cell data means username
               // sheet.getRow(currentRow).getCell(currentCell).toString();
                System.out.print(sheet.getRow(currentRow).getCell(currentCell).toString());
                System.out.print("\t");
                //getNumericCellValue ==> read the numeric value
                // getBooleanCellValue ==> read the boolean value

            }
            System.out.println("\n");
        }
           wb.close();

    }

    @AfterMethod
    public void close()
    {

    }
}
