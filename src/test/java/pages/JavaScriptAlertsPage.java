package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class JavaScriptAlertsPage extends Form {
    private static final String PAGE_NAME = "JavaScript Alerts";
    private final By CLICK_FOR_JS_ALERT_BUTTON = By.xpath("//button[@onclick='jsAlert()']");
    private final By SUCCESS_MESSAGE = By.xpath("//p[text()='You successfully clicked an alert']");
    private IButton clickForJsAlertBtn = getElementFactory().getButton(CLICK_FOR_JS_ALERT_BUTTON, "Click for JS alert");
    private ILabel successLbl = getElementFactory().getLabel(SUCCESS_MESSAGE, "Success");

    public JavaScriptAlertsPage() {
        super(By.xpath("//h1[text()='JavaScript Alerts']"), PAGE_NAME);
    }

    public void clickForJsAlertBtn() {
        clickForJsAlertBtn.click();
    }

    public boolean isSuccessLabelDisplayed() {
        return successLbl.state().isDisplayed();
    }
}
