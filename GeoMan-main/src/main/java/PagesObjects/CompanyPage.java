package PagesObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CompanyPage extends BasePage
{
    public CompanyPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='sc-ewnqHT caXeNT sc-esbhDv cmhjd']//button//div")
    List<WebElement> header;

    
    public void SelectCompanyButton(String text) {

        for (WebElement element : header) {
            if (element.getText().contains(text))
            {
                WaitElementDosplayed(element);
                click(element);
            }
        }
    }
        
}
