package by.bsu.rent.page;

import by.bsu.rent.model.Account;
import by.bsu.rent.model.PageError;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {
    private final Logger LOGGER = LogManager.getRootLogger();
    private final String PAGE_URL = "https://www.sixt.com/#/?page=loginregister";
    private final WebDriverWait wait;

    @FindBy(id = "email_field")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(className = "OfferToRegister__offerText")
    private WebElement offerToRegister;

    @FindBy(xpath = "//input[@value='Log in']")
    private WebElement submitButton;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    @Override
    public LoginPage openPage() {
        driver.navigate().to(PAGE_URL);
        LOGGER.info("Login page opened");
        return this;
    }

    public HomePage login(Account account) {
        account.getEmail().ifPresent(this::inputEmail);
        account.getPassword().ifPresent(this::inputPassword);
        submitButton.click();
        LOGGER.info("Clicked 'Log in' button.");
        return new HomePage(driver);
    }


    public void inputEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        emailInput.submit();
        wait.until(ExpectedConditions
                .stalenessOf(driver.findElement(By.id("pageSlideWrapper"))));
        LOGGER.info("Filled 'Email' field with " + email);
        focusAway();
    }

    public void inputPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        LOGGER.info("Filled 'Password' field with " + password);
        focusAway();
    }

    public boolean checkOfferToRegisterMessage(PageError error) {
        return offerToRegister.isDisplayed()
                && offerToRegister.getText().
                contains(error.getErrorDescription());
    }

}
