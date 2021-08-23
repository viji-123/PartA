package pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import utility.BrowserUtility;

import java.io.File;

public class BaseClass {

    public WebDriver driver;

    @BeforeClass
    public void setup(){

        driver = BrowserUtility.startApp(driver, "https://www.google.ca");
    }


  /*  public void tearDown()
    {
        BrowserUtility.quitBrowser(driver);
    } */

    @AfterMethod
    public void tearDown(ITestResult result)
    {

        if(ITestResult.FAILURE==result.getStatus())
        {
            try
            {
                TakesScreenshot ts=(TakesScreenshot)driver;
                File source=ts.getScreenshotAs(OutputType.FILE);

                FileHandler.copy(source, new File("./Screenshots/"+result.getName()+".png"));
                System.out.println("Screenshot taken");

            }
            catch (Exception e)
            {
                System.out.println("Exception while taking screenshot "+e.getMessage());
            }
        }
// close application
        BrowserUtility.quitBrowser(driver);
    }

}

