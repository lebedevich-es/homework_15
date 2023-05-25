package guru.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final static String MAIN_LINK = "/welcome";
    private SelenideElement
            primaryTitle = $("body h1.title"),
            primaryButton = $("a.btn-primary"),
            pageTitle = $("[class='display']");

    private ElementsCollection itemsInNavigationMenu = $$("li[class='nav-item']");

    public MainPage openPage() {
        open(MAIN_LINK);

        return this;
    }

    public MainPage clickPrimaryButton() {
        primaryButton.click();

        return this;
    }

    public MainPage clickByItemInNavigationMenu(String item) {
        itemsInNavigationMenu.findBy(text(item)).click();

        return this;
    }

    public MainPage checkPrimaryTitle(String title) {
        primaryTitle.shouldHave(text(title));

        return this;
    }

    public MainPage checkTitleOfPage(String title) {
        pageTitle.shouldHave(text(title));

        return this;
    }
}
