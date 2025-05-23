package tests;

import aquality.selenium.browser.AqualityServices;
import pages.MainPage;
import utils.EnvDataReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public abstract class BaseTest {
    protected final MainPage mainPage = new MainPage();

    @BeforeMethod
    public void setup() {
        getBrowser().maximize();
        getBrowser().goTo(EnvDataReader.getEnvData().getHost());
    }

    @AfterMethod
    public void teardown() {
        if (AqualityServices.isBrowserStarted()) {
            getBrowser().quit();
        }
    }
}
