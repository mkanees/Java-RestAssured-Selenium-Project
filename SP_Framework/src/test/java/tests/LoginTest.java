package tests;

import base.BaseTest;
import org.example.ConfigUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.util.Properties;

public class LoginTest extends BaseTest {

    @Test(description = "Login Scenario", priority = 1)
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver,wait);
        Properties prop = ConfigUtils.getProps("data");
        driver.get(prop.getProperty("URL"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.Sensiply_Label));

        driver.findElement(loginPage.Login_label).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.Welcome));
        loginPage.login(prop.getProperty("Email"), prop.getProperty("Password"));

        loginPage.loginVerification();
    }

    @Test(description = "Logout Scenario", priority = 2)
    public void logout() {
        LoginPage loginPage = new LoginPage(driver,wait);
        loginPage.logout();
    }

}
