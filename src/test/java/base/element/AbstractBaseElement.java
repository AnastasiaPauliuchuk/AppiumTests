package base.element;

import base.driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author Anastasia Pauliuchuk
 *         created:  1/8/2018.
 */
public abstract class AbstractBaseElement extends BaseElement {

    public AbstractBaseElement(WebElement wrappedElement) {

        this.wrappedElement = wrappedElement;

    }

    public AbstractBaseElement(By by) {

        WebElement el = Browser.getInstance().getDriver().findElement(by);
        this.wrappedElement = el;
    }

    public void init() {
    }


}
