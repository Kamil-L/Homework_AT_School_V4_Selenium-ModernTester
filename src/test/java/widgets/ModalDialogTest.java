package widgets;

import basetest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ModalDialogTest extends BaseTest {


    public static Object[][] getData() {
        return new Object[][]{
                {"Jan Nowak", "janNow123@email.com", "123JanNow"},
                {"Jan Kowalski", "janKow123@email.com", "123JanKow"},
                {"Krzysztof Nowak", "krzNow123@email.com", "123KrzNow"},
        };
    }

    @ParameterizedTest
    @MethodSource("getData")
    @DisplayName("5.0 Modal Dialog")
    @Tag("widgets")
    @Tag("modal dialog")
    void shouldAddNewRowWithUserDetails(String expectedNameData, String expectedEmailData, String expectedPasswordData) {

        driver.get("https://seleniumui.moderntester.pl/modal-dialog.php");

        WebElement createUserButton = driver.findElement(By.cssSelector("#create-user"));
        createUserButton.click();

        WebElement name = driver.findElement(By.cssSelector("#name"));
        name.click();
        name.clear();
        name.sendKeys(expectedNameData);

        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.click();
        email.clear();
        email.sendKeys(expectedEmailData);

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.click();
        password.clear();
        password.sendKeys(expectedPasswordData);

        WebElement createAccount = driver.findElement(By.cssSelector("button.ui-button:nth-child(1)"));
        createAccount.click();


        List<WebElement> usersDetailsTable = driver.findElements(By.xpath("//tbody/tr[2]"));
        for (WebElement usersDetail : usersDetailsTable) {
            String actualNameData = usersDetail.findElements(By.cssSelector("td")).get(0).getText();
            String actualEmailData = usersDetail.findElements(By.cssSelector("td")).get(1).getText();
            String actualPasswordData = usersDetail.findElements(By.cssSelector("td")).get(2).getText();

            assertThat(actualNameData).isEqualTo(expectedNameData);
            assertThat(actualEmailData).isEqualTo(expectedEmailData);
            assertThat(actualPasswordData).isEqualTo(expectedPasswordData);
        }
    }
}
