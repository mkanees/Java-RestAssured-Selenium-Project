package tests;

import base.BaseTest;
import org.example.ConfigUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.SignupPage;
import utilities.UtilityClass;

import java.util.Properties;

public class SignupEmpTest extends BaseTest {

    @Test(description = "Signup as an Employer")
    public void signup_EmpTest() throws InterruptedException {

        SignupPage signPage = new SignupPage(driver,wait);
        UtilityClass utl = new UtilityClass();
        Properties prop = ConfigUtils.getProps("data");

        driver.get(prop.getProperty("URL"));
        String originalTabHandle = driver.getWindowHandle();
        wait.until(ExpectedConditions.visibilityOfElementLocated(signPage.Sensiply_Label));

        String randomMail = utl.generateRandomEmail("yopmail.com");
        System.out.println("random mail: "+ randomMail);
        UtilityClass.random_EMP_Email = randomMail;

        String randomName = utl.generateRandomName();
        System.out.println("random name: "+ randomName);

        String randomComp = utl.generateRandomComp();
        System.out.println("random company: "+ randomComp);

        String randomTitle = utl.generateTitle();
        System.out.println("random title: "+ randomTitle);

        signPage.SignupEmp(randomName, randomComp, randomMail, prop.getProperty("Password"), randomTitle );

        signPage.GetOTP(randomMail, originalTabHandle);
    }
}
