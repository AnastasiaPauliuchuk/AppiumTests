package tests.mobile;

import base.page.PageManager;
import base.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.mobile.EmailLoginPage;
import pages.mobile.EmailNewAccountPage;
import pages.web.GmailMailboxPage;
import pages.web.GmailPasswordPage;
import pages.web.GmailStartPage;
import utils.MailUtils;

public class GmailTest extends BaseTest {

    private static String username;
    private static String password;
    private static String mailText;

    @BeforeTest
    @Parameters({"username", "password", "mailText"})
    public void setUp(String username, String password, String mailText) {
        GmailTest.username = username;
        GmailTest.password = password;
        GmailTest.mailText = mailText;

    }

    @Override
    public void runTest() {

        EmailNewAccountPage emailNewAccountPage = PageManager.createPage(EmailNewAccountPage.class, "Start Page");
        emailNewAccountPage.goNewAccount();

        EmailLoginPage emailLoginPage = PageManager.createPage(EmailLoginPage.class, "Login Page");
        emailLoginPage.login(username,password);
        /*GmailStartPage gmailStartPage = PageManager.createPage(GmailStartPage.class, "Gmail Login Page");
        step(1, "Enter and submit the username");
        gmailStartPage.enterLogin(username);
        gmailStartPage.submitLogin();
        GmailPasswordPage gmailPasswordPage = PageManager.createPage(GmailPasswordPage.class, "Gmail Password Page");

        step(2, "Enter and submit the password");
        gmailPasswordPage.authorize(password);
        GmailMailboxPage gmailMailboxPage = PageManager.createPage(GmailMailboxPage.class, "Gmail Mailbox Page ");
        step(3, "Send the message to yourself");
        gmailMailboxPage.compose();
        String email = MailUtils.gmailFromUsername(username);
        gmailMailboxPage.sendNewMessage(email, mailText);

        step(4, "Open the inbox folder");
        gmailMailboxPage.openInboxAfterMsgSent();

        step(5, "Open the message");
        gmailMailboxPage.goLastUnreadMessage(email);
        check("Verify the message body");
        gmailMailboxPage.assertMessageBody(mailText);*/
    }
}
