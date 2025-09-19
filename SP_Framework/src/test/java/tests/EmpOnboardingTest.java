package tests;

import base.BaseTest;
import org.example.ConfigUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.EmpProfileCreationPage;
import pages.LoginPage;
import utilities.UtilityClass;

import java.time.Duration;
import java.util.Properties;

public class EmpOnboardingTest extends BaseTest {

    @Test(description = "Employer Onboarding flow", priority = 1)
    public void EMPOnboardTest() throws InterruptedException {
        //SignupPage signPage = new SignupPage(driver,wait);
        //UtilityClass utl = new UtilityClass();
        LoginPage loginPage = new LoginPage(driver, wait);
        EmpProfileCreationPage eProf = new EmpProfileCreationPage(driver, wait);
        Properties prop = ConfigUtils.getProps("data");

        driver.get(prop.getProperty("LoginURL"));
        //String originalTabHandle = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.Welcome));

//        String randomMail = utl.generateRandomEmail("yopmail.com");
        System.out.println("random mail: "+ UtilityClass.random_EMP_Email);

//        String randomName = utl.generateRandomName();
//        System.out.println("random name: "+ randomName);
//
//        String randomComp = utl.generateRandomComp();
//        System.out.println("random company: "+ randomComp);
//
//        String randomTitle = utl.generateTitle();
//        System.out.println("random title: "+ randomTitle);

       // signPage.SignupEmp(randomName, randomComp, randomMail, prop.getProperty("Password"), randomTitle );

        //signPage.GetOTP(randomMail, originalTabHandle);

        loginPage.login(UtilityClass.random_EMP_Email, prop.getProperty("Password"));

        eProf.company_info();

        eProf.payment();

        eProf.third_platform();

        eProf.find_talent();

    }

    @Test(description = "Logout Employer", priority = 2)
    public void logout() {
        LoginPage loginPage = new LoginPage(driver,wait);
        loginPage.logout();
    }

}
