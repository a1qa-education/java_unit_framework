package tests;

import constants.MainPageNavigation;
import models.EnvData;
import models.UserData;
import org.testng.Assert;
import pages.BasicAuthPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.EnvDataReader;
import utils.TestDataReader;

public class BasicAuthTest extends BaseTest {

    private final BasicAuthPage basicAuthPage = new BasicAuthPage();

    @BeforeMethod
    public void auth() {
        // todo: add basic auth
        UserData userData = TestDataReader.getUserData();
        EnvData env = EnvDataReader.getEnvData();

        browser.network().addBasicAuthentication(env.getDomain(), userData.getUsername(), userData.getPassword());

    }

    @Test
    public void basicAuthTest() {
        // todo: add test

        mainPage.clickNavigationLink(MainPageNavigation.BASIC_AUTH);
        Assert.assertTrue(basicAuthPage.isSuccessMsgDisplayed(),"Success message was not displayed");
    }
}
