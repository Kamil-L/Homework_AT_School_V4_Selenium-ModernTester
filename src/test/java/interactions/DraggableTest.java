package interactions;

import basetest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DraggableTest extends BaseTest {


    @Test
    @DisplayName("1.0 Draggable")
    @Tag("interactions")
    @Tag("draggable")
    void shouldDragSquareToExpectedPosition() {
        driver.get("https://seleniumui.moderntester.pl/draggable.php");
        WebElement from = driver.findElement(By.id("draggable"));

        Actions action = new Actions(driver);

        int xOffset1 = from.getLocation().getX();
        int yOffset1 = from.getLocation().getY();

        action.dragAndDropBy(from, xOffset1 * 2, 0).build().perform();
        action.dragAndDropBy(from, 0, yOffset1 * 2).build().perform();
        action.dragAndDropBy(from, -xOffset1, -yOffset1).build().perform();
        action.dragAndDropBy(from, -xOffset1, yOffset1).build().perform();
    }
}
