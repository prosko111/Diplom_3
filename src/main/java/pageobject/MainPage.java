package pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

public class MainPage {

    public static String url = "https://stellarburgers.nomoreparties.site/";

    // Кнопка входа в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginButtonOnMainPage;

    // Кнопка оформить заказ
    @FindBy(how = How.XPATH, using = "//button[text()=\"Оформить заказ\"]")
    private SelenideElement orderButton;

    // Кнопка личный кабинет
    @FindBy(how = How.LINK_TEXT, using = "Личный Кабинет")
    private SelenideElement personalAccountButton;

    // Надпись начинки
    @FindBy(xpath = "//div[@class=\"tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect\"]/span[text()=\"Начинки\"]")
    private SelenideElement fillingsTab;

    // Кнопка вкладки начинки
    @FindBy(xpath = "//span[@class=\"text text_type_main-default\" and text()=\"Начинки\"]")
    private SelenideElement fillingsButton;

    // Надпись соусы
    @FindBy(xpath = "//div[@class=\"tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect\"]/span[text()=\"Соусы\"]")
    private SelenideElement saucesTab;

    // Кнопка вкладки соусы
    @FindBy(xpath = "//span[@class=\"text text_type_main-default\" and text()=\"Соусы\"]")
    private SelenideElement saucesButton;

    // Надпись булки
    @FindBy(xpath = "//div[@class=\"tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect\"]/span[text()=\"Булки\"]")
    private SelenideElement bunsTab;

    // Кнопка вкладки булки
    @FindBy(xpath = "//span[@class=\"text text_type_main-default\" and text()=\"Булки\"]")
    private SelenideElement bunsButton;

    @Step("Клик по разделу 'Начинки'")
    public void clickFilling() {
        fillingsButton.shouldBe(exist).click();
    }

    @Step("Клик по разделу 'Соусы'")
    public void clickSauces() {
        saucesButton.shouldBe(exist).click();
    }

    @Step("Клик по разделу 'Булки'")
    public void clickBuns() {
        bunsButton.shouldBe(visible).click();
    }

    @Step("Нажатие кнопки входа")
    public void pressLoginButtonOnMainPage() {
        loginButtonOnMainPage.click();
    }

    @Step("Нажатие кнопки личный кабинет")
    public void pressPersonalAccountButton() {
        personalAccountButton.click();
    }

    @Step("Проверка появления кнопки 'создать заказ' на главной странице")
    public SelenideElement getOrderButton() {
        return orderButton;
    }

    public SelenideElement getFillingsTab() {
        return fillingsTab;
    }

    public SelenideElement getSaucesTab() {
        return saucesTab;
    }

    public SelenideElement getBunsTab() {
        return bunsTab;
    }


}