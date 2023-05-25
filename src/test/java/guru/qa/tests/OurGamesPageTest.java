package guru.qa.tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class OurGamesPageTest extends TestBase {

    private final static String TURBO_GAMES_TITLE = "Turbo Games";
    private final static String POKER_AND_SKILL_GAMES_TITLE = "Poker & Skill Games";

    @BeforeAll
    static void declineCookies() {
        open("/games");
        $(".btn-light.align-self-stretch").click();
    }

    @Test
    @Tag("games")
    @DisplayName("'Turbo Games' and 'Poker & Skill Games' section are present on the 'Our Games' page")
    void gameSectionsTitleTest() {
        step("Open the Our Games page", () -> {
            open("/games");
        });

        step("Check games sections", () -> {
            $("#turbo").shouldHave(text(TURBO_GAMES_TITLE));
            $("#p2p").shouldHave(text(POKER_AND_SKILL_GAMES_TITLE));
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
    @Tag("games")
    @DisplayName("The correct page opens by clicking items in the 'Turbo Games' section")
    void turboGamesSectionTest(String game) {
        step("Open the 'Our Games' page", () -> {
            open("/games");
        });

        step("Click on the game card", () -> {
            $$("app-game-card").findBy(text(game)).click();
        });

        step("Check that correct page opens", () -> {
            $("[class='display']").shouldHave(text(game));
        });
    }

    @Test
    @Tag("games")
    @DisplayName("The 'Responsible Gaming' modal opens by clicking 'Demo' button")
    void openingWarningModalTest() {
        SelenideElement card = $$("app-game-card").findBy(text("Aviator"));

        step("Open the 'Our Games' page", () -> {
            open("/games");
        });

        step("Hover over the card", () -> {
            card.hover();
        });

        step("Click on the 'Demo' button for card", () -> {
            card.$(".demo").click();
        });

        step("Check that 'Responsible Gaming' modal opens", () -> {
            $(".modal-title").shouldHave(text("Responsible Gaming"));
        });
    }
}
