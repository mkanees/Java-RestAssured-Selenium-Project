package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WelcomePage extends BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    private By GetStarted = By.xpath("(//span[normalize-space()=\"Let's Get Started\"])[1]");
    private By Welcome_label = By.xpath("//h1[normalize-space()=\"Welcome to Sensiply!\"]");
    private By Applicant_label = By.xpath("//h3[normalize-space()=\"Applicant Basic Information\"]");

    public WelcomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void Welcome() {
        driver.findElement(GetStarted).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Applicant_label));
        String Applicant_txt = driver.findElement(Applicant_label).getText();
        Assert.assertEquals(Applicant_txt, "Applicant Basic Information");
    }


    public void WelcomeVerification () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Welcome_label));
        String WelcomeTxt = driver.findElement(Welcome_label).getText();
        Assert.assertEquals(WelcomeTxt, "Welcome to Sensiply!");
    }

}
