package tests;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.PropertiesResourceManager;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {


    protected Logger logger = Logger.getLogger(BaseTest.class);

    protected AndroidDriver driver;
    private static final String PROPERTIES_FILE = "capabilities.properties";
    private static final String APPIUM_URL = "http://0.0.0.0:4723/wd/hub";
    private static final String START_URL = "http://gmail.com";

    @BeforeClass
    public void setUp () throws MalformedURLException {
        PropertiesResourceManager propManager = new PropertiesResourceManager(PROPERTIES_FILE);
        Map<String,String> capabilityMap = propManager.getAllProperties();
        DesiredCapabilities capabilities =  new DesiredCapabilities();
        for(Map.Entry<String, String> cap : capabilityMap.entrySet() ) {
            capabilities.setCapability(cap.getKey(),cap.getValue());
        }

      /*  Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", propManager.getProperty("deviceName"));
*/
      /*  ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("androidPackage", "com.android.chrome");

        File myFile = null;
        URL myTestURL;
        myTestURL = ClassLoader.getSystemResource("chromedriver.exe");
        try {
            myFile = new File(myTestURL.toURI());
        } catch (URISyntaxException e1) {

        }
        System.setProperty("webdriver.chrome.driver", myFile.getAbsolutePath());

        WebDriver driver = new ChromeDriver(chromeOptions);*/
        driver = new AndroidDriver (new URL(APPIUM_URL), capabilities);
        driver.get(START_URL);
        logger.info(driver.getTitle());

    }

    @AfterClass
    public void tearDown()  {
        driver.quit();
    }


}
