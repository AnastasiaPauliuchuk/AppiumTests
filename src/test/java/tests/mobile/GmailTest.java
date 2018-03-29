package tests.mobile;

import base.page.PageManager;
import base.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.mobile.EmailInboxPage;
import pages.mobile.EmailMsgPage;
import pages.mobile.EmailNewMsgPage;
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

     /*  EmailNewAccountPage emailNewAccountPage = PageManager.createPage(EmailNewAccountPage.class, "Start Page");
        emailNewAccountPage.goNewAccount();

        EmailLoginPage emailLoginPage = PageManager.createPage(EmailLoginPage.class, "Login Page");
        emailLoginPage.login(MailUtils.gmailFromUsername(username),password);


        GmailLoginPage gmailLoginPage = PageManager.createPage(GmailLoginPage.class, "Gmail Login Page");
        gmailLoginPage.enterEmail(MailUtils.gmailFromUsername(username));

        GmailPasswordPage gmailPasswordPage = PageManager.createPage(GmailPasswordPage.class, "Gmail Password Page");
        gmailPasswordPage.enterPassword(password);*/

        EmailInboxPage inboxPage = PageManager.createPage(EmailInboxPage.class, "Inbox Page");
        inboxPage.openCompose();
        EmailNewMsgPage emailNewMsgPage = PageManager.createPage(EmailNewMsgPage.class, "New message Page");
        String email = MailUtils.gmailFromUsername(username);
        emailNewMsgPage.sendNewMessage(email,mailText);
        inboxPage = PageManager.createPage(EmailInboxPage.class, "Inbox Reloaded Page");
        inboxPage.goLastMessage();

        EmailMsgPage emailMsgPage = PageManager.createPage(EmailMsgPage.class, "MessagePage");
        emailMsgPage.assertMessageBody(username,mailText);



        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
