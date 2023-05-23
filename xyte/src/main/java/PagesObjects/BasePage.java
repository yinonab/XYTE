package PagesObjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BasePage {
    static WebDriver driver;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void click(WebElement el)
    {
        el.click();
    }
    public void filltext(WebElement sk, String text) {
        sk.sendKeys(text);
    }
    public void clear(WebElement el) {
        el.clear();
    }
    
    public void WaitElementDosplayed(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void SelectElement(WebElement element)
    {
        Actions action = new Actions(driver);
        action.click(element);
    }
    public void PressEnter(WebElement element)
    {
        element.sendKeys(Keys.RETURN);
    }
    public void WaitElementClicability(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void WaitElementNotClicability(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(element)));
    }
    public void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public String getText(WebElement el) {
        return el.getText();
    }
    public static void TakeScreenShot() throws IOException
	{
		/*
		Random num = new Random();
		int number = 35600;
		for (int counter = 58000; counter<=100000;counter++)
			number = num.nextInt(7000);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere

		try {
			FileUtils.copyFile(scrFile, new File("/Users/yinonwishi/Downloads/screenshoots/"+number+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 */
    	String folder_name = System.getProperty("user.dir")+"/allure-results";
    	System.out.println(folder_name);
		//String folder_name ="/Users/yinonwishi/Downloads/screenshoots/";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		SimpleDateFormat df=new SimpleDateFormat("dd-mm-yyyy__hh_mm_ssaa");
		new File(folder_name).mkdir();
		String file_name=df.format(new Date())+".png";
		FileUtils.copyFile(scrFile, new File(folder_name+ "/"+file_name));

	}
    


}
