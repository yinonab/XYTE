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
import org.testng.asserts.SoftAssert;

public class SelectJonTest extends BaseTestExternal
{
    @Attachment
    @Story("FilterJobs")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2, groups = {"sanity-group"})
    public void FilterJobs() {
    	JobsPage job = new JobsPage(driver);
        job.ClickJobCaategoryButton();
    	job.SelectJob("Engineering Services Group");
    	job.ClickViewJoBsbutton();
    	job.SearchProgramManager( "Program Manager");
    	SoftAssert softassert = new SoftAssert();
    	softassert.assertTrue(job.JobsListExist(),"job list not displayed");
    	job.SelectTheLatJob();
    	String expected = "Start Your Application";
        String actual = job.StartYourApplicationDisplayed();
        System.out.println(actual);
        Assert.assertEquals(actual, expected);
    	
    }


}
