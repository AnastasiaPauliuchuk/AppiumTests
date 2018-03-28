package pages.mobile;

import base.driver.Browser;
import base.page.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author Anastasia Pauliuchuk
 *         created:  3/28/2018.
 */
public class GmailPasswordPage extends BasePage {

    private static final String BTN_NEXT_LOCATOR = "//*[@resource-id=\"signIn\"]";
    private static final String TB_PWD_LOCATOR = "//*[@resource-id=\"Passwd\"]";
    public GmailPasswordPage (String name) {
        super(name);

    }

    @Override
    public By getMarkerLocator() {

        return new By.ByXPath(BTN_NEXT_LOCATOR);
    }

    public void enterPassword(String password) {
        AndroidDriver driver = (AndroidDriver) Browser.getInstance().getDriver();
        WebElement tbPwd =  driver.findElement(By.xpath(TB_PWD_LOCATOR));
        WebElement btnNext =  driver.findElement(By.xpath(BTN_NEXT_LOCATOR));
        tbPwd.sendKeys(password);
        btnNext.click();
    }
}
