package pages.mobile;

import base.driver.Browser;
import base.page.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class EmailLoginPage extends BasePage {


    private static final String MARKER_LOCATOR = "//*[@resource-id=\"com.samsung.android.email.provider:id/account_password\"]";

    private static final String TXB_EMAIL_LOCATOR = "com.samsung.android.email.provider:id/account_email";
    private static final String TXB_PWD_LOCATOR = "com.samsung.android.email.provider:id/account_password";
    private static final String BTN_SUBMIT_LOCATOR = "com.samsung.android.email.provider:id/next_btn";

    public EmailLoginPage(String name) {
        super(name);
    }

    @Override
    public By getMarkerLocator() {
        return new By.ByXPath(MARKER_LOCATOR);
    }

    public void login(String email, String password) {
        AndroidDriver driver = (AndroidDriver) Browser.getInstance().getDriver();
        MobileElement txbEmail = (MobileElement) driver.findElementById(TXB_EMAIL_LOCATOR);
        MobileElement txbPassword = (MobileElement) driver.findElementById(TXB_PWD_LOCATOR);
       // MobileElement btnNext = (MobileElement) driver.findElementById(BTN_SUBMIT_LOCATOR);

        txbEmail.sendKeys(email);
       // txbPassword.sendKeys(password);
     //   btnNext.click();
        txbPassword.click();



    }
}
