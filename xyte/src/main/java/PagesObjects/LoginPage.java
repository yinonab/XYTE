package PagesObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(xpath = "(//div//input[@type='password'])[1]")
    WebElement pass;
    @FindBy(xpath = "(//div//input[@type='password'])[2]")
    WebElement passcon;
    @FindBy(xpath = "//*[contains(text(), 'Join')]")
    WebElement join;
    @FindBy(xpath = "//div[@class='mantine-9ghxiz mantine-Checkbox-inner']")
    WebElement checkbox;
    @FindBy(xpath = "//div//h1[@data-testid='home-title']")
    WebElement home_title;
    


    public void FillPass(String text)
    {
    	WaitElementDosplayed(pass);
    	filltext(pass,text);
    	WaitElementDosplayed(passcon);
    	filltext(passcon,text);
    }
    public void PressOnCheckBox()
    {
    	passcon.sendKeys(Keys.TAB);
    	WaitElementDosplayed(checkbox);
    	click(checkbox);
    }
    public void PressOnJoin()
    {
    	WaitElementDosplayed(join);
    	click(join);
    }
    public boolean TitleExist() {

    try {
        WaitElementDosplayed(home_title);
        return true;
    } catch (Exception e) {
        return false;
    }
}
}
    
    
    
    


