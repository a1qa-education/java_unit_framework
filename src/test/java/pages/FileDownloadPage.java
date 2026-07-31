package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class FileDownloadPage extends Form {
    private static final String NAME = "File Download";

    public FileDownloadPage() {
        super(By.xpath("//h1[text()='File Download']"), NAME);
    }

    public void clickFileDownloadLink(String name) {
        getFileDownloadLink(name).click();
    }

    public boolean isFileDownloadLinkDisplayed(String name) {
        // todo: implement
        return false;
    }

    private ILink getFileDownloadLink(String name) {
        // todo: implement
        return null;
    }
    public String getLeftFrameText() {
        AqualityServices.getBrowser().getDriver().switchTo().frame("frame-top");
        AqualityServices.getBrowser().getDriver().switchTo().frame("frame-left");
        String text = AqualityServices.getBrowser().getDriver()
                .findElement(By.tagName("body"))
                .getText();
        AqualityServices.getBrowser().getDriver().switchTo().defaultContent();
        return text;
    }
}
