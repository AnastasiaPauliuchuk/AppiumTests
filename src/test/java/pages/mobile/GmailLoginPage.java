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
public class GmailLoginPage extends BasePage {

    private static final String BTN_NEXT_LOCATOR = "//*[@resource-id=\"next\"]";



    public GmailLoginPage (String name) {
        super(name);

    }



    @Override
    public By getMarkerLocator() {

        return new By.ByXPath(BTN_NEXT_LOCATOR);
    }

    public void enterEmail(String username) {

        AndroidDriver driver = (AndroidDriver) Browser.getInstance().getDriver();
        WebElement btnNext =  driver.findElement(By.xpath(BTN_NEXT_LOCATOR));
        btnNext.click();
    }



}
