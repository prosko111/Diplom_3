package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {

    public static String url = "https://stellarburgers.nomoreparties.site";
    public static String name = RandomStringUtils.randomAlphabetic(10);
    public static String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
    public static String password = RandomStringUtils.randomAlphabetic(8);
    public static String shortPassword = RandomStringUtils.randomAlphabetic(5);

    // Поля Имя и Email
    @FindBy(how = How.XPATH, using = "//input[@class=\"text input__textfield text_type_main-default\"]")
    private ElementsCollection nameAndEmailFields;

    // Поле ввода пароля
    @FindBy(how = How.XPATH, using = "//input[@class=\"text input__textfield text_type_main-default\" and @name=\"Пароль\"]")
    private SelenideElement passwordFieldOnRegistrationPage;

    // Поле ошибки
    @FindBy(how = How.XPATH, using = "//p[@class=\"input__error text_type_main-default\"]")
    private SelenideElement errorFieldOnRegistrationPage;

    // Кнопка зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButtonOnRegistrationPage;

    // Кнопка логин
    @FindBy(how = How.XPATH, using = "//a[text()=\"Войти\"]")
    private SelenideElement loginButtonOnRegistrationPage;

    @Step("Заполнение имени")
    public void fillNameFieldOnRegisterPage(String text) {
        nameAndEmailFields.get(0).shouldBe(Condition.visible);
        nameAndEmailFields.get(0).sendKeys(text);
    }

    @Step("Заполнение почты")
    public void fillEmailFieldOnRegisterPage(String text) {
        nameAndEmailFields.get(1).shouldBe(Condition.visible);
        nameAndEmailFields.get(1).sendKeys(text);
    }

    @Step("Заполнение пароля")
    public void fillPasswordFieldOnRegisterPage(String text) {
        passwordFieldOnRegistrationPage.shouldBe(Condition.enabled);
        passwordFieldOnRegistrationPage.sendKeys(text);
    }

    @Step("Нажатие кнопки регистрации")
    public void pressRegisterButtonOnRegisterPage() {
        registerButtonOnRegistrationPage.shouldBe(Condition.enabled);
        registerButtonOnRegistrationPage.click();
    }

    @Step("Нажатие кнопки логина")
    public void pressLoginButtonOnRegisterPage() {
        loginButtonOnRegistrationPage.shouldBe(Condition.enabled);
        loginButtonOnRegistrationPage.click();
    }

    public SelenideElement getErrorFieldOnRegistrationPage() {
        return errorFieldOnRegistrationPage;
    }
}