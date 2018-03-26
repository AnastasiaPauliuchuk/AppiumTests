package pages.web;

import base.page.BasePage;
import elements.web.AndroidTextBox;
import elements.web.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class GmailStartPage extends BasePage {

    private static final String MARKER_LOCATOR = "input#identifierId";

    @FindBy(id = "identifierId")
    AndroidTextBox tbxUsername;

    @FindBy(id = "identifierNext")
    Button btnSubmit;

    public GmailStartPage (String name) {
        super(name);
    }



    @Override
    public By getMarkerLocator() {
        return new By.ByCssSelector(MARKER_LOCATOR);
    }

    public void enterLogin(String username) {
        tbxUsername.type(username);
    }

    public void submitLogin() {

        btnSubmit.click();

    }

}
