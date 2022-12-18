package pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PasswordRecoveryPage {

    // Кнопка логина
    @FindBy(how = How.XPATH, using = "//a[text()=\"Войти\"]")
    private SelenideElement loginButtonOnPasswordRecoveryPage;

    @Step("Клик на кнопку логина")
    public void pressLoginButtonOnPasswordRecoveryPage(){
        loginButtonOnPasswordRecoveryPage.click();
    }
}