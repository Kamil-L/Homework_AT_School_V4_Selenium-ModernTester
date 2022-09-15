package basic;

import basetest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class IframesTest extends BaseTest {

    @Test
    @DisplayName("3.0 Iframes")
    @Tag("basic")
    @Tag("iframes")
    void shouldSwitchToExpectedFrames() {
        driver.get("https://seleniumui.moderntester.pl/iframes.php");
        driver.switchTo().frame("iframe1");
        WebElement firstName = driver.findElement(By.cssSelector("#inputFirstName3"));
        firstName.click();
        firstName.clear();
        firstName.sendKeys("Jan");
        WebElement surname = driver.findElement(By.cssSelector("#inputSurname3"));
        surname.click();
        surname.clear();
        surname.sendKeys("Kowalski");
        WebElement signInButton1 = driver.findElement(By.cssSelector(".btn"));
        signInButton1.click();
        driver.switchTo().defaultContent();


        driver.switchTo().frame("iframe2");
        WebElement login = driver.findElement(By.cssSelector("#inputLogin"));
        login.click();
        login.clear();
        login.sendKeys("jankow");
        WebElement password = driver.findElement(By.cssSelector("#inputPassword"));
        password.click();
        password.clear();
        password.sendKeys("jankow123");

        Select continents = new Select(driver.findElement(By.id("inlineFormCustomSelectPref")));
        List<WebElement> continentsOptions = continents.getOptions();
        Random rnd = new Random();
        int randomContinent = rnd.nextInt(continentsOptions.size());
        continentsOptions.get(randomContinent).click();

        List<WebElement> yearOfExperienceOptions = driver.findElements(By.name("gridRadios"));
        assertThat(yearOfExperienceOptions.size() > 0);
        int yearOfExperienceSelected = rnd.nextInt(yearOfExperienceOptions.size());
        yearOfExperienceOptions.get(yearOfExperienceSelected).click();

        WebElement signInButton2 = driver.findElement(By.cssSelector(".btn"));
        signInButton2.click();

        driver.switchTo().defaultContent();

        WebElement basicMenuBtn = driver.findElement(By.cssSelector("li.nav-ite.dropdown"));
        basicMenuBtn.click();

    }
}
