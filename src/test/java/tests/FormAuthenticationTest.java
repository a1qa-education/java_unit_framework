package tests;

import constants.MainPageNavigation;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.TestDataReader;
import pages.SecureAreaPage;

public class FormAuthenticationTest extends BaseTest {

    private final LoginPage loginPage = new LoginPage();
    private final SecureAreaPage secureAreaPage = new SecureAreaPage();

    @Test
    public void formAuthenticationTest() {
        mainPage.clickNavigationLink(MainPageNavigation.FORM_AUTHENTICATION);
        Assert.assertTrue(loginPage.state().waitForDisplayed(), "Form Authentication page is not open");
        
        loginPage.login(TestDataReader.getUserData().getUsername(), TestDataReader.getUserData().getPassword());
        
        Assert.assertTrue(secureAreaPage.state().waitForDisplayed(), "Secure area page is not open");
        Assert.assertTrue(secureAreaPage.getSuccessMessageText().contains("You logged into a secure area!"), "Successful login message is not displayed");
        
        secureAreaPage.clickLogout();
        
        Assert.assertTrue(loginPage.state().waitForDisplayed(), "Form Authentication page is not open after logout");
    }
}
