package pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class BasicAuthPage extends Form {
    private static final String NAME = "Basic Auth";

    public BasicAuthPage() {
        super(By.xpath("//h1[text()='Basic Auth']"), NAME);
    }

    public boolean isSuccessMsgDisplayed() {
        // todo: implement
        return false;
    }
}
