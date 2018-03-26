package utils;

/**
 * @author Anastasia Pauliuchuk
 *         created:  1/25/2018.
 */
public class MailUtils {

    private static final String GMAIL_SUFFIX = "gmail.com";

    public static String gmailFromUsername(String username) {
        return String.format("%1$s@%2$s", username, GMAIL_SUFFIX);
    }
}
