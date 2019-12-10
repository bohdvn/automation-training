package by.bsu.rent.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends AbstractPage {
    private final String PAGE_URL = "https://www.sixt.com/#/reservation/offerlist";
    private final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(id = "currency-switcher")
    private WebElement currencySwitcher;

    @FindBy(className = "Price__currency")
    private WebElement priceCurrencyForFirstCar;

    @FindBy(xpath = "//input[@value='EUR (€)']")
    private WebElement euroCurrency;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public SearchResultPage openPage() {
        driver.navigate().to(PAGE_URL);
        LOGGER.info("Search result page opened");
        return this;
    }

    public SearchResultPage changeCurrencyToEuro() {
        currencySwitcher.click();
        euroCurrency.click();
        focusAway();
        LOGGER.info("Currency changed to euro");
        return this;

    }

    public String getCurrentCurrency() {
        return priceCurrencyForFirstCar.getText();
    }

}
