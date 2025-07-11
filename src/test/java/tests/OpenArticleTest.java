package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchPage;

import static io.qameta.allure.Allure.step;

public class OpenArticleTest extends TestBase{

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    @Test
    void openArticleTest() {
        step("Открыть поиск и ввести 'Selenide'", () -> {
            mainPage.clickSearchWikipediaIcon();
            searchPage.searchPageSetValue("Selenide");

        });

        step("Открыть первую статью из результатов", () -> {
            searchPage.clickTheFirstResult();
        });

        step("Проверить найденный контен", () -> {
            searchPage.verifyContent();
        });
    }
}
