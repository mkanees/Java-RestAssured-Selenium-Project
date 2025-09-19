package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupPage extends BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;

    private By CreateAccountbtn = By.xpath("//span[normalize-space()='Create Account']");
    private By JSlabel = By.xpath("//button[normalize-space()='Job Seeker']");
    private By Emplabel = By.xpath("//button[normalize-space()='Employer']");
    private By JobSeekerbtn = By.xpath("(//button[@type='button'])[3]");
    private By Empbtn = By.xpath("(//button[@type='button'])[4]");
    private By emailID = By.id("email");
    private By Phoneno = By.className("react-international-phone-input");
    public By Sensiply_Label = By.className("apply-con-head");
    private By passwordField = By.id("password");
    private By submit_btn = By.cssSelector("button[type='submit'] span");
    private By OTP_Input = By.xpath("//input[@aria-label='OTP Input 1']");
    private By emailtab1 = By.xpath("(//button[@class='lm'])[1]");
    private By emailtab2 = By.xpath("(//button[@class='lm'])[2]");
    private By OTP_text = By.cssSelector("p:nth-child(3)");
    private By WelcomeBack = By.xpath("//h1[normalize-space()='Welcome Back']");
    private By Name = By.id("name");
    private By CompName = By.id("companyName");
    private By WorkTitle = By.id("workTitle");

    public SignupPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void SignupJS(String email, String phone, String password) {
        driver.findElement(JobSeekerbtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(JSlabel));
        String JStext = driver.findElement(JSlabel).getText();
        Assert.assertEquals(JStext, "Job Seeker");
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(CreateAccountbtn));

        driver.findElement(CreateAccountbtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(JSlabel));
        Assert.assertEquals(JStext, "Job Seeker");
        driver.findElement(emailID).sendKeys(email);
        driver.findElement(Phoneno).sendKeys(phone);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submit_btn).click();
    }

    public void SignupEmp(String name, String comp, String email, String password, String title) {
        driver.findElement(Empbtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Emplabel));
        String Emptext = driver.findElement(Emplabel).getText();
        Assert.assertEquals(Emptext, "Employer");
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(CreateAccountbtn));

        driver.findElement(CreateAccountbtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(JSlabel));
        driver.findElement(Emplabel).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Name));
        Assert.assertEquals(Emptext, "Employer");
        driver.findElement(Name).sendKeys(name);
        driver.findElement(CompName).sendKeys(comp);
        driver.findElement(emailID).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(WorkTitle).sendKeys(title);
        driver.findElement(submit_btn).click();
    }

    public void GetOTP(String email, String OgTab) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(OTP_Input));
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://yopmail.com/en/?login=" + email.split("@")[0]);
        Thread.sleep(60000);
        driver.navigate().refresh();
        driver.switchTo().frame("ifinbox");
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailtab1));
        driver.findElement(emailtab1).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("ifmail");
        String otpText1 = driver.findElement(OTP_text).getText();
        System.out.println("OTP text 1: "+ otpText1);


        if (otpText1.matches("\\d{5}")) {
            System.out.println("5 digit OTP found!");
            Pattern otpPattern = Pattern.compile("(\\d{4,6})"); // Adjust for 4–6 digit codes
            Matcher matcher = otpPattern.matcher(otpText1);

            if (matcher.find()) {
                String otpCode = matcher.group(1);
                System.out.println("OTP: " + otpCode);
                driver.switchTo().defaultContent();
                driver.switchTo().window(OgTab);
                wait.until(ExpectedConditions.visibilityOfElementLocated(OTP_Input));
                driver.findElement(OTP_Input).sendKeys(otpCode);
                wait.until(ExpectedConditions.elementToBeClickable(submit_btn));
                driver.findElement(submit_btn).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(WelcomeBack));
                String WelcomeText = driver.findElement(WelcomeBack).getText();
                Assert.assertEquals(WelcomeText, "Welcome Back");
            }
        }

        else {
            System.out.println("No OTP found, checking 2nd email");
            driver.switchTo().defaultContent();
            driver.switchTo().frame("ifinbox");
            wait.until(ExpectedConditions.visibilityOfElementLocated(emailtab2));
            driver.findElement(emailtab2).click();
            driver.switchTo().defaultContent();
            driver.switchTo().frame("ifmail");
            String otpText2 = driver.findElement(OTP_text).getText();
            System.out.println("OTP text 2: "+ otpText2);

            Pattern otpPattern = Pattern.compile("(\\d{4,6})"); // Adjust for 4–6 digit codes
            Matcher matcher = otpPattern.matcher(otpText2);

            if (matcher.find()) {
                String otpCode = matcher.group(1);
                System.out.println("OTP: " + otpCode);
                driver.switchTo().defaultContent();
                driver.switchTo().window(OgTab);
                wait.until(ExpectedConditions.visibilityOfElementLocated(OTP_Input));
                driver.findElement(OTP_Input).sendKeys(otpCode);
                wait.until(ExpectedConditions.elementToBeClickable(submit_btn));
                driver.findElement(submit_btn).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(WelcomeBack));
                String WelcomeText = driver.findElement(WelcomeBack).getText();
                Assert.assertEquals(WelcomeText, "Welcome Back");
            }
        }
    }

}
