import io.qameta.allure.Description;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import model.CredentialModel;
import model.UserModel;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.MainPage;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginTest extends BaseTest {
    private MainPage page;
    private UserModel user;
    private CredentialModel credential;
    private String accessToken = "";
    private WebDriverWait wait = new WebDriverWait(driver, 10);

    @BeforeEach
    public void createUser() {
        String random = RandomStringUtils.randomAlphabetic(8);
        user = new UserModel(random + "@ya.ru", "123456", random);
        given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/auth/register");
    }

    @AfterEach
    public void deleteUser() {
        credential = new CredentialModel(user.getEmail(), user.getPassword());
        String response = given()
                .contentType(ContentType.JSON)
                .body(credential)
                .when()
                .post("/auth/login")
                .then()
                .extract().asString();
        JsonPath j = new JsonPath(response);
        if (j.getString("accessToken") != null) {
            accessToken = j.getString("accessToken").substring(7);
            given()
                    .contentType(ContentType.JSON)
                    .auth().oauth2(accessToken)
                    .when()
                    .delete("/auth/user");
        }
    }

    @Description("Вход по кнопке <Войти> на главной")
    @Test
    public void accountSignInViaMainButtonTest() {
        page = new MainPage(driver);
        page.getLogIn().click();
        page.getUserEmailSignIn().sendKeys(user.getEmail());
        page.getUserPasswordSignIn().sendKeys(user.getPassword());
        page.getSignInButton().click();
        assertTrue(page.getHeaderBurger().isDisplayed());
    }

    @Description("Вход через кнопку <Личный кабинет>")
    @Test
    public void accountSignInViaPersonalPageButtonTest() {
        page = new MainPage(driver);
        page.getPersonalAccount().click();
        page.getUserEmailSignIn().sendKeys(user.getEmail());
        page.getUserPasswordSignIn().sendKeys(user.getPassword());
        page.getSignInButton().click();
        assertTrue(page.getHeaderBurger().isDisplayed());
    }

    @Description("Вход через кнопку в форме регистрации")
    @Test
    public void accountSignInViaRegistrationFormButtonTest() {
        page = new MainPage(driver);
        page.getPersonalAccount().click();
        page.getRegistration().click();
        page.getLogInAfterReg().click();
        page.getUserEmailSignIn().sendKeys(user.getEmail());
        page.getUserPasswordSignIn().sendKeys(user.getPassword());
        page.getSignInButton().click();
        assertTrue(page.getHeaderBurger().isDisplayed());
    }

    @Description("Вход через кнопку в форме восстановления пароля")
    @Test
    public void accountSignInViaForgotPasswordFormTest() {
        page = new MainPage(driver);
        page.getPersonalAccount().click();
        page.getRestorePassword().click();
        page.getLogInRestoreForm().click();
        page.getUserEmailSignIn().sendKeys(user.getEmail());
        page.getUserPasswordSignIn().sendKeys(user.getPassword());
        page.getSignInButton().click();
        assertTrue(page.getHeaderBurger().isDisplayed());
    }

    @Description("Переход по клику в личный кабинет")
    @Test
    public void redirectInPersonalAccountTest() {
        page = new MainPage(driver);
        page.getPersonalAccount().click();
        assertEquals("https://stellarburgers.nomoreparties.site/login",
                driver.getCurrentUrl());
    }

    @Description("Переход по клику на <Конструктор>")
    @Test
    public void redirectToConstructorTest() {
        page = new MainPage(driver);
        page.getPersonalAccount().click();
        page.getConstructorButton().click();
        assertTrue(page.getHeaderBurger().isDisplayed());
        assertEquals("https://stellarburgers.nomoreparties.site/",
                driver.getCurrentUrl());
    }

    @Description("Нажатие на логотип Stellar Burgers")
    @Test
    public void redirectToLogoTest() {
        page = new MainPage(driver);
        page.getPersonalAccount().click();
        page.getLogo().click();
        assertTrue(page.getHeaderBurger().isDisplayed());
        assertEquals("https://stellarburgers.nomoreparties.site/",
                driver.getCurrentUrl());
    }

    @Description("Выход по кнопке <Выйти> в личном кабинете")
    @Test
    public void signOutTest() {
        page = new MainPage(driver);
        page.getLogIn().click();
        page.getUserEmailSignIn().sendKeys(user.getEmail());
        page.getUserPasswordSignIn().sendKeys(user.getPassword());
        page.getSignInButton().click();
        assertTrue(page.getHeaderBurger().isDisplayed());
        page.getPersonalAccount().click();
        page.getQuitButton().click();
        assertTrue(page.getUserName().isDisplayed());
    }

    @Description("Проверка перехода к разделу <Булки>")
    @Test
    public void constructorScrollBunsTest() {
        page = new MainPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(page.getBunsButton()));
        // В другой реализации время от времени получаем - ElementClickInterceptedException
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", page.getBunsButton());
        assertTrue(page.getBunsBlock().isDisplayed());
    }

    @Description("Проверка перехода к разделу <Соусы>")
    @Test
    public void constructorScrollSoucesTest() {
        page = new MainPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(page.getSoucesButton()));
        // В другой реализации время от времени получаем - ElementClickInterceptedException
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", page.getSoucesButton());
        assertTrue(page.getSoucesBlock().isDisplayed());
    }

    @Description("Проверка перехода к разделу <Начинки>")
    @Test
    public void constructorScrollIngredientTest() {
        page = new MainPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(page.getIngredientsButton()));
        // В другой реализации время от времени получаем - ElementClickInterceptedException
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", page.getIngredientsButton());
        assertTrue(page.getIngredientsBlock().isDisplayed());
    }
}
