package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EmpJob extends BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;

    private By AddJobs = By.cssSelector("[name = 'Add Jobs']");
    private By label = By.xpath("//h5[normalize-space()='Post New Job']");
    private By JobTitle = By.id("jobPost_jobTitle");
    private By JobTags = By.id("jobPost_jobTags");
    private By FullTime = By.cssSelector("input[value='Full Time']");
    private By Tag1 = By.xpath("//span[contains(@class,'ant-tag') and normalize-space()='Software Engineering']");
    private By Tag2 = By.xpath("//span[contains(@class,'ant-tag') and normalize-space()='Software Development']");
    private By Location = By.id("jobPost_locationCountry");
    private By City = By.id("jobPost_locationCity");
    private By WorkType = By.cssSelector("input[value='Hybrid']");
    private By Benefit1 = By.xpath("//span[normalize-space()='Health Insurance(Medical, Dental, Vision)']");
    private By Benefit2 = By.xpath("//span[normalize-space()='Flexible Work Hours']");
    private By Benefit3 = By.xpath("//span[normalize-space()='Bonuses and Incentives']");
    private By Benefit4 = By.xpath("//span[normalize-space()='Remote Work Options']");
    private By Benefit5 = By.xpath("//span[normalize-space()='Life Insurance']");
    private By Input_Qualifications = By.xpath("//div[@data-placeholder='Please add the Job Qualifications']");
    private By Key_Qualifications = By.id("jobPost_keyQualifications");
    private By Qualifications1 = By.xpath("//span[contains(@class,'ant-tag') and normalize-space()='5 years of experience']");
    private By Qualifications2 = By.xpath("//span[contains(@class,'ant-tag') and normalize-space()='Software Testing/QA']");
    private By Qualifications3 = By.xpath("//span[contains(@class,'ant-tag') and normalize-space()='Software Development']");
    private By JobDescription = By.xpath("//div[@data-placeholder='Please add the Job Description']");
    private By Submit = By.cssSelector("button[type='submit'] span");
    private By label2 = By.xpath("//h5[contains(normalize-space(),'All Job Postings')]");
    private By Title = By.cssSelector(".job-position.mt-4.text-truncate");
    private By Dotted_icon = By.xpath("(//div[contains(@class, 'ant-space-gap-col-small ant-dropdown-trigger')])[2]");
    private By Edit = By.xpath("//span[normalize-space()='Edit Listing']");
    private By Delete =By.xpath("//span[normalize-space()='Delete Posting']");
    private By notice = By.cssSelector(".ant-notification-notice-message");


    public EmpJob(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void Post_job() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AddJobs));
        driver.findElement(AddJobs).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(label));
        String PostJob_Text = driver.findElement(label).getText();
        Assert.assertEquals(PostJob_Text, "Post New Job");
        driver.findElement(JobTitle).sendKeys("Test Job");
        driver.findElement(JobTags).click();
        driver.findElement(JobTags).sendKeys("Software Engineering");
        driver.findElement(JobTags).sendKeys(Keys.ENTER);
        driver.findElement(JobTags).sendKeys("Software Development");
        driver.findElement(JobTags).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Tag1));
        String tag1_text = driver.findElement(Tag1).getText();
        Assert.assertEquals(tag1_text, "Software Engineering");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Tag2));
        String tag2_text = driver.findElement(Tag2).getText();
        Assert.assertEquals(tag2_text, "Software Development");
        driver.findElement(FullTime).click();
        driver.findElement(Location).sendKeys("Sindh");
        driver.findElement(City).sendKeys("Karachi");
        driver.findElement(WorkType).click();
        driver.findElement(Benefit1).click();
        driver.findElement(Benefit2).click();
        driver.findElement(Benefit3).click();
        driver.findElement(Benefit4).click();
        driver.findElement(Input_Qualifications).sendKeys(" Software Engineer having 5 years of experience. ");
        driver.findElement(JobDescription).click();
        driver.findElement(Key_Qualifications).click();
        driver.findElement(Key_Qualifications).sendKeys("5 years ");
        driver.findElement(Key_Qualifications).sendKeys(Keys.ENTER);
        driver.findElement(Key_Qualifications).sendKeys("Software Testing");
        driver.findElement(Key_Qualifications).sendKeys(Keys.ENTER);
        driver.findElement(Key_Qualifications).sendKeys("Software Development");
        driver.findElement(Key_Qualifications).sendKeys(Keys.ENTER);
        driver.findElement(Input_Qualifications).click();
        String Qualification_text1 = driver.findElement(Qualifications1).getText();
        Assert.assertEquals(Qualification_text1, "5 years of experience");
        String Qualification_text2 = driver.findElement(Qualifications2).getText();
        Assert.assertEquals(Qualification_text2, "Software Testing/QA");
        String Qualification_text3 = driver.findElement(Qualifications3).getText();
        Assert.assertEquals(Qualification_text3, "Software Development");
        driver.findElement(JobDescription).sendKeys("Develop a web application. Then write and create test cases for that application.");
        driver.findElement(Submit).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(notice));
        String noticeTxt = driver.findElement(notice).getText();
        Assert.assertEquals(noticeTxt, "The job has been posted successfully");
        wait.until(ExpectedConditions.visibilityOfElementLocated(label2));
        String labelText = driver.findElement(label2).getText();
        Assert.assertTrue(labelText.contains("All Job Postings"));
        String JobTitle = driver.findElement(Title).getText();
        Assert.assertEquals(JobTitle, "Test Job");
    }

    public void Update_job() throws InterruptedException {
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(notice)));
        driver.findElement(Dotted_icon).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Edit));
        driver.findElement(Edit).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(label));
        String PostJob_Text = driver.findElement(label).getText();
        Assert.assertEquals(PostJob_Text, "Post New Job");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Benefit5));
        driver.findElement(Benefit5).click();
        driver.findElement(Submit).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(notice));
        String noticeTxt = driver.findElement(notice).getText();
        Assert.assertEquals(noticeTxt, "Job Updated Successfully");
    }

    public void Delete_job() {
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(notice)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(label2));
        String labelText = driver.findElement(label2).getText();
        Assert.assertTrue(labelText.contains("All Job Postings"));
        driver.findElement(Dotted_icon).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Delete));
        driver.findElement(Delete).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(notice));
        String noticeTxt = driver.findElement(notice).getText();
        Assert.assertEquals(noticeTxt, "Job Post has been Deleted.");
    }

}
