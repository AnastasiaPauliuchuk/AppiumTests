package pages.mobile;

import base.driver.Browser;
import base.page.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * @author Anastasia Pauliuchuk
 *         created:  3/28/2018.
 */
public class EmailNewMsgPage extends BasePage {


    private static final String BTN_SEND_LOCATOR = "com.samsung.android.email.provider:id/menu_composer_send";
    private static final String TB_EMAIL_LOCATOR = "com.samsung.android.email.provider:id/recipient_to_edit_addresstext";
    private static final String TB_MSG_LOCATOR = "com.samsung.android.email.provider:id/composer_html_body_layout";

    public EmailNewMsgPage(String name) {
        super(name);
    }

    @Override
    public By getMarkerLocator() {
        return new By.ById(BTN_SEND_LOCATOR);
    }

    public void sendNewMessage(String to, String text) {

        AndroidDriver driver = (AndroidDriver) Browser.getInstance().getDriver();
        MobileElement btnSend = (MobileElement) driver.findElementById(BTN_SEND_LOCATOR);
        MobileElement tbEmail = (MobileElement) driver.findElementById(TB_EMAIL_LOCATOR);


        tbEmail.sendKeys(to);
        MobileElement tbText = (MobileElement) driver.findElementById(TB_MSG_LOCATOR);
        tbText.click();
        tbText.sendKeys(text);
        btnSend.click();


    }
}
