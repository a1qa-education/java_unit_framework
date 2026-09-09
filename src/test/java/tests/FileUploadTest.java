package tests;

import org.testng.annotations.Test;
import utils.TestDataReader;

public class FileUploadTest extends BaseTest {
    private final String fileName = TestDataReader.getFileData().getUploadFile();
    private final String filePath = TestDataReader.TEST_DATA_PATH + fileName;

    @Test
    public void fileUploadTest() {
        // todo: add test
    }
}
