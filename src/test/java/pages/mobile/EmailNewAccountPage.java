package pages.mobile;

import base.driver.Browser;
import base.page.BasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class EmailNewAccountPage extends BasePage {

    private static final String MARKER_LOCATOR = "android.widget.LinearLayout";
    private static final String BTN_ADD_NEW_LOCATOR = "com.samsung.android.email.provider:id/add_new_account";

    public EmailNewAccountPage (String name) {
        super(name);
    }


    public void goNewAccount() {
        MobileElement btnAddAccount = (MobileElement)Browser.getInstance().getDriver().findElementById(BTN_ADD_NEW_LOCATOR);
        btnAddAccount.click();
    }

    @Override
    public By getMarkerLocator() {
        return new By.ByClassName(MARKER_LOCATOR);
    }

}
