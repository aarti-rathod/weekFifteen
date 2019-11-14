package test;

import basepage.BasePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ExtentReport extends BasePage {


    public ExtentHtmlReporter extentHtmlReporter;
    public ExtentReports extentReports;
    public ExtentTest test;

    @BeforeTest
    public void setUpExtentReport() {

        //s-1
        extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\The-Report\\myReport.html");
        extentHtmlReporter.config().setDocumentTitle("X-Cart Report");
        extentHtmlReporter.config().setReportName("Sign Up Functionality");
        extentHtmlReporter.config().setTheme(Theme.STANDARD);

        //s-2
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        extentReports.setSystemInfo("os", "Windows");
        extentReports.setSystemInfo("browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Sachin");
        extentReports.setSystemInfo("Enviorment", "QA");


        //s-3
        //  test = extentReports.createTest("Test Name");

    }

    @AfterTest
    public void closeReport() {
        extentReports.flush();
    }


}
