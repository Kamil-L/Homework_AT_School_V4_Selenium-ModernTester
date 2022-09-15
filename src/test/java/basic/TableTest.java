package basic;

import basetest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableTest extends BaseTest {

    @Test
    @DisplayName("4.0 Table")
    @Tag("basic")
    @Tag("table")
    void shouldPrintPeaksOver4000HighInSwitzerland() {
        driver.get("https://seleniumui.moderntester.pl/table.php");

        List<WebElement> tableRows = driver.findElements(By.cssSelector("tbody tr"));

        System.out.println("Mountains in Switzerland which are over 4000m high:\n");
        for (WebElement tableRow : tableRows) {
            int rank = Integer.parseInt(tableRow.findElement(By.xpath("th[1]")).getText());
            String peak = tableRow.findElements(By.cssSelector("td")).get(0).getText();
            String mountainRange = tableRow.findElements(By.cssSelector("td")).get(1).getText();
            String state = tableRow.findElements(By.cssSelector("td")).get(2).getText();
            int height = Integer.parseInt(tableRow.findElement(By.xpath("td[4]")).getText());
            if ((height > 4000) && (state.contains("Switzerland"))) {
                System.out.println("Rank: " + rank + ", " + "Peak: " + peak + ", " +
                        "Mountain range: " + mountainRange + "\n");
            }
        }
    }
}
