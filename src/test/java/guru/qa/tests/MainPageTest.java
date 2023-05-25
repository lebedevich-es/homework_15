package guru.qa.tests;

import guru.qa.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.qameta.allure.Allure.step;

@Tag("main")
public class MainPageTest extends TestBase {

    MainPage mainPage = new MainPage();
    private final static String
            TITLE_TEXT = "Innovative Casino Games",
            OUR_GAMES_TITLE = "Our Games";

    @Test
    @DisplayName("The title on the 'Main' page is correct")
    void mainPageTitleTest() {
        step("Open the Main page", () -> {
            mainPage.openPage();
        });

        step("Check if this text exists:" + TITLE_TEXT, () -> {
            mainPage.checkPrimaryTitle(TITLE_TEXT);
        });
    }

    @CsvSource(value = {
            "Games, Our Games",
            "Engagement, Engagement Tools",
            "News, Company News",
            "About, About Us",
            "Vacancies, Open Vacancies",
            "Contact, Contact Us"
    })
    @DisplayName("Check items in the navigation menu: ")
    @ParameterizedTest(name = "Clicking item {0} in the navigation menu opens correct page: {1}")
    void navigationMenuTest(String item, String expectedResult) {
        step("Open the Main page", () -> {
            mainPage.openPage();
        });

        step("Check items in the navigation menu", () -> {
            mainPage.clickByItemInNavigationMenu(item)
                    .checkTitleOfPage(expectedResult);
        });
    }

    @Test
    @DisplayName("'Our Games' page opens by clicking the 'Explore our Games' button")
    void openOurGamesPageByClickingPrimaryButtonTest() {
        step("Open the Main page", () -> {
            mainPage.openPage();
        });

        step("Click on the 'Explore our Games' button", () -> {
            mainPage.clickPrimaryButton();
        });

        step("Check that 'Our Games' page opens", () -> {
            mainPage.checkTitleOfPage(OUR_GAMES_TITLE);
        });
    }
}
