package widgets;

import basetest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgressbarTest extends BaseTest {


    @Test
    @DisplayName("6.0 Progressbar")
    @Tag("widgets")
    @Tag("progressbar")
    void shouldWaitUntilProgressbarIsComplete() {

        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        String expectedProgressbarText = "Complete!";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement completeTextActual = driver.findElement(By.cssSelector(".progress-label"));
        wait.until(ExpectedConditions.textToBePresentInElement(completeTextActual, "Complete!"));
        assertThat(completeTextActual.getText()).isEqualTo(expectedProgressbarText);
    }
}