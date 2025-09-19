package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JSJob extends BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;

    private By MatchJob = By.xpath("//a[@href='/match-job-postings']");
    private By Label = By.xpath("//h5[normalize-space()='Job Description']");
    private By SaveJob = By.xpath("(//*[name()='circle'])[1]");
    private By ApplyJob = By.xpath("(//*[name()='circle'])[2]");
    private By RejectJob = By.xpath("(//*[name()='path'][@fill-rule='evenodd'])[21]");
    private By JobTitle = By.cssSelector(".ant-typography.bottom-spacing.pb-1.text-truncate");
    private By Success = By.xpath("(//h4[normalize-space()='Successfully Applied!'])[1]");
    private By JobTitle2 = By.xpath("(//div[contains(@class,'ant-typography mb-0')])[1]");
    private By Continue = By.xpath("(//span[normalize-space()='Continue to Matches'])[1]");
    private By Home = By.xpath("(//a[@href='/job-seeker/dashboard'])[1]");
    private By Dashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By SavedJobs = By.cssSelector("li[name='Saved Jobs']");
    private By Label2 = By.xpath("//h5[contains(normalize-space(),'Saved Jobs')]");
    private By Label3 = By.cssSelector(".fw-bold.mb-4");
    private By JobTtile3 = By.cssSelector(".job-position.mt-4.text-truncate");
    private By AppliedJobs = By.cssSelector("li[name='Applied Jobs']");
    private By Notice = By.cssSelector(".ant-notification-notice-message");


    public JSJob(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void Job_Apply() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MatchJob));
        driver.findElement(MatchJob).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Label));
        String JobText = driver.findElement(JobTitle).getText();
        driver.findElement(ApplyJob).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Success));
        Assert.assertEquals(JobText, driver.findElement(JobTitle2).getText());
        driver.findElement(Continue).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Label));
        driver.findElement(Home).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Dashboard));
        driver.findElement(AppliedJobs).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Label3));
        String JobText2 = wait.until(ExpectedConditions.visibilityOfElementLocated(JobTtile3)).getText();
        Assert.assertEquals(JobText, JobText2);
    }

    public void Save_Job(){
        driver.findElement(MatchJob).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Label));
        String JobText = driver.findElement(JobTitle).getText();
        driver.findElement(SaveJob).click();
        String NoticeMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(Notice)).getText();
        Assert.assertEquals(NoticeMsg, "Job Saved Successfully");
        wait.until(ExpectedConditions.elementToBeClickable(Home));
        driver.findElement(Home).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Dashboard));
        driver.findElement(SavedJobs).click();
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Label2));
        String JobText2 = wait.until(ExpectedConditions.visibilityOfElementLocated(JobTtile3)).getText();
        Assert.assertEquals(JobText, JobText2);
    }

    public void RejectJob() {
        driver.findElement(MatchJob).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Label));
        wait.until(ExpectedConditions.visibilityOfElementLocated(RejectJob));
        wait.until(ExpectedConditions.elementToBeClickable(RejectJob));
        driver.findElement(RejectJob).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Label));
    }

}
