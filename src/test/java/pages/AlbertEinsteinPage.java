package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class AlbertEinsteinPage extends Form {

    private final IButton toolsButton = getElementFactory().getButton(By.cssSelector("div[id='vector-page-tools-dropdown']"), "Tools");

    public AlbertEinsteinPage() {
        super(By.xpath("//h1[@id='firstHeading']/span//span[text()='Albert Einstein']"), "Albert Einstein Page");
    }

    public void openDownloadPdfPage() {
        toolsButton.click();
        getElementFactory().getButton(By.id("coll-download-as-rl"), "Download as PDF").click();
    }
}
