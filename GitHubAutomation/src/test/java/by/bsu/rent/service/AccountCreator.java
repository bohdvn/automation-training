package by.bsu.rent.service;

import by.bsu.rent.model.Account;

public class AccountCreator {
    private static final String TESTDATA_CASE_9_ACCOUNT_EMAIL = "testdata.case9.account.email";
    private static final String TESTDATA_CASE_9_ACCOUNT_PASSWORD = "testdata.case9.account.password";

    private static final String TESTDATA_CASE_10_ACCOUNT_EMAIL = "testdata.case10.account.email";

    public static Account withCorrectEmailAndPassword() {
        return new Account(TestDataReader.getTestData(TESTDATA_CASE_9_ACCOUNT_EMAIL),
                TestDataReader.getTestData(TESTDATA_CASE_9_ACCOUNT_PASSWORD));
    }

    public static Account withNotRegisteredEmail() {
        return new Account().setEmail(TestDataReader.getTestData(TESTDATA_CASE_10_ACCOUNT_EMAIL));
    }
}
