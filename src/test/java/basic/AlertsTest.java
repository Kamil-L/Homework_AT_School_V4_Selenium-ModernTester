package basic;

import basetest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class AlertsTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"OK button pressed"})
    @DisplayName("1.1 Simple Alert Pop up")
    @Tag("basic")
    @Tag("alerts")
    void shouldDisplayOkButtonPressedText(String expectedAlertText) {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        expectedAlertText = "OK button pressed";
        WebElement simpleAlertButton = driver.findElement(By.cssSelector("#simple-alert"));
        simpleAlertButton.click();
        driver.switchTo().alert().accept();
        WebElement simpleAlertLabel = driver.findElement(By.cssSelector("#simple-alert-label"));
        String actualAlertText = simpleAlertLabel.getText();
        assertThat(actualAlertText).isEqualTo(expectedAlertText);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello Lord Vader! How are you today?"})
    @DisplayName("1.2 Prompt Alert box")
    @Tag("basic")
    @Tag("alerts")
    void shouldDisplayHelloLordVaderText(String expectedAlertText) {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        expectedAlertText = "Hello Lord Vader! How are you today?";
        WebElement promptAlertButton = driver.findElement(By.cssSelector("#prompt-alert"));
        promptAlertButton.click();
        driver.switchTo().alert().sendKeys("Lord Vader");
        driver.switchTo().alert().accept();
        WebElement promptAlertLabel = driver.findElement(By.cssSelector("#prompt-label"));
        String actualAlertText = promptAlertLabel.getText();
        assertThat(actualAlertText).isEqualTo(expectedAlertText);
    }

    @Test
    @DisplayName("1.3 Confirm Alert box")
    @Tag("basic")
    @Tag("alerts")
    void shouldDisplayExpectedText(String expectedAlertOkText, String expectedAlertCancelText) {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        expectedAlertOkText = "OK button pressed";
        expectedAlertCancelText = "You pressed Cancel!";
        WebElement confirmAlertButton = driver.findElement(By.cssSelector("#confirm-alert"));
        confirmAlertButton.click();
        driver.switchTo().alert().accept();
        WebElement confirmAlertLabel = driver.findElement(By.cssSelector("#confirm-label"));
        String actualAlertOkText = confirmAlertLabel.getText();
        assertThat(actualAlertOkText).isEqualTo(expectedAlertOkText);

        confirmAlertButton = driver.findElement(By.cssSelector("#confirm-alert"));
        confirmAlertButton.click();
        driver.switchTo().alert().dismiss();
        confirmAlertLabel = driver.findElement(By.cssSelector("#confirm-label"));
        String actualAlertCancelText = confirmAlertLabel.getText();
        assertThat(actualAlertCancelText).isEqualTo(expectedAlertCancelText);
    }

    @ParameterizedTest
    @ValueSource(strings = {"OK button pressed"})
    @DisplayName("1.4 Delayed alert")
    @Tag("basic")
    @Tag("alerts")
    void shouldDisplayDelayedOkButtonPressedText(String expectedAlertText) {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        expectedAlertText = "OK button pressed";
        WebElement delayedAlertButton = driver.findElement(By.cssSelector("#delayed-alert"));
        delayedAlertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        WebElement delayedAlertLabel = driver.findElement(By.cssSelector("#delayed-alert-label"));
        String actualAlertText = delayedAlertLabel.getText();
        assertThat(actualAlertText).isEqualTo(expectedAlertText);
    }
}
