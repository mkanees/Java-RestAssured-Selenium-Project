package tests;

import base.BaseTest;
import org.example.ConfigUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.*;
import utilities.UtilityClass;

import java.util.Properties;

public class JSe2e extends BaseTest {

    @Test(description = "Job Seeker Onboarding", priority = 1)
    public void JSe2eTest() throws InterruptedException {
       // SignupPage signPage = new SignupPage(driver,wait);
        //UtilityClass utl = new UtilityClass();
        LoginPage loginPage = new LoginPage(driver, wait);
        ProfileCreationPage Prof = new ProfileCreationPage(driver, wait);
        WelcomePage wlcm = new WelcomePage(driver, wait);
        Properties prop = ConfigUtils.getProps("data");

        driver.get(prop.getProperty("LoginURL"));

       // String originalTabHandle = driver.getWindowHandle();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.Welcome));

       // String randomMail = utl.generateRandomEmail("yopmail.com");
        System.out.println("random mail: "+ UtilityClass.random_JS_Email);

//        String randomPhone = utl.generateUniquePhoneNumber();
//        System.out.println("random phone: "+ randomPhone);
//
//        signPage.SignupJS(randomMail, randomPhone, prop.getProperty("Password"));
//
//        signPage.GetOTP(randomMail, originalTabHandle);

        loginPage.login(UtilityClass.random_JS_Email, prop.getProperty("Password"));
        //loginPage.login("test_423a621d@yopmail.com", prop.getProperty("Password"));

        wlcm.WelcomeVerification();

        wlcm.Welcome();

        Prof.basic_info();

        Prof.education();

        Prof.experience();

        Prof.sensipitch();

        Prof.time();

        Prof.self_identification();

        Prof.get_a_job();

    }

    @Test(description = "Job Seeker Save & Apply Job", priority = 2)
    public void JS_Job() {
        JSJob apply = new JSJob(driver, wait);

        apply.Job_Apply();

        apply.Save_Job();

        apply.RejectJob();

    }

    @Test(description = "Logout Job Seeker", priority = 3)
    public void logout() {
        LoginPage loginPage = new LoginPage(driver,wait);
        loginPage.logout();
    }


}
