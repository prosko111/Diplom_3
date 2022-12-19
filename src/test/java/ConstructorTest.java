import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pageobject.MainPage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static pageobject.MainPage.url;

public class ConstructorTest {

    @Before
    public void setUp() {
        Configuration.startMaximized = true;
        open(url, MainPage.class);
    }

    @Test
    @DisplayName("Переход в раздел 'Начинки'")
    public void checkClickFillingTest() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickFilling();
        mainPage.getFillingsTab().shouldHave(exactText("Начинки"));
    }

    @Test
    @DisplayName("Переход в раздел 'Соусы'")
    public void checkClickSauceTest() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickSauces();
        mainPage.getSaucesTab().shouldHave(exactText("Соусы"));
    }

    @Test
    @DisplayName("Переход в раздел 'Булки'")
    public void checkClickBunTest() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickSauces();
        mainPage.clickBuns();
        mainPage.getBunsTab().shouldHave(exactText("Булки"));
    }
}