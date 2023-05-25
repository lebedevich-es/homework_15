package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        String browserName = System.getProperty("browser_name", "chrome");
        String browserVersion = System.getProperty("browser_version", "100");
        String browserSize = System.getProperty("browser_size", "1920x1080");
        String remoteURL = System.getProperty("selenide_remote");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (remoteURL != null) {
            Configuration.remote = remoteURL;
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://spribe.co";
        Configuration.browser = browserName;
        Configuration.browserSize = browserSize;
        Configuration.browserVersion = browserVersion;
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();

        if (System.getProperty("selenide_remote") != null) {
            Attach.addVideo();
        }
    }
}
