package TestsObjects;

import PagesObjects.LoginPage;
import PagesObjects.ModelsPage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import junit.framework.Assert;

import org.testng.annotations.Test;

@SuppressWarnings("deprecation")
public class AddModels extends BaseTest
{
    @SuppressWarnings("deprecation")
	@Attachment
    @Story("LoginTest")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, groups = {"sanity-group"})
    public void MadeLogin() {
    	LoginPage com = new LoginPage(driver);
        com.FillPass("XyteAB1565!");
        com.PressOnCheckBox();
        com.PressOnJoin();
        Assert.assertTrue(com.TitleExist());
    }
        @SuppressWarnings("deprecation")
    	@Attachment
        @Story("CreateNewModel")
        @Severity(SeverityLevel.CRITICAL)
        @Test(priority = 2, groups = {"sanity-group"})
        public void NewModel() {
            ModelsPage mod = new ModelsPage(driver);
    		mod.ClickMOdelsButton();
    		mod.ClickAddMOdelsButton();
    		mod.FillNameOfMoOdel(this.configFileReader.getModelsName());
    		mod.ClickCreateModelButton("Create new model");
    		mod.ClickMOdelsButton();
            Assert.assertTrue(mod.ModelCreated());
            
        }
        @SuppressWarnings("deprecation")
    	@Attachment
        @Story("CreateSameModel")
        @Severity(SeverityLevel.CRITICAL)
        @Test(priority = 3, groups = {"sanity-group"})
        public void ExisitingModel() {
            ModelsPage mod = new ModelsPage(driver);
    		mod.ClickMOdelsButton();
    		mod.ClickAddMOdelsButton();
    		mod.FillNameOfMoOdel(this.configFileReader.getModelsName());
    		mod.ClickCreateModelButton("Create new model");
            Assert.assertTrue(mod.ModelCreateFailed());
            
        }

}
