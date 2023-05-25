package guru.qa.tests;

import guru.qa.pages.OurGamesPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("games")
public class OurGamesPageTest extends TestBase {

    OurGamesPage ourGamesPage = new OurGamesPage();

    @BeforeAll
    static void declineCookies() {
        open("/games");
        $(".btn-light.align-self-stretch").click();
    }

    @Test
    @DisplayName("'Turbo Games' and 'Poker & Skill Games' section are present on the 'Our Games' page")
    void gameSectionsTitleTest() {
        step("Open the Our Games page", () -> {
            ourGamesPage.openPage();
        });

        step("Check games sections", () -> {
            ourGamesPage.checkGameSectionTitles();
        });
    }

    @ValueSource(strings = {
            "Aviator",
            "Mines",
            "Dice",
            "Mini Roulette",
            "HiLo",
            "Plinko",
            "Goal",
            "Keno",
            "HotLine"
    })
    @ParameterizedTest(name = "By clicking on the {0} game card opens correct page")
    @DisplayName("Check 'Turbo Games' section: ")
    void turboGamesSectionTest(String game) {
        step("Open the 'Our Games' page", () -> {
            ourGamesPage.openPage();
        });

        step("Click on the game card", () -> {
            ourGamesPage.clickByGameCard(game);
        });

        step("Check that correct page opens", () -> {
            ourGamesPage.checkTitleOfPage(game);
        });
    }

    @Test
    @DisplayName("The 'Responsible Gaming' modal opens by clicking 'Demo' button")
    void openingWarningModalTest() {
        step("Open the 'Our Games' page", () -> {
            ourGamesPage.openPage();
        });

        step("Hover over the card", () -> {
            ourGamesPage.hoverOverGameCard();
        });

        step("Click on the 'Demo' button for card", () -> {
            ourGamesPage.clickByDemoButton();
        });

        step("Check that 'Responsible Gaming' modal opens", () -> {
            ourGamesPage.checkResponsibleGamingModalTitle();
        });
    }
}
