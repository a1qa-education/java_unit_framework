package pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import constants.MainPageNavigation;
import org.openqa.selenium.By;

public class MainPage extends Form {

    public MainPage() {
        super(By.xpath("//h1[text()='Welcome to the-internet']"), "Main Page");
    }

    private ILink getNavigationLink(MainPageNavigation navigation) {
        return getElementFactory().getLink(By.linkText(navigation.label), navigation.label);
    }

    public void clickNavigationLink(MainPageNavigation navigation) {
        getNavigationLink(navigation).click();
    }
}
