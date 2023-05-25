package guru.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class OurGamesPage {

    private final static String
            GAMES_LINK = "/games",
            TURBO_GAMES_TITLE = "Turbo Games",
            POKER_AND_SKILL_GAMES_TITLE = "Poker & Skill Games",
            AVIATOR_GAME_TITLE = "Aviator",
            RESPONSIBLE_GAMING_TITLE = "Responsible Gaming";

    private ElementsCollection gameCards = $$("app-game-card");

    private SelenideElement
            turboSectionTitle = $("#turbo"),
            pokerAndSkillSectionTitle = $("#p2p"),
            pageTitle = $("[class='display']"),
            demoButton = gameCards.findBy(text("Aviator")).$(".demo"),
            responsibleGamingModalTitle = $(".modal-title");

    public OurGamesPage openPage() {
        open(GAMES_LINK);

        return this;
    }

    public OurGamesPage checkGameSectionTitles() {
        turboSectionTitle.shouldHave(text(TURBO_GAMES_TITLE));
        pokerAndSkillSectionTitle.shouldHave(text(POKER_AND_SKILL_GAMES_TITLE));

        return this;
    }

    public OurGamesPage clickByGameCard(String game) {
        gameCards.findBy(text(game)).click();

        return this;
    }

    public OurGamesPage checkTitleOfPage(String title) {
        pageTitle.shouldHave(text(title));

        return this;
    }

    public OurGamesPage hoverOverGameCard() {
        gameCards.findBy(text(AVIATOR_GAME_TITLE)).hover();

        return this;
    }

    public OurGamesPage clickByDemoButton() {
        demoButton.click();

        return this;
    }

    public OurGamesPage checkResponsibleGamingModalTitle() {
        responsibleGamingModalTitle.shouldHave(text(RESPONSIBLE_GAMING_TITLE));
        return this;
    }
}
