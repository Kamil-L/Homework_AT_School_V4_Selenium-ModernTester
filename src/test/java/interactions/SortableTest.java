package interactions;

import basetest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortableTest extends BaseTest {

    @Test
    @DisplayName("5.0 Selectable")
    @Tag("interactions")
    @Tag("sortable")
    void shouldMoveItemsOnListToMatchShuffledTable() {
        driver.get("https://seleniumui.moderntester.pl/sortable.php");

        List<WebElement> itemsOptions = driver.findElements(By.cssSelector("*[id='sortable'] >li"));
        List<Integer> numbersList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        Collections.shuffle(numbersList);

        for (int i = 0; i < numbersList.size(); i++) {
            int numIndex = numbersList.get(i);
            WebElement itemFrom = driver.findElement(By.xpath("//li[contains(text(), 'Item " + numIndex + "')]"));
            WebElement itemTo = itemsOptions.get(i);
            Actions actions = new Actions(driver);
            actions.dragAndDrop(itemFrom, itemTo).perform();
        }
    }
}
