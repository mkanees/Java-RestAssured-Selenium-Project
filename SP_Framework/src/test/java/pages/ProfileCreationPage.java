package pages;

import base.BaseTest;
import io.restassured.response.Response;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;

public class ProfileCreationPage extends BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;

    private By name = By.cssSelector("input[name='name']");
    private By dob = By.cssSelector("input[name='dateOfBirth']");
    private By address = By.cssSelector(".ant-input.ant-input-outlined.ant-select-selection-search-input");
    private By relocate = By.cssSelector("input[name='willingToRelocate']");
    private By industry_input = By.id("rc_select_3");
    private By industry = By.cssSelector(".ant-select-selection-overflow-item.ant-select-selection-overflow-item-suffix");
    private By option1 = By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='Software Development']");
    private By option2 = By.xpath("//div[contains(text(),'Software as a Service (SaaS)')]");
    private By option3 = By.xpath("//div[contains(text(),'Computer Software')]");
    private By tag1 = By.xpath("//span[contains(@class,'ant-tag') and normalize-space()='Software Development']");
    private By tag2 = By.xpath("//span[contains(@class,'ant-tag') and normalize-space()='Software as a Service (SaaS)']");
    private By tag3 = By.xpath("//span[contains(@class,'ant-tag') and normalize-space()='Computer Software']");
    private By next_btn = By.xpath("//span[normalize-space()='Next']");
    private By label = By.cssSelector(".ant-typography.mb-0");
    private By university_field = By.cssSelector(".ant-select.ant-select-outlined.ant-select-auto-complete.ant-select-single.ant-select-allow-clear.ant-select-customize-input.ant-select-show-search");
    private By university_input = By.cssSelector(".ant-input.ant-input-outlined.ant-select-selection-search-input");
    private By major = By.cssSelector("input[name='education.[0].major']");
    private By gpa = By.cssSelector("input[name='education.[0].cgpa']");
    private By start_date = By.cssSelector("input[name='education.[0].startDate']");
    private By end_date = By.cssSelector("input[name='education.[0].endDate']");
    private By EC_field = By.cssSelector(".ant-select.ant-select-outlined.ant-select-multiple.ant-select-show-arrow.ant-select-show-search");
    private By EC_input = By.xpath("(//input[@class='ant-select-selection-search-input'])[1]");
    private By activity = By.xpath("//div[contains(text(),'Animation')]");
    private By degree = By.xpath("(//input[@class='ant-select-selection-search-input'])[2]");
    private By degree_type = By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='Undergraduate Degrees/Bachelor of Science (BS)']");
    private By act_tag = By.xpath("//span[contains(@class,'ant-tag') and normalize-space()='Animation']");
   // private By deg_tag = By.xpath("//span[contains(@class,'ant-tag') and normalize-space()='Undergraduate Degrees/Bachelor of Science (BS)']");
    private By comp_name = By.cssSelector("input[name='workExperience.[0].companyName']");
    private By position = By.cssSelector("input[name='workExperience.[0].position']");
    private By start_date2 = By.cssSelector("input[name='workExperience.[0].startDate']");
    private By current_work = By.cssSelector("input[name='workExperience.[0].currentlyWorkingHere']");
    private By Sensipitch_label = By.cssSelector(".ant-typography.mb-0.text-sensi.text-primary");
    private By time1 = By.xpath("(//div[@class='cell bg-white'])[6]");
    private By time2 = By.xpath("(//div[@class='cell bg-white'])[20]");
    private By time3 = By.xpath("(//div[@class='cell bg-white'])[34]");
    private By time4 = By.xpath("(//div[@class='cell bg-white'])[48]");
    private By time5 = By.xpath("(//div[@class='cell bg-white'])[62]");
    private By protected_vet = By.xpath("(//div[@class='ant-select-selector'])[1]");
    private By disablity = By.xpath("(//div[@class='ant-select-selector'])[2]");
    private By ethinicity = By.xpath("(//div[@class='ant-select-selector'])[3]");
    private By sponsorship = By.xpath("(//div[@class='ant-select-selector'])[4]");
    private By term_check = By.cssSelector("input[name='termsAndConditionsAccepted']");
    private By vet_input = By.xpath("(//input[@class='ant-select-selection-search-input'])[1]");
    private By disablity_input = By.xpath("(//input[@class='ant-select-selection-search-input'])[2]");
    private By ethinicity_input= By.xpath("(//input[@class='ant-select-selection-search-input'])[3]");
    private By sponsorship_input = By.xpath("(//input[@class='ant-select-selection-search-input'])[4]");
    private By GetStarted_btn = By.cssSelector("button[type='button']");
    private By dashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public File videoFile = new File("/Users/khizaranees/Desktop/Sensiply Automation/SP_Framework/SP_Framework/demo_video.mp4");

    public ProfileCreationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void basic_info() throws InterruptedException {
        driver.findElement(name).sendKeys("Test_User");
        driver.findElement(dob).sendKeys("2001-12-11");
        driver.findElement(address).sendKeys("Karachi, Pakistan");
        driver.findElement(relocate).click();
        wait.until(ExpectedConditions.elementToBeClickable(industry));
        driver.findElement(industry).click();
        driver.findElement(industry_input).sendKeys("Software");
        wait.until(ExpectedConditions.visibilityOfElementLocated(option1));
        driver.findElement(option1).click();
        driver.findElement(industry_input).sendKeys("Software");
        wait.until(ExpectedConditions.visibilityOfElementLocated(option2));
        driver.findElement(option2).click();
        driver.findElement(industry_input).sendKeys("Software");
        wait.until(ExpectedConditions.visibilityOfElementLocated(option3));
        driver.findElement(option3).click();
        String tag1_text = driver.findElement(tag1).getText();
        String tag2_text = driver.findElement(tag2).getText();
        String tag3_text = driver.findElement(tag3).getText();
        Assert.assertEquals(tag1_text, "Software Development");
        Assert.assertEquals(tag2_text, "Software as a Service (SaaS)");
        Assert.assertEquals(tag3_text, "Computer Software");
        driver.findElement(next_btn).click();
        Thread.sleep(2000);
        String Edu_txt = driver.findElement(label).getText();
        Assert.assertEquals(Edu_txt, "Education");
    }

    public void education() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(university_field));
        driver.findElement(university_field).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(university_input));
        driver.findElement(university_input).sendKeys("Chadron State College ");
        wait.until(ExpectedConditions.elementToBeClickable(major));
        driver.findElement(major).sendKeys("Computer Science");
        wait.until(ExpectedConditions.elementToBeClickable(gpa));
        driver.findElement(gpa).sendKeys("3.5");
        wait.until(ExpectedConditions.elementToBeClickable(start_date));
        driver.findElement(start_date).sendKeys("2000-06-30");
        wait.until(ExpectedConditions.elementToBeClickable(end_date));
        driver.findElement(end_date).sendKeys("2004-10-30");
        Thread.sleep(2000);
        driver.findElement(EC_field).click();
        driver.findElement(EC_input).sendKeys("Animation");
        driver.findElement(activity).click();
        driver.findElement(degree).click();
        driver.findElement(degree).sendKeys("Undergraduate Degrees/Bachelor of Science (BS)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(degree_type));
        driver.findElement(degree_type).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(act_tag));
        String tag1_text = driver.findElement(act_tag).getText();
        Assert.assertEquals(tag1_text, "Animation");
        //String tag2_text = driver.findElement(deg_tag).getText();
        //Assert.assertEquals(tag2_text, "Undergraduate Degrees/Bachelor of Science (BS)");
        driver.findElement(next_btn).click();
        Thread.sleep(2000);
        String Work_txt = driver.findElement(label).getText();
        Assert.assertEquals(Work_txt, "Work Experience");
    }

    public void experience() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(comp_name));
        driver.findElement(comp_name).sendKeys("ABC Technologies");
        driver.findElement(position).sendKeys("Software Engineer");
        driver.findElement(start_date2).sendKeys("2020-02-10");
        driver.findElement(position).click();
        driver.findElement(current_work).click();
        driver.findElement(next_btn).click();
        Thread.sleep(2000);
        String Sensipitch_txt = driver.findElement(Sensipitch_label).getText();
        Assert.assertEquals(Sensipitch_txt, "SensiPitch");
    }

    public void sensipitch() throws InterruptedException {

        UploadVideo_Transcript vid = new UploadVideo_Transcript(driver, wait);

        String token = (String) ((JavascriptExecutor) driver)
                .executeScript("return window.localStorage.getItem('token');");

        boolean success = vid.uploadVideo(videoFile, token);

        if (success) {

            System.out.println("✅ Upload succeeded, calling transcript API...");

            Response response = vid.triggerTranscript(videoFile, token);
            System.out.println("Transcript API response: " + response.getBody().asString());

            String transcript = vid.getTranscriptText(response);
            String skills = vid.getQualificationsText(response);

            System.out.println("Transcript: " + transcript);
            System.out.println("Key Qualifications: " +skills);

            driver.navigate().refresh();
            wait.until(ExpectedConditions.visibilityOfElementLocated(Sensipitch_label));

            System.out.println("Page is Refreshed!");

            vid.fillTranscript(transcript);
            vid.fillSkills(skills);

            wait.until(ExpectedConditions.visibilityOfElementLocated(next_btn));
            driver.findElement(next_btn).click();
        }
        else {
            throw new RuntimeException("Video upload or transcript failed. Aborting test.");
        }

        Thread.sleep(2000);
        String Time_txt = driver.findElement(label).getText();
        Assert.assertEquals(Time_txt, "Available Times");
    }

    public void time() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(time1));
        driver.findElement(time1).click();
        WebElement time1_1 = driver.findElement(By.xpath("(//div[@class='cell bg-light-blue'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(time1_1));
        String time_class1 = time1_1.getAttribute("class");
        Assert.assertEquals(time_class1,"cell bg-light-blue");
        driver.findElement(time2).click();
        WebElement time2_2 = driver.findElement(By.xpath("(//div[@class='cell bg-light-blue'])[2]"));
        wait.until(ExpectedConditions.visibilityOf(time2_2));
        String time_class2 = time1_1.getAttribute("class");
        Assert.assertEquals(time_class2,"cell bg-light-blue");
        driver.findElement(time3).click();
        WebElement time3_3 = driver.findElement(By.xpath("(//div[@class='cell bg-light-blue'])[3]"));
        wait.until(ExpectedConditions.visibilityOf(time3_3));
        String time_class3 = time1_1.getAttribute("class");
        Assert.assertEquals(time_class3,"cell bg-light-blue");
        driver.findElement(time4).click();
        WebElement time4_4 = driver.findElement(By.xpath("(//div[@class='cell bg-light-blue'])[4]"));
        wait.until(ExpectedConditions.visibilityOf(time4_4));
        String time_class4 = time1_1.getAttribute("class");
        Assert.assertEquals(time_class4,"cell bg-light-blue");
        driver.findElement(time5).click();
        WebElement time5_5 = driver.findElement(By.xpath("(//div[@class='cell bg-light-blue'])[5]"));
        wait.until(ExpectedConditions.visibilityOf(time5_5));
        String time_class5 = time1_1.getAttribute("class");
        Assert.assertEquals(time_class5,"cell bg-light-blue");
        driver.findElement(next_btn).click();
        Thread.sleep(2000);
        String Id_txt = driver.findElement(label).getText();
        Assert.assertEquals(Id_txt, "Applicant Voluntary Self Identification");
    }

    public void self_identification() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(protected_vet));
        driver.findElement(protected_vet).click();
        driver.findElement(vet_input).sendKeys("No");
        driver.findElement(vet_input).sendKeys(Keys.ENTER);

        driver.findElement(disablity).click();
        driver.findElement(disablity_input).sendKeys("No");
        driver.findElement(disablity_input).sendKeys(Keys.ENTER);

        driver.findElement(ethinicity).click();
        driver.findElement(ethinicity_input).sendKeys("Asian");
        driver.findElement(ethinicity_input).sendKeys(Keys.ENTER);

        driver.findElement(sponsorship).click();
        driver.findElement(sponsorship_input).sendKeys("No");
        driver.findElement(sponsorship_input).sendKeys(Keys.ENTER);

        driver.findElement(term_check).click();
        driver.findElement(next_btn).click();
        Thread.sleep(2000);
        String Complete_txt = driver.findElement(label).getText();
        Assert.assertEquals(Complete_txt, "Profile Successfully Completed!");
    }

    public void get_a_job() {
        driver.findElement(GetStarted_btn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
        String dashboard_txt = driver.findElement(dashboard).getText();
        Assert.assertEquals(dashboard_txt, "Dashboard");
    }

}
