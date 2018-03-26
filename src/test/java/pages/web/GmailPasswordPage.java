package pages.web;

import base.page.BasePage;
import elements.web.AndroidTextBox;
import elements.web.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class GmailPasswordPage extends BasePage {

    private static final String MARKER_LOCATOR = "//input[@name =\"password\"]";

    @FindBy(name = "password")
    AndroidTextBox tbxPassword;

    @FindBy(id = "passwordNext")
    Button btnSubmit;

    public GmailPasswordPage(String name) {
        super(name);
    }

    @Override
    public By getMarkerLocator() {
        return new By.ByXPath(MARKER_LOCATOR);
    }

    public void authorize(String password) {
        tbxPassword.type(password);
        btnSubmit.click();

    }
}
