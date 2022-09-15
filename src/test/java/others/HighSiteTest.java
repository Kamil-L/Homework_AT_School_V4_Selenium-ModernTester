package others;

import basetest.BaseTest;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class HighSiteTest extends BaseTest {

    @Test
    @DisplayName("1.0 High Site")
    @Tag("others")
    @Tag("high site")
    void shouldTakeScreenshotWhenSubmitButtonAppears() throws IOException {

        driver.get("https://seleniumui.moderntester.pl/high-site.php");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement submitButton = driver.findElement(By.cssSelector(".show-button"));
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".show-button")));

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//src/main/resources/screen.png"));
    }
}
