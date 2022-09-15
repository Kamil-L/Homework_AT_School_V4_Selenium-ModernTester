package interactions;

import basetest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.Assertions.assertThat;

public class DroppableTest extends BaseTest {


    @ParameterizedTest
    @ValueSource(strings = {"Dropped!"})
    @DisplayName("2.0 Droppable")
    @Tag("interactions")
    @Tag("droppable")
    void shouldDropElementWithSuccess(String droppableTextExpected) {
        droppableTextExpected = "Dropped!";
        driver.get("https://seleniumui.moderntester.pl/droppable.php");
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(drag)
                .moveToElement(drop)
                .release()
                .perform();
        WebElement droppableText = driver.findElement(By.cssSelector("#droppable > p"));
        String droppableTextActual = droppableText.getText();
        assertThat(droppableTextActual).isEqualTo(droppableTextExpected);

    }
}
