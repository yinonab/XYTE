package TestsObjects;

import DataProvider.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    WebDriver driver;
    protected ConfigFileReader configFileReader;


    @BeforeClass(groups = {"sanity-group"})
    protected void setupCapability(ITestContext testContext) {
        configFileReader = new ConfigFileReader();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        testContext.setAttribute("WebDriver", this.driver);
        driver.get(configFileReader.getApplicationUrl());
        Dimension dimension = new Dimension(1600, 1200);
        driver.manage().window().setSize(dimension);

        // driver.manage().window().maximize();

    }

    @AfterClass(groups = {"sanity-group"})
    public void close() {
        driver.close();
    }
}
