package basic;

import basetest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class FormTest extends BaseTest {


    @ParameterizedTest
    @ValueSource(strings = {"Form send with success"})
    @DisplayName("2.0 Filling out the form")
    @Tag("basic")
    @Tag("form")
    void shouldFillFormWithSuccess(String expectedFormSubmitMessage) {
        driver.get("https://seleniumui.moderntester.pl/form.php");
        expectedFormSubmitMessage = "Form send with success";
        WebElement firstName = driver.findElement(By.cssSelector("#inputFirstName3"));
        firstName.click();
        firstName.clear();
        firstName.sendKeys("Jan");

        WebElement lastName = driver.findElement(By.cssSelector("#inputLastName3"));
        lastName.click();
        lastName.clear();
        lastName.sendKeys("Kowalski");
        WebElement email = driver.findElement(By.cssSelector("#inputEmail3"));
        email.click();
        email.clear();
        email.sendKeys("jan.kowalski@email.com");

        List<WebElement> sexOptions = driver.findElements(By.name("gridRadiosSex"));
        assertThat(sexOptions.size() > 0);
        Random random = new Random();
        int sexOptionSelected = random.nextInt(sexOptions.size());
        sexOptions.get(sexOptionSelected).click();

        WebElement age = driver.findElement(By.cssSelector("#inputAge3"));
        age.click();
        age.clear();
        age.sendKeys("22");


        List<WebElement> yearOfExperienceOptions = driver.findElements(By.name("gridRadiosExperience"));
        assertThat(yearOfExperienceOptions.size() > 0);
        int yearOfExperienceSelected = random.nextInt(yearOfExperienceOptions.size());
        yearOfExperienceOptions.get(yearOfExperienceSelected).click();


        List<WebElement> professions = driver.findElements(By.name("gridCheckboxProfession"));
        assertThat(professions.size() > 0);
        for (WebElement profession : professions) {
            if (profession.isSelected()) {
                profession.click();
            }
        }
        WebElement automationTesterCheckbox = driver.findElement(By.cssSelector("#gridCheckAutomationTester"));
        automationTesterCheckbox.click();


        Select continents = new Select(driver.findElement(By.id("selectContinents")));
        List<WebElement> continentsOptions = continents.getOptions();
        Random rnd = new Random();
        int randomContinent = rnd.nextInt(continentsOptions.size());
        continentsOptions.get(randomContinent).click();


        Select select = new Select(driver.findElement(By.id("selectSeleniumCommands")));
        select.deselectAll();
        select.selectByValue("switch-commands");
        select.selectByValue("wait-commands");

        File file = new File("src/main/resources/fileTest.txt");
        driver.findElement(By.id("chooseFile")).sendKeys(file.getAbsolutePath());

        WebElement submitFormButton = driver.findElement(By.cssSelector("button.btn"));
        submitFormButton.click();

        WebElement formSubmitMessage = driver.findElement(By.cssSelector("#validator-message"));

        String actualFormSubmitMessage = formSubmitMessage.getText();
        assertThat(actualFormSubmitMessage).isEqualTo(expectedFormSubmitMessage);

    }
}
