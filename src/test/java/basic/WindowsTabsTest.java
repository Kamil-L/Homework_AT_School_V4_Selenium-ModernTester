package basic;

import basetest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WindowsTabsTest extends BaseTest {

    @Test
    @DisplayName("5.0 Windows/Tabs")
    @Tag("basic")
    @Tag("windows/tabs")
    void shouldSwitchToNewWindows() {

        driver.get("https://seleniumui.moderntester.pl/windows-tabs.php");

        String mainWindow = driver.getWindowHandle();

        WebElement newBrowserWindowBtn = driver.findElement(By.cssSelector("#newBrowserWindow"));
        newBrowserWindowBtn.click();

        for (String newBrowserWindowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(newBrowserWindowHandle);
        }

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
        driver.close();
        driver.switchTo().window(mainWindow);

        WebElement newMessageWindowBtn = driver.findElement(By.cssSelector("#newMessageWindow"));
        newMessageWindowBtn.click();

        for (String newMessageWindowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(newMessageWindowHandle);
        }

        WebElement bodyText = driver.findElement(By.xpath("//body"));
        System.out.println(bodyText.getText());
        driver.close();

        driver.switchTo().window(mainWindow);

        WebElement newBrowserTabBtn = driver.findElement(By.cssSelector("#newBrowserTab"));
        newBrowserTabBtn.click();

        for (String newBrowserTabHandle : driver.getWindowHandles()) {
            driver.switchTo().window(newBrowserTabHandle);
        }

        List<WebElement> tableRows2 = driver.findElements(By.cssSelector("tbody tr"));

        System.out.println("Mountains in Switzerland which are over 4000m high:\n");
        for (WebElement tableRow : tableRows2) {
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
        driver.close();
    }
}
