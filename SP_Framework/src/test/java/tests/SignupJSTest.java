package tests;

import base.BaseTest;
import org.example.ConfigUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.SignupPage;
import utilities.UtilityClass;

import java.util.Properties;

public class SignupJSTest extends BaseTest {

    @Test(description = "Signup as a Jobseeker")
    public void signup_JSTest() throws InterruptedException {
        SignupPage signPage = new SignupPage(driver,wait);
        UtilityClass utl = new UtilityClass();
        Properties prop = ConfigUtils.getProps("data");

        driver.get(prop.getProperty("URL"));
        String originalTabHandle = driver.getWindowHandle();
        wait.until(ExpectedConditions.visibilityOfElementLocated(signPage.Sensiply_Label));

        String randomMail = utl.generateRandomEmail("yopmail.com");
        System.out.println("random mail: "+ randomMail);
        UtilityClass.random_JS_Email = randomMail;

        String randomPhone = utl.generateUniquePhoneNumber();
        System.out.println("random phone: "+ randomPhone);

        signPage.SignupJS(randomMail, randomPhone, prop.getProperty("Password"));

        signPage.GetOTP(randomMail, originalTabHandle);
    }
}
