package selenium;

import java.io.File;
import org.apache.commons.lang3.SystemUtils;
import common.*;
import util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.PropertyFileReader;

public class BaseTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);
    private static ThreadLocal<BaseTest> instance = new ThreadLocal<>();
	
    private WebDriver driver;
    private String browser;
    private String url;
    
    private BaseTest() {
        PropertyFileReader propertyFileReader = new PropertyFileReader(Constants.CONFIG_FILE_NAME);
        browser = propertyFileReader.getProperty("browser");
        url = propertyFileReader.getProperty("url");
    }

    public static WebDriver getDriver() {
        return getInstance().driver;
    }

    public static BaseTest getInstance() {
        if (instance.get() == null) {
            instance.set(new BaseTest());
        }
        return instance.get();
    }

    public void openBrowser() {
        String browserType = getBrowser();
        if (browserType.equalsIgnoreCase("Chrome")) {
            String chromeFilePath = System.getProperty("user.dir") + File.separator + "target" + File.separator + "chromedriver" + (SystemUtils.IS_OS_WINDOWS ? ".exe" : "");
            System.setProperty("webdriver.chrome.driver", chromeFilePath);
            ChromeDriverService driverService = ChromeDriverService.createDefaultService(); 
            setDriver(new ChromeDriver(driverService));
            LOGGER.info("Opening Chrome Browser");
        }else if(browserType.equalsIgnoreCase("Firefox")){
            String ffFilePath = System.getProperty("user.dir") + File.separator + "target" + File.separator + "geckodriver" + (SystemUtils.IS_OS_WINDOWS ? ".exe" : "");
            System.setProperty("webdriver.geckodriver.driver", ffFilePath);
            setDriver(new FirefoxDriver());
        }
        getDriver().manage().window().maximize();
    }

    private void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getBrowser() {
        return browser;
    }

    public void navigateToURL() {
        getDriver().get(url);
        LOGGER.info("Navigated to url " + getDriver().getTitle());
    }

    public void closeBrowser() {
    	BaseTest.getDriver().quit();
        driver = null;
    }
}
