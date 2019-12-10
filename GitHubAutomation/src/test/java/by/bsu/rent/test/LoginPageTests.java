package by.bsu.rent.test;

import by.bsu.rent.model.Account;
import by.bsu.rent.model.PageError;
import by.bsu.rent.page.LoginPage;
import by.bsu.rent.service.AccountCreator;
import by.bsu.rent.service.PageErrorCreator;
import by.bsu.rent.service.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class LoginPageTests extends CommonConditions {
    private static final String TESTDATA_CASE_9_EXPECTED_NAME = "testdata.case9.expected.name";

    @Test(testName = "testcase 9: One can login SIXT")
    public void loginToSixtTest() {
        Account testAccount = AccountCreator.withCorrectEmailAndPassword();
        String loggedInUserName = new LoginPage(driver)
                .openPage()
                .login(testAccount)
                .getLoggedInUserName();
        assertThat(loggedInUserName, is(equalTo(TestDataReader.getTestData(TESTDATA_CASE_9_EXPECTED_NAME))));
    }

    @Test(testName = "testcase 10: Login with not registered email")
    public void loginWithNotRegisteredEmailTest() {
        Account testAccount = AccountCreator.withNotRegisteredEmail();
        LoginPage page = new LoginPage(driver);
        page.login(testAccount);
        PageError expectedError = PageErrorCreator.errorForNotRegisteredEmailFromProperty();
        Assert.assertTrue(page.checkOfferToRegisterMessage(expectedError));
    }


}
