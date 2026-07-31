package pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

public class DataTablesPage extends Form {
    private static final String NAME = "Data Tables";
    private final By due = By.xpath("//*[@id='table1']//td[4]");

    public DataTablesPage() {
        super(By.xpath("//h1[text()='Basic Auth']"), NAME);
    }

    public List<String> getFirstDueList() {
        // todo: implement
        return null;
    }

    private List<ILabel> getFirstDueLblList() {
        return getElementFactory().findElements(due, "due", ElementType.LABEL);
    }
}
