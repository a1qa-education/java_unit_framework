package pages;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class WikipediaHomePage extends Form {

    private final ITextBox searchTextbox = getElementFactory().getTextBox(By.cssSelector("#search-input input#searchInput"), "Search");

    private final IButton searchButton = getElementFactory().getButton(
            By.xpath("//button[@class='pure-button pure-button-primary-progressive']"),
            "Search Button");

    public WikipediaHomePage() {
        super(By.id("www-wikipedia-org"), "Wikipedia Home");
    }

    public void selectLanguage(String languageCode) {
        getElementFactory().getComboBox(By.id("searchLanguage"), "Language Dropdown", ElementState.EXISTS_IN_ANY_STATE)
                .selectByValue(languageCode);
    }

    public void search(String value) {
        searchTextbox.clearAndType(value);
        searchButton.click();
    }
}
