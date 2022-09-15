package widgets;

import basetest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.Assertions.assertThat;

public class TooltipTest extends BaseTest {

    @Test
    @DisplayName("9.0 Tooltip")
    @Tag("widgets")
    @Tag("tooltip")
    void shouldPrintMessageFromTooltip() {

        driver.get("https://seleniumui.moderntester.pl/tooltip.php#");
        String expectedTooltipTxt = "We ask for your age only for statistical purposes.";

        WebElement ageInput = driver.findElement(By.cssSelector("#age"));

        Actions action = new Actions(driver);
        action.moveToElement(ageInput).build().perform();
        WebElement tooltipElement = driver.findElement(By.cssSelector(".ui-tooltip"));

        String actualTooltipTxt = tooltipElement.getText();

        assertThat(actualTooltipTxt).isEqualTo(expectedTooltipTxt);
    }
}