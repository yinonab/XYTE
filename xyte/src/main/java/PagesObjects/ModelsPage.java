package PagesObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ModelsPage extends BasePage
{
    public ModelsPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(xpath = "//*[contains(text(), 'Models')]")
    WebElement modelsbutton;
    @FindBy(xpath = "//*[contains(text(), 'Add Model')]")
    WebElement addmodelsbutton;
    @FindBy(xpath = "(//div//input[@type='text'])[2]")
    WebElement model_name_field;
    @FindBy(xpath = "//button")
    List<WebElement> createmodelbutton;
    @FindBy(xpath = "//div//a[contains(text(), 'IphoneX')]")
    WebElement model;
    @FindBy(xpath = "//div//a[contains(text(), 'IphoneX')]")
    WebElement Error;
    


    public void ClickCreateModelButton(String text) {

        for (WebElement element : createmodelbutton) {
            if (element.getText().contains(text))
            {
                WaitElementDosplayed(element);
                click(element);
            }
        }

    }
    public void ClickMOdelsButton()
    {
    	WaitElementDosplayed(modelsbutton);
    	click(modelsbutton);
    }
    public void ClickAddMOdelsButton()
    {
    	WaitElementDosplayed(addmodelsbutton);
    	click(addmodelsbutton);
    }
    public void FillNameOfMoOdel(String text)
    {
    	WaitElementDosplayed(model_name_field);
    	filltext(model_name_field,text);
    }
    public boolean ModelCreated() {

    try {
        WaitElementDosplayed(model);
        return true;
    } catch (Exception e) {
        return false;
    }
}
    public boolean ModelCreateFailed() {

        try {
            WaitElementDosplayed(Error);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
    
    
    
    


