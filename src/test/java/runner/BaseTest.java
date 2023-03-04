package runner;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import pages.BooksPage;
import pages.LoginPage;
import utils.ReportUtils;
import utils.TestUtils;

import java.lang.reflect.Method;
import java.time.Duration;

public abstract class BaseTest {
    public final String BASE_URL = TestUtils.getBaseUrl();
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @BeforeSuite
    protected void beforeSuite(ITestContext context) {

        Reporter.log(ReportUtils.getReportHeader(context), true);
    }

    @BeforeMethod
    protected void beforeMethod(Method method, ITestResult result) {
        driver = BaseUtils.createDriver();

        Reporter.log(ReportUtils.END_LINE, true);
        Reporter.log("TEST RUN", true);
        Reporter.log(ReportUtils.getClassNameTestName(method, result), true);
    }

    @AfterMethod
    protected void afterMethod(Method method, ITestResult result) {
        if (!result.isSuccess() && BaseUtils.isServerRun()) {
            BaseUtils.captureScreenFile(driver, method.getName(), this.getClass().getName());
        }

        Reporter.log(ReportUtils.getTestStatistics(method, result), true);

        driver.quit();
        webDriverWait = null;
    }
    protected WebDriver getDriver() {

        return driver;
    }

    protected WebDriverWait getWait() {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }

        return webDriverWait;
    }

    public BooksPage openBaseURL() {
        getDriver().get(BASE_URL);

        return new BooksPage(getDriver());
    }

    public BooksPage openBaseURL_ReturnBooksPage() {
        getDriver().get(BASE_URL);

        return new BooksPage(getDriver());
    }

    public LoginPage openBaseURL_ReturnLoginPage() {
        getDriver().get(BASE_URL);

        return new LoginPage(getDriver());
    }

}
