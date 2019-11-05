package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class HomePageTest {
    private WebDriver driver;
    private HomePage page;

    @Before
    public void setUpChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        page = new HomePage(driver);
        driver.manage().window().maximize();
    }

    @After
    public void tearDownChromeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Test
    public void noStationsAvailableNearbyTest() {
        String pickUpLocation = "North Korea";
        page.inputPickUpLocation(pickUpLocation);
        String errorMessage = "Sorry, but there are no SIXT stations available near North Korea!";
        assertTrue(page.checkErrorMessage(errorMessage));
    }

    @Test
    public void offerToRegisterIfEmailNotFoundTest() {
        page.clickLoginButton();
        String notFoundEmail = "udg79679@bcaoo.com";
        page.inputEmail(notFoundEmail);
        String offerMessage = "udg79679@bcaoo.com looks new to us.\nWe would be happy to get to know you. Register now!";
        assertTrue(page.checkOfferMessage(offerMessage));
    }
} 