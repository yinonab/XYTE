package PagesObjects;

import java.util.List;

import org.apache.tools.ant.types.selectors.SelectSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobsPage extends BasePage
{
    public JobsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div//button[contains(text(), 'Job Category')]")
    WebElement jobcaategory;
    @FindBy(xpath = "//div//label")
    List<WebElement> jobslist;
    @FindBy(xpath = "//div//button[@data-automation-id='viewAllJobsButton']")
    WebElement viewjobsbutton;
    @FindBy(xpath = "//input[@data-automation-id='keywordSearchInput']")
    WebElement input;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitbutton;
    @FindBy(xpath = "//a[@class='css-19uc56f']")
    List <WebElement> progamerslist;
    @FindBy(xpath = "//a[@class='css-19uc56f']")
    WebElement progamerlist;
    @FindBy(xpath = "//p[@data-automation-id='jobFoundText']")
    WebElement jobsfounded;
    @FindBy(xpath = "//a[@data-automation-id='adventureButton']")
    WebElement applay;
    @FindBy(xpath = "//h2[@class='css-124gh4t']")
    WebElement startyourapp;



    
    public void SelectJob(String text) {

        for (WebElement element : jobslist) {
            if (element.getText().contains("Engineering Services Group"))
            {
                WaitElementDosplayed(element);
                click(element);
            }
        }
        }
    
    public void ClickJobCaategoryButton()
    {
        WaitElementDosplayed(jobcaategory);
        click(jobcaategory);
    }
    public void ClickViewJoBsbutton()
    {
        WaitElementDosplayed(viewjobsbutton);
        click(viewjobsbutton);
    }
    
    public void SearchProgramManager(String text)
    {
    	WaitElementDosplayed(input);
    	click(input);
    	filltext(input,text);
    	click(submitbutton);
    }
    public void SelectTheLatJob() {
    	if (progamerlist.isDisplayed()){
    		WebElement lastJob = progamerslist.get(progamerslist.size()-1);
			WaitElementClicability(lastJob);
			lastJob.click();
			WaitElementClicability(applay);
			applay.click();
    }
    	else {
    		System.out.println("NO JOBS FOUNDED");
        }
        }
    public String StartYourApplicationDisplayed() {


        WaitElementDosplayed(startyourapp);
        return getText(startyourapp);
}
    public boolean JobsListExist() {

        try {
            WaitElementDosplayed(progamerlist);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
