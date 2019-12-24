package by.bsu.rent.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String SYSTEM_PROPERTY_BROWSER = "browser";
    private static final String SYSTEM_PROPERTY_BROWSER_FIREFOX = "firefox";

    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
//            switch (System.getProperty(SYSTEM_PROPERTY_BROWSER)) {
//                case SYSTEM_PROPERTY_BROWSER_FIREFOX: {
//                    WebDriverManager.firefoxdriver().setup();
//                    driver = new FirefoxDriver();
//                    LOGGER.info("Created Firefox driver");
//                }
//                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    LOGGER.info("Created Chrome driver");
//
//                }
//            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
        LOGGER.info("Driver closed");
    }
}