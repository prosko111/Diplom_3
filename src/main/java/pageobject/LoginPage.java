package pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class LoginPage {

    public static String url = "https://stellarburgers.nomoreparties.site";
    public static String urlRegistration = "https://stellarburgers.nomoreparties.site/register";
    public static String urlLogin = "https://stellarburgers.nomoreparties.site/login";

    public static String name = RandomStringUtils.randomAlphabetic(10);
    public static String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
    public static String password = RandomStringUtils.randomAlphabetic(10);

    // Поле ввода почты
    @FindBy(how = How.XPATH, using = "//input[@class=\"text input__textfield text_type_main-default\" and @type=\"text\"]")
    private SelenideElement emailFieldOnLoginPage;

    // Поле ввода пароля
    @FindBy(how = How.XPATH, using = "//input[@class=\"text input__textfield text_type_main-default\" and @type=\"password\"]")
    private SelenideElement passwordFieldOnLoginPage;

    // Кнопка войти
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement loginButton;

    // Кнопка зарегистироваться
    @FindBy(how = How.LINK_TEXT, using = "Зарегистрироваться")
    private SelenideElement registerButtonOnLoginPage;

    // Кнопка восставновления пароля
    @FindBy(how = How.XPATH, using = "//a[text()=\"Восстановить пароль\"]")
    private SelenideElement recoveryPasswordOnLoginPage;

    public LoginPage() {
    }

    @Step("Заполнение почты")
    public void fillEmailFieldOnLoginPage(String text) {
        emailFieldOnLoginPage.shouldBe(visible);
        emailFieldOnLoginPage.sendKeys(text);
    }

    @Step("Заполнение пароля")
    public void fillPasswordFieldOnLoginPage(String text) {
        passwordFieldOnLoginPage.shouldBe(visible);
        passwordFieldOnLoginPage.sendKeys(text);
    }

    @Step("Нажатие кнопки войти")
    public void pressLoginButtonOnLoginPage() {
        loginButton.shouldBe(enabled);
        loginButton.click();
    }

    @Step("Нажатие кнопки зарегистрироваться")
    public void pressRegisterButtonOnLoginPage() {
        registerButtonOnLoginPage.shouldBe(enabled);
        registerButtonOnLoginPage.click();
    }

    @Step("Нажатие кнопки восставновить пароль")
    public void pressRecoveryPasswordOnLoginPage() {
        recoveryPasswordOnLoginPage.click();
    }

    public SelenideElement getLoginButton() {
        return loginButton;
    }
}