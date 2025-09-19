package pages;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class UploadVideo_Transcript extends BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;

    private By expand_identifications = By.xpath("(//div[@class='ant-collapse-expand-icon'])[2]");
    private By identifications_input = By.className("ql-editor");
    private By edit1 = By.xpath("(//span[contains(text(),'Edit')])[1]");
    private By expand_transcript = By.xpath("(//div[@class='ant-collapse-expand-icon'])[1]");
    private By transcript_input = By.cssSelector("textarea[name='transcript']");
    private By save = By.xpath("(//span[normalize-space()='Save'])[1]");
    private By edit2 = By.xpath("(//span[contains(text(),'Edit')])[2]");

    public UploadVideo_Transcript(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean uploadVideo(File videoFile, String token) {
        try {
            Response uploadResponse = RestAssured
                    .given()
                    .log().all()
                    .baseUri("https://uat.sensiply.com")
                    .basePath("/api/v1/users/jobseeker-video")
                    .header("Authorization", "Bearer " + token)
                    .multiPart("video", videoFile, "video/mp4")
                    .when()
                    .post()
                    .then()
                    .log().all()
                    .extract().response();

            System.out.println("Upload Status: " + uploadResponse.getStatusCode());

            if (uploadResponse.getStatusCode() != 200) {
                System.err.println("❌ Video upload failed");
                return false;
            }

            return uploadResponse.getStatusCode() == 200;

        } catch (Exception e) {
            System.err.println("Upload or transcript trigger failed: " + e.getMessage());
            return false;
        }
    }

    public Response triggerTranscript(File videoFile, String token) {
        try {
        return RestAssured
                .given()
                .baseUri("https://uat.sensiply.com")
                .basePath("/api/v1/users/jobseeker-video/transcript")
                .header("Authorization", "Bearer " + token)
                .multiPart("video", videoFile, "video/mp4")
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().response();
    } catch (Exception e) {
        System.err.println("Transcript trigger failed: " + e.getMessage());
        throw e;  }
    }

    public String getTranscriptText(Response response) {
        return response.jsonPath().getString("transcript");
    }

    public String getQualificationsText(Response response) {
        return response.jsonPath().getString("keyQualifications");
    }

    public void fillTranscript(String transcriptText) {
        driver.findElement(edit1).click();
        driver.findElement(expand_transcript).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(transcript_input));
        driver.findElement(transcript_input).clear();
        driver.findElement(transcript_input).sendKeys(transcriptText);
        driver.findElement(save).click();
    }

    public void fillSkills(String qualificationsRaw) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(edit2));
        driver.findElement(edit2).click();
        driver.findElement(expand_identifications).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(identifications_input));
        WebElement qualificationsInput = wait.until(ExpectedConditions.elementToBeClickable(identifications_input));
        driver.findElement(identifications_input).clear();

        String[] skills = qualificationsRaw.split(",");
        for (String skill : skills) {
            String trimmed = skill.trim();

            // Remove leading numbers, dots, and asterisks (e.g.,"1. ", "12. **")
            String cleanSkill = trimmed.replaceFirst("^\\d+\\.\\s*\\**", "")  // removes "12. **"
                    .replaceAll("\\*+", "")                 // removes remaining "**"
                    .trim();

            if (!cleanSkill.isEmpty()) {
                qualificationsInput.sendKeys(cleanSkill);
                qualificationsInput.sendKeys(Keys.ENTER);
                Thread.sleep(300);
            }
        }
        driver.findElement(save).click();
    }

}
