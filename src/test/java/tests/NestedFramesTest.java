package tests;

import constants.MainPageNavigation;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.frames.FramesPage;
import pages.frames.NestedFramesPage;

public class NestedFramesTest extends BaseTest {
    private FramesPage framesPage = new FramesPage();
    private NestedFramesPage nestedFramesPage = new NestedFramesPage();


    public static final String LEFT_FRAME_TEXT = "LEFT";
    public static final String RIGHT_FRAME_TEXT = "RIGHT";

    @Test
    public void testNestedFrames() {
        mainPage.clickNavigationLink(MainPageNavigation.FRAMES);

        framesPage.clickNestedFramesLink();

        Assert.assertEquals(nestedFramesPage.getLeftFrameText(), LEFT_FRAME_TEXT, "Left Frame text is not correct");

        //todo: Implement a check for the text in the right frame.

    }
}
