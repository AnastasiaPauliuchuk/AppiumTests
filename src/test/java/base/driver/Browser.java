package base.driver;

import base.Base;
import base.logging.BaseLogger;
import base.logging.BrowserLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utils.PropertiesResourceManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Browser extends Base {


    private static Browser instance;
    private static AndroidDriver driver;
    private static final String PROPERTIES_FILE = "mobile.capabilities.properties";
    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";
    private static final String START_URL = "http://gmail.com";
    private static final String timeoutForLoad = "60";
    private static String timeoutForCondition = "30";
    public static  String currentBrowser = "Chrome";

    private Browser() {
        info("constructed");
    }

    public static Browser getInstance() {
        if (instance == null) {


            try {
                driver = initDriver();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            instance = new Browser();
        }
        return instance;
    }

    private static AndroidDriver initDriver()  throws MalformedURLException {
        PropertiesResourceManager propManager = new PropertiesResourceManager(PROPERTIES_FILE);
        Map<String, String> capabilityMap = propManager.getAllProperties();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        for (Map.Entry<String, String> cap : capabilityMap.entrySet()) {
            capabilities.setCapability(cap.getKey(), cap.getValue());
        }

        return new AndroidDriver(new URL(APPIUM_URL), capabilities);


    }

    public AppiumDriver getDriver() {
        return driver;
    }

    @Override
    protected BaseLogger createLoggerFactoryMethod() {
        return new BrowserLogger();
    }

    public void open() {


       // driver.get(START_URL);
       /* try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }
    public void close() {
        try {
            driver.quit();
            info("close");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            instance = null;
        }
    }

    public String getTimeoutForCondition() {
        return timeoutForCondition;
    }

    public String getTimeoutForLoad() {
        return timeoutForLoad;
    }


    public Wait<WebDriver> getWait() {
        return new FluentWait<WebDriver>(instance.getDriver())
                .withTimeout(Long.parseLong(instance.getTimeoutForLoad()), SECONDS)
                .pollingEvery(Long.parseLong(instance.getTimeoutForCondition()), SECONDS)
                .ignoring(NoSuchElementException.class);
    }
}
