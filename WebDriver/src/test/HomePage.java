package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertTrue;

public class HomePage {
    private WebDriver driver;

    @Before
    public void setUpChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.sixt.com");
    }

    @After
    public void tearDownChromeDriverQuit() {
        driver.quit();
        driver = null;
    }

    @Test
    public void noStationsAvailableNearbyTest() {
        WebElement searchInput = driver.findElement(By.className("SearchInput__isPickupAsReturn"));
        searchInput.sendKeys("North Korea");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", searchInput);
        WebElement error = driver.findElement(By.className("ErrorMessage__message"));
        String errorMessage = "Sorry, but there are no SIXT stations available near North Korea!";
        boolean isErrorMessageCorrect = error.getText().equals(errorMessage);
        assertTrue(isErrorMessageCorrect && error.isDisplayed());
    }

    @Test
    public void offerToRegisterIfEmailNotFindTest() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.className("LoginButton__wrapper")));
        WebElement emailInput = driver.findElement(By.className("floatl__input"));
        emailInput.sendKeys("udg79679@bcaoo.com");
        emailInput.submit();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.className("EmailAddressForm__overtitle"))));
        String offerMessage = "udg79679@bcaoo.com looks new to us.\nWe would be happy to get to know you. Register now!";
        WebElement offer = driver.findElement(By.className("MultiPagesFormBundle__subline"));
        boolean isOfferMessageCorrect = offer.getText().equals(offerMessage);
        System.out.println(offer.getText());
        assertTrue(isOfferMessageCorrect && offer.isDisplayed());
    }
}