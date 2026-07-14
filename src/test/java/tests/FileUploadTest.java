package tests;

import constants.MainPageNavigation;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import pages.UploadedFilePage;
import utils.JsonUtils;
import utils.TestDataReader;

import java.io.File;

public class FileUploadTest extends BaseTest {
    private FileUploadPage fileUploadPage = new FileUploadPage();

    private UploadedFilePage uploadedFilePage = new UploadedFilePage();


    private final String fileName = TestDataReader.getFileData().getUploadFile();
    private final String filePath = TestDataReader.TEST_DATA_PATH + fileName;

    @Test
    public void fileUploadTest() {
        // todo: add test
        mainPage.clickNavigationLink(MainPageNavigation.FILE_UPLOAD);
        fileUploadPage.uploadFile(new File(filePath).getAbsolutePath());
        fileUploadPage.clicSubmitBtn();
        Assert.assertEquals(uploadedFilePage.
                getUploadFileName(), fileName, "File name is not correct or missed");
    }
}
