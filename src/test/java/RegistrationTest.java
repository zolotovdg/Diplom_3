import PageObject.MainPage;
import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTest extends BaseTest {
    MainPage page;

    @Description("Успешная регистрация")
    @Test
    public void checkingSuccessRegistrationMethod() {
        page = new MainPage(driver);
        page.getLogIn().click();
        page.getRegistration().click();
        page.getUserName().sendKeys(RandomStringUtils.randomAlphabetic(8));
        page.getUserEmail().sendKeys(RandomStringUtils.randomAlphabetic(8) + "@mail.ru");
        page.getUserPassword().sendKeys(RandomStringUtils.randomAlphabetic(8));
        page.getFinalRegistration().click();
        assertTrue(page.getLogInAfterReg().isDisplayed());
    }

    @Description("Тестирование ошибки в случае ввода некорректного пароля")
    @Test
    public void checkingIncorrectPasswordRegistrationMethod() {
        page = new MainPage(driver);
        page.getLogIn().click();
        page.getRegistration().click();
        page.getUserName().sendKeys(RandomStringUtils.randomAlphabetic(8));
        page.getUserEmail().sendKeys(RandomStringUtils.randomAlphabetic(8) + "@mail.ru");
        page.getUserPassword().sendKeys(RandomStringUtils.randomAlphabetic(4));
        page.getFinalRegistration().click();
        assertEquals("Некорректный пароль",
                page.getErrorPasswordRegistration().getText());
    }
}
