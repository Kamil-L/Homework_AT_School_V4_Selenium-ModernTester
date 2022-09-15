package widgets;

import basetest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class DatepickerTest extends BaseTest {

    @Test
    @DisplayName("3.0 Datepicker")
    @Tag("widgets")
    @Tag("datepicker")
    void shouldDisplayExpectedDate() {

        driver.get("https://seleniumui.moderntester.pl/datepicker.php");

        WebElement datepickerInputElement = driver.findElement(By.id("datepicker"));
        datepickerInputElement.click();

        WebElement datepickerCurrentDayElement = driver.findElement(By.cssSelector(".ui-state-highlight"));
        datepickerCurrentDayElement.click();

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String currentDate = (dateFormat.format(date));

        assertThat(datepickerInputElement.getAttribute("value")).isEqualTo(currentDate);

        datepickerInputElement.clear();
        datepickerInputElement.click();

        WebElement actualDateElement = driver.findElement(By.cssSelector("td[data-month='9']"));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", actualDateElement);

        String actualDate = datepickerInputElement.getAttribute("value");
        String expectedDate = "10/01/2022";
        assertThat(actualDate).isEqualTo(expectedDate);

        datepickerInputElement.clear();
        datepickerInputElement.click();

        for (int i = 0; i < 4; i++) {
            executor.executeScript("arguments[0].click();", driver.findElement(By.className("ui-datepicker-next")));
        }

        List<WebElement> dateAll2 = driver.findElements(By.cssSelector("td[data-month='0']"));
        for (WebElement day2 : dateAll2) {
            String pickDate = day2.getText();
            if (pickDate.equalsIgnoreCase("31")) {
                day2.click();
                break;
            }
        }

        String actualDate2 = datepickerInputElement.getAttribute("value");
        String expectedDate2 = "01/31/2023";
        assertThat(actualDate2).isEqualTo(expectedDate2);

        datepickerInputElement.clear();
        datepickerInputElement.click();

        List<WebElement> dateAll3 = driver.findElements(By.cssSelector("td[data-month='0']"));
        for (WebElement day2 : dateAll3) {
            String pickDate = day2.getText();
            if (pickDate.equalsIgnoreCase("31")) {
                day2.click();
                break;
            }
        }

        String actualDate3 = datepickerInputElement.getAttribute("value");
        String expectedDate3 = "01/31/2023";
        assertThat(actualDate3).isEqualTo(expectedDate3);

        datepickerInputElement.clear();
        datepickerInputElement.click();

        WebElement datepickerPrevYearElement = driver.findElement(By.className("ui-datepicker-prev"));
        executor.executeScript("arguments[0].click();", datepickerPrevYearElement);

        List<WebElement> dateTable = driver.findElements(By.cssSelector("td[data-month='11']"));
        Random dates = new Random();
        int numberOfElements = dateTable.size();
        dates.nextInt(numberOfElements);

        datepickerInputElement.clear();
        datepickerInputElement.click();

        while (true) {
            String yearOption = driver.findElement(By.cssSelector("span.ui-datepicker-year")).getText();
            String monthOption = driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText();
            if (yearOption.equals("2021") && monthOption.equals("October")) {
                break;
            } else {
                executor.executeScript("arguments[0].click();", driver.findElement(By.className("ui-datepicker-prev")));
            }
        }

        List<WebElement> dateRangeTable = driver.findElements(By.cssSelector("td[data-month='9']"));
        int numberOfElements2 = dateRangeTable.size();
        dates.nextInt(numberOfElements2);
    }
}

