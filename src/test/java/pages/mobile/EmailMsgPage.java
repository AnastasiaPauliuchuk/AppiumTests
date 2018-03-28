package pages.mobile;

import base.driver.Browser;
import base.page.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * @author Anastasia Pauliuchuk
 *         created:  3/28/2018.
 */
public class EmailMsgPage extends BasePage {

    private static final String FROM_LOCATOR = "com.samsung.android.email.provider:id/from_name";
    private static final String MSG_LOCATOR = "MessageWebViewDiv";

    public EmailMsgPage(String name) {
        super(name);
    }

    @Override
    public By getMarkerLocator() {
        return new By.ById(FROM_LOCATOR);
    }

    public void assertMessageBody(String expectedSender, String expectedText) {
        AndroidDriver driver = (AndroidDriver) Browser.getInstance().getDriver();
        MobileElement lblFrom = (MobileElement) driver.findElementById(FROM_LOCATOR);
        assertinfo(lblFrom.getText(), expectedSender);

        Assert.assertTrue(lblFrom.getText().contains(expectedText));

        MobileElement lblText = (MobileElement) driver.findElementById(FROM_LOCATOR);
        assertinfo(lblText.getText(), expectedText);

        Assert.assertTrue(lblText.getText().contains(expectedText));

    }
}
