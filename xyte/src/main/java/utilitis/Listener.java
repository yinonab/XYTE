package utilitis;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

public class Listener implements ITestListener, ISuiteListener, IInvokedMethodListener {

    public byte[] captureScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void onTestStart(ITestResult result) {

        System.out.println("New Test Started " + result.getName());

    }

    public void onTestSuccess(ITestResult result) {

        System.out.println("Test Successfully Finished  " + result.getName());

    }

    public void onTestFailure(ITestResult result) {

        System.out.println("Test Failed  " + result.getName());
        Object webDriverAttribute = result.getTestContext().getAttribute("WebDriver");
        if (webDriverAttribute instanceof WebDriver) {
            AllureAttachments.AllureAttachment.attachScreenshot((WebDriver) webDriverAttribute);
            if (webDriverAttribute instanceof WebDriver) {
                AllureAttachments.AllureAttachmentHtml.getPageSource((WebDriver) webDriverAttribute);
                if (webDriverAttribute instanceof WebDriver) {
                    AllureAttachments.attachConsoleLogs((WebDriver) webDriverAttribute);
                }
            }
            }


        }

        public void onTestSkipped (ITestResult result){

            System.out.println("Test Skipped  " + result.getName());

        }

        public void onTestFailedButWithinSuccessPercentage (ITestResult result){

            System.out.println("Test Failed but within success percentage  " + result.getName());

        }

        public void onStart (ITestContext context){


            System.out.println("This is onStart method" + context.getOutputDirectory());

        }

        public void onFinish (ITestContext context){

            System.out.println("This is onFinish method" + context.getPassedTests());
            System.out.println("This is onFinish method" + context.getFailedTests());
        }

    }
