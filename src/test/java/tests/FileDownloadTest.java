package tests;

import constants.MainPageNavigation;
import org.testng.Assert;
import pages.FileDownloadPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.FileUtils;
import utils.TestDataReader;

import java.io.File;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class FileDownloadTest extends BaseTest {
    private final FileDownloadPage fileDownloadPage = new FileDownloadPage();
    private final String fileName = TestDataReader.getFileData().getDownloadFile();
    private final String filePath = getBrowser().getDownloadDirectory() + File.separator + fileName;
    private final File downloadedFile = new File(filePath);

    @Test
    public void fileDownloadTest() {
        // todo: add test

        mainPage.clickNavigationLink(MainPageNavigation.FILE_DOWNLOAD);
        Assert.assertTrue(fileDownloadPage.isFileDownloadLinkDisplayed(fileName), "File is not displayed");
        fileDownloadPage.clickFileDownloadLink(fileName);
        Assert.assertTrue(FileUtils.isFileExist(downloadedFile), "File is not downloaded");


    }

    @AfterMethod
    public void deleteFile() {
        // todo: add delete file
        FileUtils.deleteFileIfExist(downloadedFile);
    }
}
