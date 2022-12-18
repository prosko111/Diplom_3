import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;
import com.codeborne.selenide.Condition;
import org.junit.Before;
import org.junit.Test;

import static pageobject.RegisterPage.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {

    RegisterPage registerPage = page(RegisterPage.class);
    LoginPage loginPage = page(LoginPage.class);

    @Before
    public void setUp(){
        MainPage mainPage = open(url, MainPage.class);
        mainPage.pressLoginButtonOnMainPage();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.pressRegisterButtonOnLoginPage();

        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.fillNameFieldOnRegisterPage(name);
        registerPage.fillEmailFieldOnRegisterPage(email);
    }

    @After
    public void tearDown() {
        webdriver().driver().close();
    }

    @Test
    @DisplayName("Регистрация")
    public void successfulRegistration(){
        registerPage.fillPasswordFieldOnRegisterPage(password);
        registerPage.pressRegisterButtonOnRegisterPage();

        loginPage.getLoginButton().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Регистрация с некорректным паролем")
    public void anErrorAppearsIfPasswordIsWrong(){
        registerPage.fillPasswordFieldOnRegisterPage(shortPassword);
        registerPage.pressRegisterButtonOnRegisterPage();
        registerPage.getErrorFieldOnRegistrationPage().shouldHave(Condition.exactText("Некорректный пароль"));
    }
}