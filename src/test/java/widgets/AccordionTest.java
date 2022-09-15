package widgets;

import basetest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccordionTest extends BaseTest {

    @Test
    @DisplayName("1.0 Accordion")
    @Tag("widgets")
    @Tag("accordion")
    void shouldPrintOutTheTextInsideEachSections() {
        driver.get("https://seleniumui.moderntester.pl/accordion.php");

        WebElement section1 = driver.findElement(By.cssSelector("#ui-id-1"));
        section1.click();
        WebElement hiddenText = driver.findElement(By.cssSelector("#ui-id-2"));
        System.out.println(hiddenText.getAttribute("textContent"));


        WebElement section2 = driver.findElement(By.cssSelector("#ui-id-3"));
        section2.click();
        WebElement hiddenText2 = driver.findElement(By.cssSelector("#ui-id-4"));
        System.out.println(hiddenText2.getAttribute("textContent"));


        WebElement section3 = driver.findElement(By.cssSelector("#ui-id-5"));
        section3.click();
        WebElement hiddenText3 = driver.findElement(By.cssSelector("#ui-id-6"));
        System.out.println(hiddenText3.getAttribute("textContent"));

        WebElement section4 = driver.findElement(By.cssSelector("#ui-id-7"));
        section4.click();
        WebElement hiddenText4 = driver.findElement(By.cssSelector("#ui-id-8"));
        System.out.println(hiddenText4.getAttribute("textContent"));
    }
}

