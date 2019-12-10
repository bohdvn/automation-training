package by.bsu.rent.page;

import by.bsu.rent.model.CarReservation;
import by.bsu.rent.model.PageError;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private final String HOMEPAGE_URL = "https://www.sixt.com/#/";
    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    public HomePage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        LOGGER.info("Home page opened");
        return this;
    }

    @FindBy(xpath = "//input[@id='pickupStation']")
    private WebElement pickUpLocationInput;

    @FindBy(xpath = "//input[@id='returnStation']")
    private WebElement returnLocationInput;

    @FindBy(xpath = "//input[@id='returnToPickupStation']")
    private WebElement showReturnLocationInput;

    @FindBy(xpath = "//input[@id='pickupDate']")
    private WebElement pickUpDateInput;

    @FindBy(xpath = "//input[@id='returnDate']")
    private WebElement returnDateInput;

    @FindBy(className = "LocationError__errorText")
    private WebElement placeError;

    @FindBy(className = "OfferError__errorText")
    private WebElement timeError;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    @FindBy(className = "LoginButton__circleLabel")
    private WebElement loggedInUserName;


    public void search() {
        searchButton.click();
        LOGGER.info("Searching...");
    }

    public LoginPage openLoginPage() {
        LOGGER.info("Login Page opening...");
        loginButton.click();
        return new LoginPage(driver);
    }

    public HomePage fillFromParams(CarReservation params) {
        params.getPlaceFrom().ifPresent(this::inputPickUpLocation);
        params.getPlaceTo().ifPresent(this::inputReturnLocation);
        params.getReservationDates().ifPresent(e -> {
            e.getPickUpDate().ifPresent(this::inputPickUpDate);
            e.getReturnDate().ifPresent(this::inputReturnDate);
        });
        LOGGER.info("Filled cars search params");
        return this;
    }

    public HomePage inputPickUpLocation(String pickUpLocation) {
        pickUpLocationInput.click();
        pickUpLocationInput.clear();
        pickUpLocationInput.sendKeys(pickUpLocation);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LOGGER.info("Filled 'Pick-up location' field with " + pickUpLocation);
        focusAway();
        return this;
    }

    public HomePage inputReturnLocation(String returnLocation) {
        showReturnLocationInput.click();
        returnLocationInput.click();
        returnLocationInput.clear();
        returnLocationInput.sendKeys(returnLocation);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LOGGER.info("Filled 'Return location' field with " + returnLocation);
        focusAway();
        return this;
    }

    public HomePage inputPickUpDate(String pickUpDate) {
        pickUpDateInput.click();
        pickUpDateInput.clear();
        pickUpDateInput.sendKeys(pickUpDate);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LOGGER.info("Filled 'Pick-up date' field with " + pickUpDate);
        focusAway();
        return this;
    }

    public HomePage inputReturnDate(String returnDate) {
        returnDateInput.click();
        returnDateInput.clear();
        returnDateInput.sendKeys(returnDate);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LOGGER.info("Filled 'Return date' field with " + returnDate);
        focusAway();
        return this;
    }

    public String getLoggedInUserName() {
        return loggedInUserName.getText();
    }

    public boolean checkPlaceErrorMessage(PageError error) {
        return placeError.isDisplayed()
                && placeError.getText().
                contains(error.getErrorDescription());
    }

    public boolean checkTimeErrorMessage(PageError error) {
        return placeError.isDisplayed()
                && placeError.getText().
                contains(error.getErrorDescription());
    }
}