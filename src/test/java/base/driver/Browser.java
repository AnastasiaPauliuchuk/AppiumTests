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
    private static final String CAPABILITIES_PROPERTIES = "mobile.capabilities.properties";
    private static final String APPIUM_PROPERTIES = "appium.properties";

    private static final String WEB_CONTEXT = "web";
    private static final String NATIVE_CONTEXT = "native";

    private static  String appiumURL ;
    private static  String startURL ;
    private static  String timeoutForLoad ;
    private static String timeoutForCondition ;
    public static  String currentBrowser;
    private static  String context;

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


        PropertiesResourceManager propManager = new PropertiesResourceManager(CAPABILITIES_PROPERTIES);
        Map<String, String> capabilityMap = propManager.getAllProperties();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        for (Map.Entry<String, String> cap : capabilityMap.entrySet()) {
            capabilities.setCapability(cap.getKey(), cap.getValue());
        }

        propManager = new PropertiesResourceManager(APPIUM_PROPERTIES);
        appiumURL = propManager.getProperty("appiumURL");
        startURL = propManager.getProperty("startURL","");
        currentBrowser = propManager.getProperty("currentBrowser","");
        timeoutForCondition = propManager.getProperty("timeoutForCondition","30");
        timeoutForLoad = propManager.getProperty("timeoutForLoad","60");
        context = propManager.getProperty("context",WEB_CONTEXT);
        return new AndroidDriver(new URL(appiumURL), capabilities);


    }

    public AppiumDriver getDriver() {
        return driver;
    }

    @Override
    protected BaseLogger createLoggerFactoryMethod() {
        return new BrowserLogger();
    }

    public void open() {

        if(context.equals(WEB_CONTEXT))
             driver.get(startURL);


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
