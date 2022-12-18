import io.qameta.allure.junit4.DisplayName;
import pageobject.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import static pageobject.LoginPage.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest {

    @BeforeClass
    public static void setProperties() {
        Configuration.startMaximized = true;

        MainPage mainPage = open(urlRegistration, MainPage.class);
        mainPage.pressPersonalAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.pressRegisterButtonOnLoginPage();

        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.fillNameFieldOnRegisterPage(name);
        registerPage.fillEmailFieldOnRegisterPage(email);
        registerPage.fillPasswordFieldOnRegisterPage(password);
        registerPage.pressRegisterButtonOnRegisterPage();
    }

    @After
    public void tearDown() {
        webdriver().driver().close();
    }

    @Test
    @DisplayName("Авторизация на главной странице")
    public void loginFromMainPage() {
        LoginPage loginPage = open(urlLogin, LoginPage.class);
        loginPage.fillEmailFieldOnLoginPage(email);
        loginPage.fillPasswordFieldOnLoginPage(password);
        loginPage.pressLoginButtonOnLoginPage();

        MainPage mainPage = page(MainPage.class);
        mainPage.getOrderButton().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Авторизация  через кнопку 'Личный кабинет'")
    public void loginFromPersonalAccountPage() {
        MainPage mainPage = open(url, MainPage.class);
        mainPage.pressPersonalAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillEmailFieldOnLoginPage(email);
        loginPage.fillPasswordFieldOnLoginPage(password);
        loginPage.pressLoginButtonOnLoginPage();

        mainPage.getOrderButton().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Авторизация через кнопку в форме регистрации")
    public void loginFromRegisterPage() {
        RegisterPage registerPage = open(urlRegistration, RegisterPage.class);
        registerPage.pressLoginButtonOnRegisterPage();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillEmailFieldOnLoginPage(email);
        loginPage.fillPasswordFieldOnLoginPage(password);
        loginPage.pressLoginButtonOnLoginPage();

        MainPage mainPage = page(MainPage.class);
        mainPage.getOrderButton().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Авторизация через кнопку в форме восстановления пароля")
    public void loginFromPasswordRecoveryPage() {
        LoginPage loginPage = open(urlLogin, LoginPage.class);
        loginPage.pressRecoveryPasswordOnLoginPage();

        PasswordRecoveryPage passwordRecoveryPage = page(PasswordRecoveryPage.class);
        passwordRecoveryPage.pressLoginButtonOnPasswordRecoveryPage();

        loginPage.fillEmailFieldOnLoginPage(email);
        loginPage.fillPasswordFieldOnLoginPage(password);
        loginPage.pressLoginButtonOnLoginPage();

        MainPage mainPage = page(MainPage.class);
        mainPage.getOrderButton().shouldBe(Condition.visible);
    }
}