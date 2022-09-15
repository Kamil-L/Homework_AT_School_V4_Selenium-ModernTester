package widgets;

import basetest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class AutocompleteTest extends BaseTest {

    @Test
    @DisplayName("2.0 Autocomplete")
    @Tag("widgets")
    @Tag("autocomplete")
    void shouldDisplayEqualTextInSearchInputAndSelectedOption() {
        driver.get("https://seleniumui.moderntester.pl/autocomplete.php");

        WebElement searchInput = driver.findElement(By.cssSelector("#search"));
        searchInput.click();
        searchInput.sendKeys("a");

        List<WebElement> searchOptions = driver.findElements(By.cssSelector(".ui-menu-item"));
        assertThat(searchOptions.size() > 0);
        Random rnd = new Random();
        String randomSearchOption = searchOptions.get(rnd.nextInt(searchOptions.size())).getText();
        for (WebElement searchInputOption : searchOptions) {
            System.out.println(searchInputOption.getText());
        }
        assertThat(randomSearchOption).contains("a");
    }
}

