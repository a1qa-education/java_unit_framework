package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.AlbertEinsteinPage;
import pages.PdfDownloadPage;
import pages.WikipediaHomePage;
import utils.FileUtils;

import java.io.File;
import java.nio.file.Paths;

public class WikipediaPdfDownloadTest extends BaseTest {

    private File downloadedFile = null;

    @Test
    public void verifyPdfDownloadTest() {

        WikipediaHomePage homePage = new WikipediaHomePage();

        Assert.assertTrue(homePage.state().waitForDisplayed(), "Wikipedia main page is not displayed");

        homePage.selectLanguage("en");

        homePage.search("Albert Einstein");

        AlbertEinsteinPage albertEinsteinPage = new AlbertEinsteinPage();
        Assert.assertTrue(albertEinsteinPage.state().waitForDisplayed());

        albertEinsteinPage.openDownloadPdfPage();

        PdfDownloadPage pdfPage = new PdfDownloadPage();

        String pdfName = pdfPage.getPdfName();

        pdfPage.downloadButton.state().waitForDisplayed();
        pdfPage.downloadButton.click();

        String downloadFilePath = Paths.get("./Downloads", pdfName).toString();
        downloadedFile = new File(downloadFilePath);

        Assert.assertTrue(FileUtils.isFileExist(downloadedFile));
    }

    @AfterMethod
    public void deleteFile(){
        FileUtils.deleteFileIfExist(downloadedFile);
    }
}