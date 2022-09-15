package widgets;

import basetest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class SelectmenuTest extends BaseTest {

    @Test
    @DisplayName("7.0 Selectmenu")
    @Tag("widgets")
    @Tag("selectmenu")
    void shouldSelectElementsFromDropdownLists() {

        driver.get("https://seleniumui.moderntester.pl/selectmenu.php");

        WebElement speedDropdownBtn = driver.findElement(By.id("speed-button"));
        speedDropdownBtn.click();

        List<WebElement> speedOptionsElements = driver.findElements(By.cssSelector("ul#speed-menu .ui-menu-item"));
        Random rnd = new Random();
        speedOptionsElements.get(rnd.nextInt(speedOptionsElements.size())).click();


        WebElement fileDropdownBtn = driver.findElement(By.id("files-button"));
        fileDropdownBtn.click();

        List<WebElement> filesOptionsElements = driver.findElements(By.cssSelector("ul#files-menu .ui-menu-item"));
        for (WebElement filesOptionsElement : filesOptionsElements) {
            if (Objects.equals(filesOptionsElement.getText(), "ui.jQuery.js")) {
                filesOptionsElement.click();
                break;
            }
        }

        WebElement numberDropdownBtn = driver.findElement(By.id("number-button"));
        numberDropdownBtn.click();

        List<WebElement> numbersOptionsElements = driver.findElements(By.cssSelector("ul#number-menu .ui-menu-item"));
        numbersOptionsElements.get(0).click();


        WebElement titleDropdownBtn = driver.findElement(By.id("salutation-button"));
        titleDropdownBtn.click();

        List<WebElement> titleOptionsElements = driver.findElements(By.cssSelector("ul#salutation-menu .ui-menu-item"));
        int randomTitle = rnd.nextInt(1,6);
        titleOptionsElements.get(randomTitle).click();
    }
}