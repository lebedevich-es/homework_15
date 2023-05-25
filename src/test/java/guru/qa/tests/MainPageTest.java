package guru.qa.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPageTest extends TestBase {

    private final static String TITLE_TEXT = "Innovative Casino Games";
    private final static String OUR_GAMES_TITLE = "Our Games";

    @BeforeAll
    static void declineCookies() {
        open("/welcome");
        $(".btn-light.align-self-stretch").click();
    }

    @Test
    @Tag("main")
    @DisplayName("The title on the 'Main' page is correct")
    void mainPageTitleTest() {
        step("Open the Main page", () -> {
            open("/welcome");
        });

        step("Check if this text exists:" + TITLE_TEXT, () -> {
            $("body h1.title").shouldHave(text(TITLE_TEXT));
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
    @Tag("main")
    @DisplayName("The correct page opens by clicking items in the navigation menu")
    @ParameterizedTest(name = "For item {0} opens correct page: {1}")
    void navigationMenuTest(String item, String expectedResult) {
        step("Open the Main page", () -> {
            open("/welcome");
        });

        step("Check items in the navigation menu", () -> {
            $$("li[class='nav-item']").findBy(text(item)).click();
            $("[class='display']").shouldHave(text(expectedResult));
        });
    }

    @Test
    @Tag("main")
    @DisplayName("'Our Games' page opens by clicking the 'Explore our Games' button")
    void openOurGamesPageByClickingPrimaryButtonTest() {
        step("Open the Main page", () -> {
            open("/welcome");
        });

        step("Click on the 'Explore our Games' button", () -> {
            $("a.btn-primary").click();
        });

        step("Check that 'Our Games' page opens", () -> {
            $("[class='display']").shouldHave(text(OUR_GAMES_TITLE));
        });
    }
}
