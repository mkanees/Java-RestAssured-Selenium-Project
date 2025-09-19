package tests;

import base.BaseTest;
import org.example.ConfigUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.EmpJob;
import pages.LoginPage;

import java.time.Duration;
import java.util.Properties;

public class JobCRUDTest extends BaseTest {

    @Test(description = "Post a Job")
    public void PostJob(){
        LoginPage loginPage = new LoginPage(driver, wait);
        EmpJob job = new EmpJob(driver, wait);
        Properties prop = ConfigUtils.getProps("data");

        driver.get(prop.getProperty("LoginURL"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.Welcome));
        loginPage.login(prop.getProperty("Emp_Email"), prop.getProperty("Password"));

        job.Post_job();
    }

    @Test(description = "Update a Job", dependsOnMethods = "PostJob")
    public void UpdateJob() throws InterruptedException {
        EmpJob job = new EmpJob(driver, wait);
        job.Update_job();
    }

    @Test(description = "Delete a Job", dependsOnMethods = "UpdateJob")
    public void DeleteJob() {
        EmpJob job = new EmpJob(driver, wait);
        job.Delete_job();
    }

    @Test(description = "Logout Scenario", dependsOnMethods = "DeleteJob")
    public void logout() {
        LoginPage loginPage = new LoginPage(driver,wait);
        loginPage.logout();
    }


}
