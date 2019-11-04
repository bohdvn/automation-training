package test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private final String HOMEPAGE_URL = "https://www.sixt.com";
    private final int WAIT_TIMEOUT_SECONDS = 30;

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(HOMEPAGE_URL);
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    @FindBy(xpath = "//*[@id=\"pickupStation\"]")
    private WebElement pickUpLocationInput;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[2]/div[1]/div/div/div/div[2]/div/span/div/div/div[2]/div/div/div[2]")
    private WebElement locationError;

    @FindBy(xpath = "//*[@id=\"pageSlideWrapper\"]/div/div[2]/form/div[1]/div/div/div/input")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"pageSlideWrapper\"]/div/div[2]/form/div[1]/p")
    private WebElement offerToRegister;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[1]/div/div[5]/div/span")
    private WebElement loginButton;

    public void inputPickUpLocation(String pickUpLocation) {
        pickUpLocationInput.click();
        pickUpLocationInput.clear();
        pickUpLocationInput.sendKeys(pickUpLocation);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void inputEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        emailInput.submit();
        wait.until(ExpectedConditions
                .stalenessOf(driver
                .findElement(By.xpath("//*[@id=\"pageSlideWrapper\"]/div/div[2]/form/div[1]/h4"))));
    }

    public void checkErrorMessage(String errorMessage) {
        Assert.assertTrue("Error message should be present",
                locationError.isDisplayed());
        Assert.assertTrue("Error message should contains " + errorMessage,
                locationError.getText().contains(errorMessage));
    }

    public void checkOfferMessage(String offerMessage) {
        Assert.assertTrue("Offer message should be present",
                offerToRegister.isDisplayed());
        Assert.assertTrue("Offer message should contains " + offerMessage,
                offerToRegister.getText().contains(offerMessage));
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
