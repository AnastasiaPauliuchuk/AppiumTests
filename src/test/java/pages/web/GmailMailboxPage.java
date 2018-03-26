package pages.web;

import base.page.BasePage;
import elements.web.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * @author Anastasia Pauliuchuk
 * created:  1/24/2018.
 */
public class GmailMailboxPage extends BasePage {

    private static final String MARKER_LOCATOR = "//*[@aria-label=\"Compose\"]";


  /*  private final static String INBOX_BUTTON_LOCATOR =
            "//a[contains(@href,\"#inbox\")]";
    private final static String MSG_FROM_EMAIL_LOCATOR_TEMPLATE = "//div[contains(@class,\"yW\")]//span[@email=\"%s\"  and @class=\"zF\"]";
*/

    @FindBy(xpath = "//*[@aria-label=\"Compose\"]")
    private Button btnCompose;


    @FindBy(css = "input#composeto")
    private AndroidTextBox txbTo;


     @FindBy(css="div#cmcbody")
     private AndroidTextBox txbMessage;


     @FindBy(xpath = "(//div[@id=\"cvtbt\"]//div[@role=\"button\"]/div)[2]")
     private Button btnSend;

     @FindBy(xpath="//div[@aria-label=\"Refresh\"]")
     private Button btnRefresh;

     @FindBy(xpath="//div[@role=\"listitem\"]")
     private Button btnLastMsg;

      @FindBy(xpath = "//div[@class=\"Vi\"]//div[@dir=\"ltr\"]")
     private Label lblMessageBody;

    public GmailMailboxPage(String name) {
        super(name);
    }

    @Override
    public By getMarkerLocator() {
        return new By.ByXPath(MARKER_LOCATOR);
    }


    public void compose() {
        btnCompose.click();
    }

    public void sendNewMessage(String to, String text) {

       //btnCompose.click();
        if (txbTo.isElementVisible()) {
            txbTo.type(to);
            txbMessage.type(text);
            btnSend.click();
        }

    }

  /*  private boolean isSent() {

        return lnkViewSent.isElementVisible();

    }
*/
    public void openInboxAfterMsgSent() {
       btnRefresh.click();

    }


 /*   public void assertMessageExists(String email) {
        checkInfo("New message exists in the inbox", "true");
        Assert.assertTrue(isElementVisible(new By.ByXPath(String.format(MSG_FROM_EMAIL_LOCATOR_TEMPLATE, email))));

    }
*/
    public void goLastUnreadMessage(String email) {
     btnLastMsg.click();
    }

    public void assertMessageBody(String expectedText) {
        assertinfo(lblMessageBody.getWrappedElement().getText(), expectedText);
        Assert.assertTrue(lblMessageBody.getText().contains(expectedText));

    }
}
