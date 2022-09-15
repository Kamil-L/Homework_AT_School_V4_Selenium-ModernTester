package interactions;

import basetest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectableTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"You've selected: #1 #3 #4."})
    @DisplayName("4.0 Selectable")
    @Tag("interactions")
    @Tag("selectable")
    void shouldDisplaySelectedItemsText(String selectableTextExpected) {
        selectableTextExpected = "You've selected: #1 #3 #4.";
        driver.get("https://seleniumui.moderntester.pl/selectable.php");
        WebElement selectableOptionsContent = driver.findElement(By.cssSelector("#selectable"));

        WebElement selectableItem1 = driver.findElement(By.cssSelector("#selectable li:nth-child(1)"));
        Actions action = new Actions(driver);
        action.keyDown(Keys.LEFT_CONTROL).perform();
        selectableItem1.click();
        WebElement selectableItem3 = driver.findElement(By.cssSelector("#selectable li:nth-child(3)"));
        selectableItem3.click();
        WebElement selectableItem4 = driver.findElement(By.cssSelector("#selectable li:nth-child(4)"));
        selectableItem4.click();

        WebElement selectableText = driver.findElement(By.cssSelector("#feedback"));
        String selectableTextActual = selectableText.getText();
        assertThat(selectableTextActual).isEqualTo(selectableTextExpected);
    }
}

