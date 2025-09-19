package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginPage extends BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;

    public By Welcome = By.xpath("//h1[normalize-space()='Welcome Back']");
    public By Login_label = By.cssSelector(".ant-btn.ant-btn-link.ant-btn-color-link.ant-btn-variant-link.login-btn");
    public By Sensiply_Label = By.className("apply-con-head");
    private By emailID = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//span[normalize-space()='Log In']");
    private By profilebtn= By.cssSelector(".ant-avatar.ant-avatar-circle.ant-avatar-icon.user-snap-image");
    private By logoutbtn= By.cssSelector(".ant-dropdown-menu-title-content");
    private By notice = By.cssSelector(".ant-notification-notice-message");
    private By title = By.cssSelector(".title");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void login(String email, String password) {
        driver.findElement(emailID).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void loginVerification() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        String titleTxt = driver.findElement(title).getText();
        Assert.assertEquals(titleTxt, "Hello, Jobseeker!");
    }

    public void logout() {
        if (!driver.findElements(notice).isEmpty()) {
            wait.until(ExpectedConditions.stalenessOf(driver.findElement(notice)));
        }
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(profilebtn)));
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(profilebtn)));
            driver.findElement(profilebtn).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(logoutbtn)));
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(logoutbtn)));
            driver.findElement(logoutbtn).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(Welcome));
            String url = driver.getCurrentUrl();
            Assert.assertTrue(url.contains("/login"));
    }
}
