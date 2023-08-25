package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
    public String url = "https://stellarburgers.nomoreparties.site/";
    public MainPage(WebDriver driver) {
        super(driver);
        driver.get(url);
    }

    // РЕГИСТРАЦИЯ
    // Кнопка "Войти в аккаунт"
    private By logIn = By.xpath("//button[contains(text(),'Войти в аккаунт')]");
    // Кнопка "Зарегистрироваться" (Первичная)
    private By registration = By.xpath("//a[contains(text(),'Зарегистрироваться')]");
    // Поле "Имя"
    private By userName = By.xpath(".//fieldset[1]//input");
    // Поле "Email"
    private By userEmail = By.xpath(".//fieldset[2]//input");
    private By userEmailSignIn = By.xpath(".//fieldset[1]//input");
    // Поле "Пароль"
    private By userPassword = By.xpath(".//fieldset[3]//input");
    private By userPasswordSignIn = By.xpath(".//fieldset[2]//input");
    // Кнопка "Зарегистрироваться" на форме ввода данных
    private By finalRegistration = By.xpath("(//button[contains(text(),'Зарегистрироваться')])[1]");
    // Ошибка "Некорректный пароль"
    private By errorPasswordRegistration = By.xpath("//p[@class='input__error text_type_main-default']");

    // ВХОД В АККАУНТ
    // Кнопка "Личный кабинет"
    private By personalAccount = By.xpath("//p[contains(text(),'Личный Кабинет')]");
    // Кнопка "Войти" (В т.ч. кнопка "войти" сразу после регистрации. Редирект сюда)
    private By logInAfterReg = By.xpath("(//a[contains(text(),'Войти')])[1]");
    // Кнопка "Восстановить пароль"
    private By restorePassword = By.xpath("//a[contains(text(),'Восстановить пароль')]");
    // Кнопка "Войти" на форме восстановления пароля
    private By logInRestoreForm = By.xpath("//a[@class='Auth_link__1fOlj']");
    // Кнопка "Соберите бургер"
    private By headerBuildBurger = By.xpath("(//h1[contains(text(),'Соберите бургер')])[1]");
    // Кнопка "Личный кабинет"
    private By signInButton = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    // Кнопка "Конструктор"
    private By construtorButton = By.xpath("//p[contains(text(),'Конструктор')]");
    // Логотип
    private By logo = By.xpath(".//*[@class='AppHeader_header__logo__2D0X2']");
    // Кнопка "Выход"
    private By quitButton = By.xpath("//button[contains(text(),'Выход')]");
    // Кнопка "Булки"
    private By bunsButton = By.xpath("//span[contains(text(),'Булки')]");
    // Кнопка "Соусы"
    private By soucesButton = By.xpath("//span[contains(text(),'Соусы')]");
    // Кнопка "Ингридиенты"
    private By ingredientsButton = By.xpath("//span[contains(text(),'Начинки')]");
    // Блок "Булки"
    private By bunsBlock = By.xpath("//h2[contains(text(),'Булки')]");
    // Блок "Соусы"
    private By soucesBlock = By.xpath("//h2[contains(text(),'Соусы')]");
    // Блок "Ингриденты"
    private By ingredientsBlock = By.xpath("//h2[contains(text(),'Начинки')]");

    public WebElement getLogIn() {
        return driver.findElement(logIn);
    }

    public WebElement getRegistration() {
        return driver.findElement(registration);
    }

    public WebElement getUserName() {

        return driver.findElement(userName);
    }

    public WebElement getUserEmail() {

        return driver.findElement(userEmail);
    }

    public WebElement getUserPassword() {

        return driver.findElement(userPassword);
    }

    public WebElement getFinalRegistration() {

        return driver.findElement(finalRegistration);
    }

    public WebElement getPersonalAccount() {

        return driver.findElement(personalAccount);
    }

    public WebElement getLogInAfterReg() {

        return driver.findElement(logInAfterReg);
    }

    public WebElement getRestorePassword() {

        return driver.findElement(restorePassword);
    }

    public WebElement getLogInRestoreForm() {

        return driver.findElement(logInRestoreForm);
    }

    public WebElement getErrorPasswordRegistration() {

        return driver.findElement(errorPasswordRegistration);
    }

    public WebElement getHeaderBurger() {

        return driver.findElement(headerBuildBurger);
    }

    public WebElement getSignInButton() {

        return driver.findElement(signInButton);
    }

    public WebElement getConstructorButton() {

        return driver.findElement(construtorButton);
    }

    public WebElement getLogo() {

        return driver.findElement(logo);
    }

    public WebElement getQuitButton() {

        return driver.findElement(quitButton);
    }

    public WebElement getBunsButton() {

        return driver.findElement(bunsButton);
    }

    public WebElement getSoucesButton() {

        return driver.findElement(soucesButton);
    }

    public WebElement getIngredientsButton() {

        return driver.findElement(ingredientsButton);
    }

    public WebElement getBunsBlock() {

        return driver.findElement(bunsBlock);
    }

    public WebElement getSoucesBlock() {

        return driver.findElement(soucesBlock);
    }

    public WebElement getIngredientsBlock() {

        return driver.findElement(ingredientsBlock);
    }

    public WebElement getUserEmailSignIn() {
        return driver.findElement(userEmailSignIn);
    }

    public WebElement getUserPasswordSignIn() {
        return driver.findElement(userPasswordSignIn);
    }
}
