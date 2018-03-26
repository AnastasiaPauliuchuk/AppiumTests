package elements.web;

import base.driver.Browser;
import base.element.AbstractBaseElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AndroidTextBox extends AbstractBaseElement {

    public AndroidTextBox(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public AndroidTextBox(By by) {
        super(by);
    }


    @Override
    public String getElementType() {
        return "TextBox";
    }


    public void type(String s) {
        info(String.format("type '%s'", s));
        AndroidDriver driver = (AndroidDriver) Browser.getInstance().getDriver();
        wrappedElement.click();
        driver.getKeyboard().sendKeys(s);
        Browser.getInstance().getDriver().hideKeyboard();
    }

    public String getText() {
        return wrappedElement.getText();
    }
}
