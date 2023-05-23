package TestsObjects;

import PagesObjects.CareersPage;
import PagesObjects.CompanyPage;
import PagesObjects.JobsPage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import org.apache.tools.ant.taskdefs.Sleep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StartSearchJob extends BaseTest
{
    @Attachment
    @Story("OpenCareersPage")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, groups = {"sanity-group"})
    public void OpenCareersPage() {
        CompanyPage com = new CompanyPage(driver);
        com.SelectCompanyButton("Company");
        CareersPage carr = new CareersPage(driver);
        carr.SelectCarreersButton("Careers");
        carr.ClickSearchPositionButton();
        
    }

}
