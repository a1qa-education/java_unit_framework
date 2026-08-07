package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PdfDownloadPage extends Form {

    public final IButton downloadButton = getElementFactory().getButton(By.xpath("//button[@tabindex='0']"), "Download Button");

    public PdfDownloadPage() {
        super(By.xpath("//h1[contains(.,'Download as PDF')]"), "PDF Download Page");
    }

    public String getPdfName() {
        return getElementFactory().getLabel(By.xpath("//div[@class='mw-electronpdfservice-selection-label-desc']"), "PDF Name").getText();
    }
}
