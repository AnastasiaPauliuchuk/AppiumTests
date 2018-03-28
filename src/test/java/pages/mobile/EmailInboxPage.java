package pages.mobile;

import base.driver.Browser;
import base.page.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;

/**
 * @author Anastasia Pauliuchuk
 *         created:  3/28/2018.
 */
public class EmailInboxPage extends BasePage {

    private static final String BTN_NEW_LOCATOR = "com.samsung.android.email.provider:id/button_icon";
    private static final String LAST_MSG_LOCATOR = "com.samsung.android.email.provider:id/message_list_item_canvas";

    public EmailInboxPage(String name) {
        super(name);
    }

    @Override
    public By getMarkerLocator() {
        return new By.ById(BTN_NEW_LOCATOR);
    }

    public void openCompose() {

        AndroidDriver driver = (AndroidDriver) Browser.getInstance().getDriver();
        MobileElement btnNew = (MobileElement) driver.findElementById(BTN_NEW_LOCATOR);
        btnNew.click();
    }

    public void refresh() {
        AndroidDriver driver = (AndroidDriver) Browser.getInstance().getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        MobileElement element = (MobileElement) driver.findElementById(LAST_MSG_LOCATOR);
        scrollObject.put("element", ((RemoteWebElement) element).getId());
        js.executeScript("mobile: swipe", scrollObject);
    }

    public void goLastMessage() {
        AndroidDriver driver = (AndroidDriver) Browser.getInstance().getDriver();
        MobileElement element = (MobileElement) driver.findElementById(LAST_MSG_LOCATOR);
        element.click();

    }
}
