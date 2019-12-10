package by.bsu.rent.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    @FindBy(xpath = "//body")
    private WebElement body;

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public abstract AbstractPage openPage();

    protected void focusAway() {
        body.click();
        LOGGER.info("Focused away");
    }

    protected void waitUntil(ExpectedCondition<WebElement> expectedCondition) {
        LOGGER.info("Waiting until " + expectedCondition + "...");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(expectedCondition);
        LOGGER.info("Finish waiting");
    }
}