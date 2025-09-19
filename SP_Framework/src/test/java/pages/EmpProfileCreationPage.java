package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EmpProfileCreationPage extends BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;

    private By company_site = By.cssSelector("input[name='companyWebsite']");
    private By size_field = By.cssSelector("div[name='companySize']");
    private By size_input = By.xpath("(//input[@class='ant-select-selection-search-input'])[1]");
    private By industry_field = By.cssSelector("div[name='industries']");
    private By industry_input = By.xpath("(//input[@class='ant-select-selection-search-input'])[2]");
    private By industry = By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='Software Development']");
    private By desc = By.cssSelector("textarea[name = 'companyDescription']");
    private By logo = By.cssSelector("input[type='file']");
    private By terms = By.cssSelector("input[name='termsAndConditionsAccepted']");
    private By next_btn = By.cssSelector(".ant-btn.ant-btn-primary.ant-btn-color-primary.ant-btn-variant-solid.ant-btn-lg");
    private By label = By.cssSelector(".ant-typography.mb-0");
    //private By tag1 = By.xpath("(//span[contains(@class,'ant-tag') and normalize-space()='Medium (100 - 499)'])[1]");
    private By tag2 = By.xpath("(//span[contains(@class,'ant-tag') and normalize-space()='Software Development'])");
    String image_path = "/Users/khizaranees/Desktop/Sensiply Automation/SP_Framework/SP_Framework/logo.png";
    private By thumbnail = By.xpath("//img[@alt='logo.png']");
    private By trial_box = By.xpath("(//span[contains(text(),'Try us out!')])");
    private By free_plan = By.cssSelector(".plan-voice-block.ant-flex.ant-flex-align-stretch.ant-flex-justify-center.ant-flex-vertical");
    private By skip = By.xpath("(//span[contains(text(),'Skip & Next')])[1]");
    private By GetStarted_btn = By.cssSelector("button[type='button']");
    private By dashboard = By.xpath("//span[normalize-space()='Dashboard']");


    public EmpProfileCreationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void company_info() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(label));
        String info_txt = driver.findElement(label).getText();
        Assert.assertEquals(info_txt, "Company Information");
        driver.findElement(company_site).sendKeys("www.abcd.com");
        driver.findElement(size_field).click();
        driver.findElement(size_input).sendKeys("Medium (100 - 499)");
        driver.findElement(size_input).sendKeys(Keys.ENTER);
        driver.findElement(industry_field).click();
        driver.findElement(industry_input).sendKeys("Software Development");
        wait.until(ExpectedConditions.visibilityOfElementLocated(industry));
        driver.findElement(industry).click();
        //String tag1_text = driver.findElement(tag1).getText();
        String tag2_text = driver.findElement(tag2).getText();
        //Assert.assertEquals(tag1_text, "Medium (100 - 499)");
        Assert.assertEquals(tag2_text, "Software Development");
        driver.findElement(desc).sendKeys("This is a Software Company.");
        driver.findElement(logo).sendKeys(image_path);
        wait.until(ExpectedConditions.visibilityOfElementLocated(thumbnail));
        driver.findElement(terms).click();
        driver.findElement(next_btn).click();
        Thread.sleep(2000);
        String payment_txt = driver.findElement(label).getText();
        Assert.assertEquals(payment_txt, "Payment");
    }

    public void payment() throws InterruptedException {
        driver.findElement(trial_box).click();
        driver.findElement(next_btn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(free_plan));
        driver.findElement(next_btn).click();
        Thread.sleep(2000);
        String Complete_txt = driver.findElement(label).getText();
        Assert.assertEquals(Complete_txt, "Integrate your existing platform");
    }

    public void third_platform() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(skip));
        driver.findElement(skip).click();
        Thread.sleep(2000);
        String Complete_txt = driver.findElement(label).getText();
        Assert.assertEquals(Complete_txt, "Profile Successfully Completed!");
    }

    public void find_talent() {
        driver.findElement(GetStarted_btn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
        String dashboard_txt = driver.findElement(dashboard).getText();
        Assert.assertEquals(dashboard_txt, "Dashboard");
    }
}
