package interactions;

import basetest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ResizableTest extends BaseTest {

    @Test
    @DisplayName("3.0 Resizable")
    @Tag("interactions")
    @Tag("resizable")
    void shouldResizeBoxToExpectedSize() {

        driver.get("https://seleniumui.moderntester.pl/resizable.php");

        WebElement drag = driver.findElement(By.cssSelector("div.ui-icon-gripsmall-diagonal-se"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).moveByOffset(28, 0).release().build().perform();
        actions.clickAndHold(drag).moveByOffset(0, 28).release().build().perform();
        actions.clickAndHold(drag).moveByOffset(28, 28).release().build().perform();
    }
}
