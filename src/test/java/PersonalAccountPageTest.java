import io.qameta.allure.junit4.DisplayName;
import pageobject.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static pageobject.LoginPage.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PersonalAccountPageTest {

    PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);

    @BeforeClass
    public static void setUpAll(){
        Configuration.startMaximized = true;

        RegisterPage registerPage = open(urlRegistration, RegisterPage.class);
        registerPage.fillNameFieldOnRegisterPage(name);
        registerPage.fillEmailFieldOnRegisterPage(email);
        registerPage.fillPasswordFieldOnRegisterPage(password);
        registerPage.pressRegisterButtonOnRegisterPage();
    }

    @Before
    public void setUp(){
        LoginPage loginPage = open(urlLogin, LoginPage.class);
        loginPage.fillEmailFieldOnLoginPage(email);
        loginPage.fillPasswordFieldOnLoginPage(password);
        loginPage.pressLoginButtonOnLoginPage();
    }

    @After
    public void tearDown() {
        webdriver().driver().close();
    }

    @Test
    @DisplayName("Переход в личный кабинет по клику на кнопку 'Личный кабинет'")
    public void checkRedirectFromMainPageToPersonalAccountPageByPersonalAccountButton(){
        MainPage mainPage = page(MainPage.class);
        mainPage.pressPersonalAccountButton();

        personalAccountPage.getTextAboutProfile().shouldHave(Condition.exactText("В этом разделе вы можете изменить свои персональные данные"));
    }

    @Test
    @DisplayName("Переход в конструктор по клику на кнопку 'Конструктор'")
    public void checkRedirectFromPersonalAccountToConstructorByConstructorButton() {
        personalAccountPage.clickConstructorButton();

        MainPage mainPage = page(MainPage.class);
        mainPage.getOrderButton().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Переход в конструктор по клику на логотип")
    public void checkRedirectFromPersonalAccountToConstructorByLogoButton() {
        personalAccountPage.clickLogoButton();

        MainPage mainPage = page(MainPage.class);
        mainPage.getOrderButton().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Выход из аккаунта в личном кабинете")
    public void userCanExitFromPersonalWebPage(){
        MainPage mainPage = page(MainPage.class);
        mainPage.pressPersonalAccountButton();

        personalAccountPage.pressExitButtonOnPersonalAccountPage();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.getLoginButton().shouldBe(visible);
    }

}