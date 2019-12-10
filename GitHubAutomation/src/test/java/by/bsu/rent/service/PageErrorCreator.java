package by.bsu.rent.service;

import by.bsu.rent.model.PageError;

public class PageErrorCreator {
    private static final String TESTDATA_CASE_1_EXPECTED_MESSAGE = "testdata.case1.expected.message";
    private static final String TESTDATA_CASE_2_EXPECTED_MESSAGE = "testdata.case2.expected.message";
    private static final String TESTDATA_CASE_3_EXPECTED_MESSAGE = "testdata.case3.expected.message";
    private static final String TESTDATA_CASE_4_EXPECTED_MESSAGE = "testdata.case4.expected.message";
    private static final String TESTDATA_CASE_5_EXPECTED_MESSAGE = "testdata.case5.expected.message";
    private static final String TESTDATA_CASE_6_EXPECTED_MESSAGE = "testdata.case6.expected.message";
    private static final String TESTDATA_CASE_7_EXPECTED_MESSAGE = "testdata.case7.expected.message";
    private static final String TESTDATA_CASE_10_EXPECTED_MESSAGE = "testdata.case10.expected.message";

    public static PageError errorForNegativeRentalPeriodFromProperty() {
        return new PageError(TestDataReader.getTestData(TESTDATA_CASE_1_EXPECTED_MESSAGE));
    }

    public static PageError errorForRentalPeriodMoreThanYearFromProperty() {
        return new PageError(TestDataReader.getTestData(TESTDATA_CASE_2_EXPECTED_MESSAGE));
    }

    public static PageError errorForNotAvailablePlaceFromProperty() {
        return new PageError(TestDataReader.getTestData(TESTDATA_CASE_3_EXPECTED_MESSAGE));
    }

    public static PageError errorForCurrentPickUpDateFromProperty() {
        return new PageError(TestDataReader.getTestData(TESTDATA_CASE_4_EXPECTED_MESSAGE));
    }

    public static PageError errorForPastPickUpDateFromProperty() {
        return new PageError(TestDataReader.getTestData(TESTDATA_CASE_5_EXPECTED_MESSAGE));
    }

    public static PageError errorForPickUpAndReturnPlacesAcrossContinentsFromProperty() {
        return new PageError(TestDataReader.getTestData(TESTDATA_CASE_6_EXPECTED_MESSAGE));
    }

    public static PageError errorForEmptyFieldsFromProperty() {
        return new PageError(TestDataReader.getTestData(TESTDATA_CASE_7_EXPECTED_MESSAGE));
    }

    public static PageError errorForNotRegisteredEmailFromProperty() {
        return new PageError(TestDataReader.getTestData(TESTDATA_CASE_10_EXPECTED_MESSAGE));
    }
}