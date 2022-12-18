package pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;

public class PersonalAccountPage {

    public static String url = "https://stellarburgers.nomoreparties.site";
    public static String urlRegistration = "https://stellarburgers.nomoreparties.site/register";
    public static String urlLogin = "https://stellarburgers.nomoreparties.site/login";

    public static String name = RandomStringUtils.randomAlphabetic(10);
    public static String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
    public static String password = RandomStringUtils.randomAlphabetic(10);

    // Кнопка выхода
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement exitButtonOnPersonalWebPage;

    // Поле с текстом "В этом разделе вы можете изменить свои персональные данные"
    @FindBy(how = How.XPATH, using = "//p[@class=\"Account_text__fZAIn text text_type_main-default\"]")
    private SelenideElement textAboutProfile;

    // Кнопка "конструктор"
    @FindBy(how = How.XPATH, using = "//p[contains(text(), \"Конструктор\")]")
    private SelenideElement constructorButton;

    // Логотип
    @FindBy(how = How.XPATH, using = "//div[@class=\"AppHeader_header__logo__2D0X2\"]")
    private SelenideElement logoButton;

    @Step("Клик по кнопке выхода")
    public void pressExitButtonOnPersonalAccountPage() {
        exitButtonOnPersonalWebPage.shouldBe(enabled);
        exitButtonOnPersonalWebPage.click();
    }

    @Step("Проверка текста \"В этом разделе вы можете изменить свои персональные данные\" ")
    public SelenideElement getTextAboutProfile() {
        return textAboutProfile;
    }

    @Step("Нажатие на кнопку 'Конструктор'")
    public void clickConstructorButton() {
        constructorButton.click();
    }

    @Step("Нажатие на кнопку логотип")
    public void clickLogoButton() {
        logoButton.click();
    }
}