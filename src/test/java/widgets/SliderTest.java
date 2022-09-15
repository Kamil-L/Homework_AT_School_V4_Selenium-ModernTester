package widgets;

import basetest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class SliderTest extends BaseTest {

    @Test
    @DisplayName("8.0 Slider")
    @Tag("widgets")
    @Tag("slider")
    void shouldMoveSliderToCorrectValues() {

        driver.get("https://seleniumui.moderntester.pl/slider.php");

        WebElement sliderHandler = driver.findElement(By.cssSelector("#custom-handle"));

        int expectedValue1 = 50;
        int actualValue1 = 0;

        for (int i = actualValue1; i < expectedValue1; i++) {
            sliderHandler.sendKeys(Keys.ARROW_RIGHT);
        }
        assertThat(Integer.parseInt(sliderHandler.getText())).isEqualTo(expectedValue1);

        int expectedValue2 = 80;
        int actualValue2 = 50;

        for (int i = actualValue2; i < expectedValue2; i++) {
            sliderHandler.sendKeys(Keys.ARROW_RIGHT);
        }
        assertThat(Integer.parseInt(sliderHandler.getText())).isEqualTo(expectedValue2);

        int expectedValue3 = 80;
        int actualValue3 = 80;

        for (int i = actualValue3; i < expectedValue3; i--) {
            sliderHandler.sendKeys(Keys.ARROW_LEFT);
        }
        assertThat(Integer.parseInt(sliderHandler.getText())).isEqualTo(expectedValue3);

        int expectedValue4 = 20;
        int actualValue4 = 80;

        for (int i = actualValue4; i > expectedValue4; i--) {
            sliderHandler.sendKeys(Keys.ARROW_LEFT);
        }
        assertThat(Integer.parseInt(sliderHandler.getText())).isEqualTo(expectedValue4);

        int expectedValue5 = 0;
        int actualValue5 = 20;

        for (int i = actualValue5; i > expectedValue5; i--) {
            sliderHandler.sendKeys(Keys.ARROW_LEFT);
        }
        assertThat(Integer.parseInt(sliderHandler.getText())).isEqualTo(expectedValue5);
    }
}