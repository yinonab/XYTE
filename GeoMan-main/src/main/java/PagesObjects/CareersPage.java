package PagesObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersPage extends BasePage
{
    public CareersPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='sc-bgqQcB kzsiFm']//a")
    List<WebElement> careers;
    @FindBy(xpath = "(//div[@class='sc-ewnqHT kdgYCr trapignore']//div['sc-ewnqHT sc-evNfHk iCIsOb ddBIMp'])[6]")
    WebElement company;
    @FindBy(xpath = "//div//button[@class='sc-dSLLkn jerDdF']")
    WebElement search;
    @FindBy(xpath = "//div//form//input[@type='text']")
    WebElement searchfield;
    @FindBy(xpath = "//div[@class='acsClassicInvite']//a[@class='acsCloseButton acsAbandonButton ']")
    WebElement closebutton;
    @FindBy(xpath = "//div[@class='sc-ewnqHT gRMzpX sc-jeCNp eLrKDD']//span[@class='sc-ewnqHT gKNfeO']")
    WebElement search_open_positions_button;


    public void SelectCarreersButton(String text) {

        for (WebElement element : careers) {
            if (element.getText().contains(text))
            {
                WaitElementDosplayed(element);
                click(element);
//            	WaitElementDosplayed(closebutton);
//            	click(closebutton);
            	

            }
        }

    }
    public void ActivateSearch()
    {
    	WaitElementDosplayed(search);
    	click(search);
    	WaitElementDosplayed(search);
        click(searchfield);
    }
    public void FillText(String text)
    {    
        WaitElementDosplayed(searchfield);
    	clear(searchfield);
    	filltext(searchfield,text);
    }
    
    public void ClickSearchPositionButton()
    {
    	WaitElementDosplayed(search);
    	click(search_open_positions_button);	
    }

    
    
    
    

}
