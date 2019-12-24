package by.bsu.rent.test;

import by.bsu.rent.page.SearchResultPage;
import by.bsu.rent.service.TestDataReader;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SearchResultPageTests extends CommonConditions {
    private static final String TESTDATA_CASE_8_EXPECTED_CURRENCY = "€";

    @Test(testName = "testcase 8: One can change currency")
    public void changingCurrencyToEuroTest() {
        String currentCurrency = new SearchResultPage(driver)
                .openPage()
                .changeCurrencyToEuro()
                .getCurrentCurrency();
        assertThat(currentCurrency, is(equalTo(TESTDATA_CASE_8_EXPECTED_CURRENCY)));
    }
}
