package test;

import browserselector.BrowserSelector;
import com.aventstack.extentreports.Status;
import loadproperty.LoadProperty;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase extends ExtentReport {


    BrowserSelector browserSelector = new BrowserSelector(); //Multiple inheritance is not possible in java so we use object to get more than one class
    LoadProperty loadProperty = new LoadProperty();
    String browser = loadProperty.getProperty("browser"); //retrun it gives the value of browser which is "chrome"

    @BeforeMethod
    public void setUP() {
        browserSelector.selectBrowsers(browser);
    }


    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
            test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
            String screenshotPath = getScreenshot(driver, result.getName());
            test.addScreenCaptureFromPath(screenshotPath); // adding screenshot to report
            System.out.println(screenshotPath);
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
        }

        driver.quit();
    }

    public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotName + dateName + ".jpeg";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

}
