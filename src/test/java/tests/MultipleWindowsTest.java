package tests;

import constants.MainPageNavigation;
import pages.multiple_windows.MultipleWindowsPage;
import pages.multiple_windows.NewWindowPage;
import org.testng.annotations.Test;

public class MultipleWindowsTest extends BaseTest {
    private MultipleWindowsPage multipleWindowsPage = new MultipleWindowsPage();
    private NewWindowPage newWindowPage = new NewWindowPage();

    public static final String NEW_WINDOW_TEXT = "New Window";

    @Test
    public void shouldOpenNewWindow() {
        mainPage.clickNavigationLink(MainPageNavigation.MULTIPLE_WINDOWS);

        multipleWindowsPage.clickHere();

        // todo: Switch to new window

        // todo: Implement a check for the text in the new window.

    }
}
