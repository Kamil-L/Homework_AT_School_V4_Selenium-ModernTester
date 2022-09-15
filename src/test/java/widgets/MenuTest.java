package widgets;

import basetest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuTest extends BaseTest {

    @Test
    @DisplayName("4.0 Menu")
    @Tag("widgets")
    @Tag("menu")
    void shouldDisplayModernSubmenuDetails() {

        driver.get("https://seleniumui.moderntester.pl/menu-item.php");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement musicMenu = driver.findElement(By.cssSelector("#ui-id-9"));
        wait.until(ExpectedConditions.elementToBeClickable(musicMenu));
        musicMenu.click();

        WebElement jazzSubmenuMusic = driver.findElement(By.cssSelector("#ui-id-13"));
        wait.until(ExpectedConditions.elementToBeClickable(jazzSubmenuMusic));
        jazzSubmenuMusic.click();

        WebElement modernSubmenuJazz = driver.findElement(By.cssSelector("#ui-id-16"));
        wait.until(ExpectedConditions.elementToBeClickable(modernSubmenuJazz));

        Actions actions = new Actions(driver);
        actions.moveToElement(modernSubmenuJazz);
    }
}
