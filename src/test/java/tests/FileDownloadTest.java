package tests;

import pages.FileDownloadPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
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
    }

    @AfterMethod
    public void deleteFile() {
        // todo: add delete file
    }
}
